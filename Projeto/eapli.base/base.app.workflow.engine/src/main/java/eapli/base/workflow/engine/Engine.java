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
import eapli.base.ticket.application.TicketListService;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.Urgency;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.application.TicketTaskService;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketAutomaticTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.ticketTask.domain.TicketTask;
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
        } else if (ticket.workflow().starterTask() instanceof TicketApprovalTask) {
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
            for (Date date : historyExecution.keySet()) {
                if (collaborators.contains(historyExecution.get(date))) {
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
            for (Date date : historyApproval.keySet()) {
                if (collaborators.contains(historyApproval.get(date))) {
                    theChosenOne = historyApproval.get(date);
                    historyApproval.put(new Date(), historyApproval.remove(date));
                }
            }
        }
        return theChosenOne;
    }

    public synchronized void assigningAlgorithm() {
        List<Ticket> ticketList = PersistenceContext.repositories().tickets().getPendingTicket();
        for (Ticket ticket : ticketList) {
            if (ticket.workflow().getFirstIncompleteTask().getClass() == TicketApprovalTask.class) {
                chooseApprovalCollaborator(ticket);
            }else if (ticket.workflow().getFirstIncompleteTask().getClass()==TicketExecutionTask.class){
                chooseExecutionCollaborator(ticket);
            }
        }

    }

    private synchronized void chooseApprovalCollaborator(Ticket ticket) {
        Map<Collaborator, Long> collaboratorAndTotalTaskTime = new HashMap<>();
        Map<Collaborator, Float> collaboratorAndFitnessMap = new HashMap<>();
        TicketTask ticketTask = ticket.workflow().getFirstIncompleteTask();
        ApprovalTask approvalTask = (ApprovalTask) ticketTask.mainReference();
        long allCollaboratorTime = 0;
        for (Collaborator collaborator : PersistenceContext.repositories().collaborators().getCollaboratorsByRole(approvalTask.necessaryRoleForApproval())) {
            long timeToFinishAllTasks = new TicketTaskService().getTimeToFinishAllTasks(collaborator);
            allCollaboratorTime += timeToFinishAllTasks;
            collaboratorAndTotalTaskTime.put(collaborator, timeToFinishAllTasks);
            collaboratorAndFitnessMap.put(collaborator, new TicketListService().getCollaboratorPerformanceInApprovalTasks(ticket, collaborator));
        }
        chooseCollaborator(ticket, collaboratorAndTotalTaskTime, collaboratorAndFitnessMap, ticketTask, allCollaboratorTime, null);
    }

    private synchronized void chooseExecutionCollaborator(Ticket ticket){
        TicketTask ticketTask = ticket.workflow().getFirstIncompleteTask();
        if (ticketTask.transition()!=null&&ticketTask.transition().hasPreviousTask()&&ticketTask.transition().previousTask().getClass()==TicketExecutionTask.class){
            TicketExecutionTask ticketExecutionTask = (TicketExecutionTask) ticketTask.transition().previousTask();
            new TicketTaskService().addCollaborator(ticketTask,ticketExecutionTask.collaborator());
            return;
        }
        Map<Collaborator, Long> collaboratorAndTotalTaskTime = new HashMap<>();
        Map<Collaborator, Float> collaboratorAndFitnessMap = new HashMap<>();
        ExecutionTask executionTask = (ExecutionTask) ticketTask.mainReference();
        long allCollaboratorTime = 0;
        for (Collaborator collaborator:new TicketTaskService().getCollaboratorByTicketTask(ticketTask)){
            long timeToFinishAllTasks = new TicketTaskService().getTimeToFinishAllTasks(collaborator);
            allCollaboratorTime += timeToFinishAllTasks;
            collaboratorAndTotalTaskTime.put(collaborator, timeToFinishAllTasks);
            collaboratorAndFitnessMap.put(collaborator, new TicketListService().getCollaboratorPerformanceInApprovalTasks(ticket, collaborator));
        }

        chooseCollaborator(ticket, collaboratorAndTotalTaskTime, collaboratorAndFitnessMap, ticketTask, allCollaboratorTime, null);

    }

    private synchronized void chooseCollaborator(Ticket ticket, Map<Collaborator, Long> collaboratorAndTotalTaskTime, Map<Collaborator, Float> collaboratorAndFitnessMap, TicketTask ticketTask, long allCollaboratorTime, Collaborator collaborator) {
        boolean add = allCollaboratorTime > (long) collaboratorAndTotalTaskTime.size() * 5 * 60;

        List<Map.Entry<Collaborator, Long>> list
                = new LinkedList<>(
                collaboratorAndTotalTaskTime.entrySet());


        list.sort(Map.Entry.comparingByValue());

        // put data from sorted list to hashmap
        HashMap<Collaborator, Long> temp
                = new LinkedHashMap<>();
        for (Map.Entry<Collaborator, Long> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        if (ticket.urgency().equals(Urgency.valueOf("urgente"))) {
            List<Map.Entry<Collaborator, Float>> listValue
                    = new LinkedList<>(
                    collaboratorAndFitnessMap.entrySet());


            list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            // put data from sorted list to hashmap
            HashMap<Collaborator, Float> tempByFitness
                    = new LinkedHashMap<>();
            for (Map.Entry<Collaborator, Float> aa : listValue) {
                tempByFitness.put(aa.getKey(), aa.getValue());
            }

            if (add) {
                new TicketTaskService().addCollaborator(ticketTask, tempByFitness.entrySet().iterator().next().getKey());
            } else {
                for (Map.Entry<Collaborator, Float> entry : tempByFitness.entrySet()) {
                    if (collaboratorAndTotalTaskTime.get(entry.getKey()) + ticketTask.mainReference().maxTimeOfExecution() < 5 * 60 && !entry.getKey().sameAs(collaborator)) {
                        new TicketTaskService().addCollaborator(ticketTask, entry.getKey());
                        return;
                    } else {
                        if (redistributeTask(entry.getKey(), ticketTask.mainReference().maxTimeOfExecution(), collaboratorAndTotalTaskTime, collaboratorAndFitnessMap) && !entry.getKey().sameAs(collaborator)) {
                            new TicketTaskService().addCollaborator(ticketTask, entry.getKey());
                            return;
                        }
                    }
                }
            }
            return;
        }
        if (ticket.urgency().equals(Urgency.valueOf("reduzida"))) {
            List<Map.Entry<Collaborator, Float>> listValue
                    = new LinkedList<>(
                    collaboratorAndFitnessMap.entrySet());


            list.sort(Map.Entry.comparingByValue());

            // put data from sorted list to hashmap
            HashMap<Collaborator, Float> tempByFitness
                    = new LinkedHashMap<>();
            for (Map.Entry<Collaborator, Float> aa : listValue) {
                tempByFitness.put(aa.getKey(), aa.getValue());
            }

            if (add) {
                new TicketTaskService().addCollaborator(ticketTask, tempByFitness.entrySet().iterator().next().getKey());
            } else {
                for (Map.Entry<Collaborator, Float> entry : tempByFitness.entrySet()) {
                    if (collaboratorAndTotalTaskTime.get(entry.getKey()) + ticketTask.mainReference().maxTimeOfExecution() < 5 * 60 && !entry.getKey().sameAs(collaborator)) {
                        new TicketTaskService().addCollaborator(ticketTask, entry.getKey());
                        return;
                    }
                }
            }
        } else {
            new TicketTaskService().addCollaborator(ticketTask, temp.entrySet().iterator().next().getKey());
        }


    }

    private synchronized boolean redistributeTask(Collaborator collaborator, long minutesOfExecution, Map<
            Collaborator, Long> collaboratorAndTotalTaskTime, Map<Collaborator, Float> collaboratorAndFitnessMap) {
        List<Ticket> ticketList = new ArrayList<>();
        long timeNecessary = 0;
        for (TicketTask ticketTask : new TicketTaskService().getPendingApprovalTasks(collaborator)) {
            Ticket ticket = new TicketTaskService().getTicketDTOByTicketTask(ticketTask);
            if (!ticket.urgency().equals(Urgency.valueOf("urgente")) && timeNecessary < minutesOfExecution) {
                ticketList.add(ticket);
                timeNecessary += ticket.workflow().getFirstIncompleteTask().mainReference().maxTimeOfExecution();
            }
        }
        if (ticketList.isEmpty())
            return false;
        for (Ticket ticket : ticketList) {
            chooseCollaborator(ticket, collaboratorAndTotalTaskTime, collaboratorAndFitnessMap, ticket.workflow().getFirstIncompleteTask(), 0, collaborator);
        }
        return true;

    }


}
