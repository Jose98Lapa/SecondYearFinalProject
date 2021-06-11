package eapli.base.workflow.engine;

import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;
import eapli.base.task.domain.ApprovalTask;
import eapli.base.task.domain.ExecutionTask;
import eapli.base.team.domain.Team;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketAutomaticTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.workflow.engine.client.Constants;
import eapli.base.workflow.engine.client.TcpExecuterClient;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Engine {

    TreeMap<Date, Collaborator> historyExecution = new TreeMap<>();
    TreeMap<Date, Collaborator> historyApproval = new TreeMap<>();


    public static void main(String[] args) {

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(),
                new PlainTextEncoder());

        TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
        Timer timer = new Timer();
        List<Ticket> previousState = new ArrayList<>();
        ticketRepository.findAll().forEach(previousState::add);


        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                engine(ticketRepository, previousState);
            }
        }, 0, 1000);

    }

    private static void engine(TicketRepository ticketRepository, List<Ticket> previousState) {
        ticketRepository = PersistenceContext.repositories().tickets();
        List<Ticket> currentState = new ArrayList<>();
        List<Ticket> lambdaPreviousState = previousState;
        ticketRepository.findAll().forEach(currentState::add);
        AtomicInteger modCount = new AtomicInteger();

        currentState.forEach(currentStateTicket ->
                lambdaPreviousState.forEach(
                        previousStateTicket ->
                        {
                            if (!(previousStateTicket
                                    .status()
                                    .equals(currentStateTicket.status()))) {
                                moveStateFlow(currentStateTicket);
                                modCount.getAndIncrement();
                            }
                        }
                )
        );

        currentState.forEach(ticketRepository::save);

        previousState = currentState;
    }

    private static void moveStateFlow(Ticket currentStateTicket) {

        switch (currentStateTicket.status().toString()) {
            case Constants.PENDING:
                System.out.println("Pending->WAITING");
                currentStateTicket.statusWaitingApproval();
                break;

            case Constants.APPROVED:
                System.out.println("Approved->PENDINGEX");

                currentStateTicket.statusPendingExecution();
                break;

            case Constants.NOT_APPROVED:
                System.out.println("NOT_APPROVED");

                currentStateTicket.statusFailed();
                break;

            case Constants.PENDING_EXECUTION:
                System.out.println("pendeexe");
                currentStateTicket.statusExecuting();
                break;
            case Constants.EXECUTING:
                System.out.println("exe");
                if (currentStateTicket.workflow().starterTask() instanceof TicketAutomaticTask) {
                    try {
                        TcpExecuterClient client = new TcpExecuterClient();
                        client.startConnection(Application.settings().getIpAutomatictaskExecutor());
                        client.executeAutomaticTask(((TicketAutomaticTask) currentStateTicket.workflow().starterTask()).scriptPath().toString());
                        client.stopConnection();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (currentStateTicket.workflow().starterTask().transition().hasNextTask()
                        && currentStateTicket.workflow().starterTask().transition().nextTask() instanceof TicketAutomaticTask) {
                    try {
                        TcpExecuterClient client = new TcpExecuterClient();
                        client.startConnection(Application.settings().getIpAutomatictaskExecutor());
                        client.executeAutomaticTask(((TicketAutomaticTask) currentStateTicket.workflow().starterTask()).scriptPath().toString());
                        client.stopConnection();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public synchronized Ticket FCFS(Ticket ticket) {
        Collaborator selected = null;
        if (ticket.workflow().starterTask() instanceof TicketExecutionTask) {
            selected = assignCollaboratorExecution(ticket);
            ((TicketExecutionTask) ticket.workflow().starterTask()).setExecutedBy(selected);
        } else if (ticket.workflow().starterTask() instanceof TicketApprovalTask){
            selected = assignCollaboratorApproval(ticket);
            ((TicketApprovalTask) ticket.workflow().starterTask()).setApprovedBy(selected);
        }
        return ticket;
    }

    public synchronized Collaborator assignCollaboratorExecution(Ticket ticket) {

        TeamRepository teamRepository = PersistenceContext.repositories().teams();

        Collaborator theChosenOne = null;
        ArrayList<Collaborator> collaborators = new ArrayList<>();
        ArrayList<Team> execTeams = new ArrayList<>();
        ArrayList<Team> execTeamsUpdated = new ArrayList<>();
        Service svr = ticket.service();

        if (svr.workflow().starterTask() instanceof ExecutionTask) {
            execTeams.addAll(((ExecutionTask) svr.workflow().starterTask()).executingTeams());
        }
        for (Team t : execTeams) { //update teams
            execTeamsUpdated.add(teamRepository.ofIdentity(t.identity()).get());
        }
        execTeams.clear();// delete old list
        for (Team t : execTeamsUpdated) { //save updated collaborators
            collaborators.addAll(t.teamMembers());
        }
        for (Date date : historyExecution.keySet()) {
            if (!collaborators.contains(historyExecution.get(date))) {//se algum colaborador for removido retira do historico
                historyExecution.remove(date);
            }
        }
        for (Collaborator collab : collaborators) { //verificar se existe algum que ainda nao tenha feito nada
            if (!historyExecution.containsValue(collab)) {
                theChosenOne = collab;
                historyExecution.put(new Date(), collab);
            }
        }
        if (theChosenOne == null) { //se todos ja tiverem feito pelo menos um, vai verificar o que fez ha mais tempo
            for (Date date:historyExecution.keySet()) {
                if (collaborators.contains(historyExecution.get(date))){
                    theChosenOne = historyExecution.get(date);
                    historyExecution.put(new Date(), historyExecution.remove(date));
                }
            }
        }
        return theChosenOne;
    }

    public synchronized Collaborator assignCollaboratorApproval(Ticket ticket) {
        CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();

        Collaborator theChosenOne = null;
        ArrayList<Collaborator> collaborators = new ArrayList<>();
        Service svr = ticket.service();

        if (svr.workflow().starterTask() instanceof ApprovalTask) {
            collaborators.addAll((Collection<? extends Collaborator>) collaboratorRepository.getCollaboratorsByRole(
                    ((ApprovalTask) svr.workflow().starterTask()).necessaryRoleForApproval())
            ); // base de dados colab by role
        }

        for (Date date : historyApproval.keySet()) {
            if (!collaborators.contains(historyApproval.get(date))) {//se algum colaborador for removido retira do historico
                historyApproval.remove(date);
            }
        }
        for (Collaborator collab : collaborators) { //verificar se existe algum que ainda nao tenha feito nada
            if (!historyApproval.containsValue(collab)) {
                theChosenOne = collab;
                historyApproval.put(new Date(), collab);
            }
        }
        if (theChosenOne == null) { //se todos ja tiverem feito pelo menos um, vai verificar o que fez ha mais tempo que tem permissoes
            for (Date date:historyApproval.keySet()) {
                if (collaborators.contains(historyApproval.get(date))){
                    theChosenOne = historyApproval.get(date);
                    historyApproval.put(new Date(), historyApproval.remove(date));
                }
            }
        }
        return theChosenOne;
    }
}
