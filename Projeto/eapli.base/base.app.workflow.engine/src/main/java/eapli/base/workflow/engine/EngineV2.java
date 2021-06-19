package eapli.base.workflow.engine;

import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceID;
import eapli.base.task.domain.ApprovalTask;
import eapli.base.task.domain.AutomaticTask;
import eapli.base.task.domain.ExecutionTask;
import eapli.base.task.domain.Task;
import eapli.base.task.repository.TaskRepository;
import eapli.base.team.domain.Team;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.ticket.application.TicketListService;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketWorkflow;
import eapli.base.ticket.domain.Urgency;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.application.CreateTaskController;
import eapli.base.ticketTask.application.TicketTaskService;
import eapli.base.ticketTask.domain.*;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.workflow.engine.client.TcpExecuterClient;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class EngineV2 {

    private final TicketRepository ticketRepository;
    private final ServiceRepository serviceRepository;
    private final CreateTaskController ticketTaskController;
	static ConcurrentSkipListMap<Team, TreeMap<Date, Collaborator>> historyExecution = new ConcurrentSkipListMap<>();
	static ConcurrentSkipListMap<Date, Collaborator> historyApproval = new ConcurrentSkipListMap<>();
    static TreeMap<Date, String> historyAutomaticTask = new TreeMap<>();

    public EngineV2() {

        this.ticketRepository = PersistenceContext.repositories().tickets();
        this.serviceRepository = PersistenceContext.repositories().servico();
        this.ticketTaskController = new CreateTaskController();

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());
    }

    public void processIncomingTicket(byte[] payload) {

        Optional<Ticket> ticketOptional = ticketRepository.ofIdentity(new String(payload));
        Ticket ticket;

        if (ticketOptional.isPresent()) {

            ticket = ticketOptional.get();
            createWorkFlow(ticket);
            processStatusChange(ticket, ticket.status().toString());
        }

    }

    public void processStatusChange(Ticket ticket, String action) {

        Optional<Ticket> processedTicket = Optional.empty();

        switch (action) {
            case "PENDING":
                System.out.println("PENDING TICKET DELEGATION");
                ticket.statusPending();
                processedTicket = Optional.of(delegateTask(ticket));
                break;
            case "PENDING_EXECUTION":
                System.out.println("APPROVED TICKET DELEGATION");
                ticket.statusApproved();
                processedTicket = Optional.of(delegateTask(ticket));
                break;
            case "NOT_APPROVED":
                ticket.statusNotApproved();
                break;
            case "CONCLUDED":
                ticket.statusConcluded();
                break;
            case "FAILED":
                ticket.statusFailed();
                break;
        }

        processedTicket.ifPresent(ticketRepository::save);
    }

    private void createWorkFlow(Ticket ticket) {

        Service service = serviceRepository.ofIdentity(ticket.service().identity()).get();
        TicketWorkflow ticketWorkflow = new TicketWorkflow(new TicketTaskService().createTicketTask(ticket.deadline().toString(),service.workflow().starterTask()));

       /* if (service.workflow().starterTask().hasAfterTask()) {
            taskList.add(service.workflow().starterTask().afterTask());
        }

        TicketTaskPair ticketTaskPair;
        TicketWorkflow workflow = null;

        if (taskList.size() == 2) {

            ticketTaskPair = TicketTaskPair.of(createTask(ticket, taskList.get(0)), createTask(ticket, taskList.get(1)));
            TicketApprovalTask approvalTask = ticketTaskPair.ticketApprovalTask();

            if (ticketTaskPair.hasAutomaticTask()) {

                approvalTask.addAfterTask(ticketTaskPair.ticketAutomaticTask());
                ticketTaskController.registerApprovalTask(approvalTask);
                ticketTaskController.registerAutomaticTask(ticketTaskPair.ticketAutomaticTask());

            } else if (ticketTaskPair.hasExecutionTask()) {

                approvalTask.addAfterTask(ticketTaskPair.ticketExecutionTask());
                ticketTaskController.registerApprovalTask(approvalTask);
                ticketTaskController.registerExecutionTask(ticketTaskPair.ticketExecutionTask());
            }

            workflow = new TicketWorkflow(approvalTask);

        } else {

            ticketTaskPair = TicketTaskPair.of(createTask(ticket, taskList.get(0)), null);

            if (ticketTaskPair.hasAutomaticTask()) {

                workflow = new TicketWorkflow(ticketTaskPair.ticketAutomaticTask());
                ticketTaskController.registerAutomaticTask(ticketTaskPair.ticketAutomaticTask());

            } else if (ticketTaskPair.hasExecutionTask()) {
                workflow = new TicketWorkflow(ticketTaskPair.ticketExecutionTask());
                ticketTaskController.registerExecutionTask(ticketTaskPair.ticketExecutionTask());

            }
        }

        System.out.println("SAVING WORKFLOW");*/
        ticket.setWorkflow(ticketWorkflow);
        ticketRepository.save(ticket);
    }

    /*private TicketTask createTask(Ticket ticket, Task task) {

        TicketTask ticketTask;

        if (task instanceof ApprovalTask) {

            ApprovalTask approvalTask = (ApprovalTask) task;
            ticketTask = new TicketApprovalTask(
                    new Transition(null, null),
                    approvalTask,
                    approvalTask.form(),
                    ticket.deadline()
            );
        } else if (task instanceof AutomaticTask) {

            AutomaticTask automaticTask = (AutomaticTask) task;
            ticketTask = new TicketAutomaticTask(
                    new Transition(null, null),
                    automaticTask,
                    automaticTask.scriptPath()
            );
        } else {

            ExecutionTask executionTask = (ExecutionTask) task;
            ticketTask = new TicketExecutionTask(
                    new Transition(null, null),
                    executionTask,
                    executionTask.form(),
                    null,
                    ticket.deadline()
            );

        }

        return ticketTask;
    }*/

    private Ticket delegateTask(Ticket ticket) {

        Ticket delegated = ticket;

        switch (Application.settings().getCollaboratorAssignerAlgorithm()) {
            case "FCFS":
                System.out.println("FCFS");
                delegated = FCFSTicket(ticket);
                break;
            case "COMPLEX":
                assigningAlgorithm(ticket);
                break;
        }

        return delegated;
    }

    public Ticket FCFSTicket(Ticket ticket) {

        Collaborator selected = null;

        if (ticket.status().toString().equals("PENDING")) {

            if (ticket.workflow().getFirstIncompleteTask() instanceof TicketApprovalTask) {
                selected = assignCollaboratorApproval(ticket);
                ((TicketApprovalTask) ticket.workflow().getFirstIncompleteTask()).setApprovedBy(selected);
            }
            /*if (ticket.workflow().getFirstIncompleteTask() instanceof TicketApprovalTask) {
                selected = assignCollaboratorApproval(ticket);
                ((TicketApprovalTask) ticket.workflow().getFirstIncompleteTask()).setApprovedBy(selected);
            }*/
        }

        if (ticket.status().toString().equals("APPROVED")) {

            if (ticket.workflow().getFirstIncompleteTask() instanceof TicketExecutionTask) {
                selected = assignCollaboratorExecution(ticket);
                ((TicketExecutionTask) ticket.workflow().getFirstIncompleteTask()).setExecutedBy(selected);
            }
           /* if (ticket.workflow().starterTask().transition().nextTask() instanceof TicketExecutionTask) {
                selected = assignCollaboratorExecution(ticket);
                ((TicketExecutionTask) ticket.workflow().starterTask()).setExecutedBy(selected);
            }*/

            /*if (ticket.workflow().starterTask() instanceof TicketAutomaticTask) {
                FCFSAutomaticTask(ticket);
            }*/

            if (ticket.workflow().starterTask().getFirstIncompleteTask() instanceof TicketAutomaticTask) {
                FCFSAutomaticTask(ticket);
            }
        }

        return ticket;
    }

    public Ticket FCFSAutomaticTask(Ticket ticket) {

        String selected = "";
        try {
            if (ticket.status().toString().equals("PENDING")) {
                if (ticket.workflow().starterTask() instanceof TicketAutomaticTask) {
                    selected = assignServer();
                    TcpExecuterClient client = new TcpExecuterClient();
                    client.startConnection(selected);
                    client.executeAutomaticTask(ticket);
                    client.stopConnection();
                }
                if (ticket.workflow().starterTask().transition().nextTask() instanceof TicketAutomaticTask) {
                    selected = assignServer();
                    TcpExecuterClient client = new TcpExecuterClient();
                    client.startConnection(selected);
                    client.executeAutomaticTask(ticket);
                    client.stopConnection();
                }
            }

            if (ticket.status().toString().equals("APPROVED")) {
                if (ticket.workflow().starterTask() instanceof TicketAutomaticTask) {
                    TcpExecuterClient client = new TcpExecuterClient();
                    client.startConnection(selected);
                    client.executeAutomaticTask(ticket);
                    client.stopConnection();
                }
                if (ticket.workflow().starterTask().transition().nextTask() instanceof TicketAutomaticTask) {
                    TcpExecuterClient client = new TcpExecuterClient();
                    client.startConnection(selected);
                    client.executeAutomaticTask(ticket);
                    client.stopConnection();
                }
            }
        } catch (IOException e) {
            System.out.println("An error ocorred");
        }

        return ticket;
    }

    public synchronized String assignServer() {

        String theChosenOne = "";
        List<String> serverList = new LinkedList<>();
        serverList.add("172.17.0.3");
        serverList.add("172.17.0.4");
        serverList.add("172.17.0.5");
        serverList.add("172.17.0.6");

        for (Date date : historyAutomaticTask.keySet()) {
            if (!serverList.contains(historyAutomaticTask.get(date))) {   //se algum colaborador for removido retira do historico
                historyAutomaticTask.remove(date);
            }
        }

        for (String server : serverList) { //verificar se existe algum que ainda nao tenha feito nada
            if (!historyAutomaticTask.containsValue(server)) {
                theChosenOne = server;
                historyAutomaticTask.put(new Date(), server);
            }
        }

        if (theChosenOne.equals("")) { //se todos ja tiverem feito pelo menos um, vai verificar o que fez ha mais tempo
            for (Date date : historyAutomaticTask.keySet()) {
                if (serverList.contains(historyAutomaticTask.get(date))) {
                    theChosenOne = historyAutomaticTask.get(date);
                    historyAutomaticTask.put(new Date(), historyAutomaticTask.remove(date));
                }
            }
        }
        return theChosenOne;
    }

    public Collaborator assignCollaboratorExecution(Ticket ticket) {

        TeamRepository teamRepository = PersistenceContext.repositories().teams();

        Collaborator theChosenOne;
        ArrayList<Collaborator> collaborators = new ArrayList<>();
        ArrayList<Team> execTeams = new ArrayList<>();
        ArrayList<Team> execTeamsUpdated = new ArrayList<>();
        Service svr = ticket.service();

        //if (ticket.workflow().getFirstIncompleteTask() instanceof TicketExecutionTask) {
        execTeams.addAll(((ExecutionTask) svr.workflow().starterTask()).executingTeams());
        //}
        for (Team t : execTeams) { //update teams
            execTeamsUpdated.add(teamRepository.ofIdentity(t.identity()).get());
        }
        execTeams.clear();// delete old list

        for (Team t : execTeamsUpdated) { //save updated collaborators
            collaborators.addAll(t.teamMembers());
        }

        for (Team t : execTeamsUpdated) {
            if (!historyExecution.containsKey(t)) { //se a equipa nao esta no historico escolhe um elemento dessa equipa
                TreeMap<Date, Collaborator> teamHistory = new TreeMap<>();
                theChosenOne = t.teamMembers().iterator().next();
                teamHistory.put(new Date(), theChosenOne);
                historyExecution.put(t, teamHistory);
                return theChosenOne;
            }
        }

        for (Team team : historyExecution.keySet()) {//se a equipa esta no historico mas nem todos os colaboradores ja foram selecionados
            Collections.shuffle(execTeamsUpdated);
            TreeMap<Date, Collaborator> teamHistory = historyExecution.get(team);
            for (Team team2 : execTeamsUpdated) {
                if (team2.equals(team)) {
                    for (Collaborator c : team2.teamMembers()) {
                        if (!teamHistory.containsValue(c)) {
                            theChosenOne = c;
                            teamHistory.put(new Date(), theChosenOne);
                            historyExecution.remove(team);
                            historyExecution.put(team, teamHistory);
                            return theChosenOne;
                        } else {
                            theChosenOne = teamHistory.firstEntry().getValue();//se nao escolhe o mai antigo
                            teamHistory.remove(teamHistory.firstEntry());
                            teamHistory.put(new Date(), theChosenOne);
                            historyExecution.remove(team);
                            historyExecution.put(team, teamHistory);
                            return theChosenOne;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Collaborator assignCollaboratorApproval(Ticket ticket) {


		CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
		Task app = ticket.workflow().starterTask().mainReference();
		ApprovalTask aprov = (ApprovalTask) app;
		ArrayList<Collaborator> col = (ArrayList<Collaborator>) collaboratorRepository.getCollaboratorListByFunction(((ApprovalTask) app).necessaryRoleForApproval());

		for (Date date : historyApproval.keySet()) { //remover colaboradores que foram removidos
			if (!col.contains(historyApproval.get(date))) {
				historyApproval.remove(date);
			}
		}

		for (Collaborator collaborator : col) { //verificar se foram adicionados novos colaboradores
			if (!historyApproval.containsValue(collaborator)) {
				historyApproval.put(new Date(), collaborator);
				return collaborator;
			}
		}

		Collaborator collaborator = historyApproval.firstEntry().getValue();//escolher o mais antigo
		historyApproval.remove(historyApproval.firstEntry().getKey());
		historyApproval.put(new Date(), collaborator);

		return collaborator;
	}

    public synchronized void assigningAlgorithm(Ticket ticket) {
        if (ticket.workflow().getFirstIncompleteTask().getClass() == TicketApprovalTask.class) {
            chooseApprovalCollaborator(ticket);
        } else if (ticket.workflow().getFirstIncompleteTask().getClass() == TicketExecutionTask.class) {
            chooseExecutionCollaborator(ticket);
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

    private synchronized void chooseExecutionCollaborator(Ticket ticket) {
        TicketTask ticketTask = ticket.workflow().getFirstIncompleteTask();
        if (ticketTask.transition() != null && ticketTask.transition().hasPreviousTask() && ticketTask.transition().previousTask().getClass() == TicketExecutionTask.class) {
            TicketExecutionTask ticketExecutionTask = (TicketExecutionTask) ticketTask.transition().previousTask();
            new TicketTaskService().addCollaborator(ticketTask, ticketExecutionTask.collaborator());
            return;
        }
        Map<Collaborator, Long> collaboratorAndTotalTaskTime = new HashMap<>();
        Map<Collaborator, Float> collaboratorAndFitnessMap = new HashMap<>();
        ExecutionTask executionTask = (ExecutionTask) ticketTask.mainReference();
        long allCollaboratorTime = 0;
        for (Collaborator collaborator : new TicketTaskService().getCollaboratorByTicketTask(ticketTask)) {
            long timeToFinishAllTasks = new TicketTaskService().getTimeToFinishAllTasks(collaborator);
            allCollaboratorTime += timeToFinishAllTasks;
            collaboratorAndTotalTaskTime.put(collaborator, timeToFinishAllTasks);
            collaboratorAndFitnessMap.put(collaborator, new TicketListService().getCollaboratorPerformanceInApprovalTasks(ticket, collaborator));
        }

        chooseCollaborator(ticket, collaboratorAndTotalTaskTime, collaboratorAndFitnessMap, ticketTask, allCollaboratorTime, null);

    }

    private synchronized void chooseCollaborator(Ticket ticket, Map<Collaborator, Long> collaboratorAndTotalTaskTime, Map<Collaborator, Float> collaboratorAndFitnessMap, TicketTask ticketTask, long allCollaboratorTime, Collaborator collaborator) {
        int limitHours = Integer.parseInt(Application.settings().getProperty("LIMIT_HOURS_OF_TASKS"));
        boolean add = allCollaboratorTime > (long) collaboratorAndTotalTaskTime.size() * limitHours * 60;

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
                    if (collaboratorAndTotalTaskTime.get(entry.getKey()) + ticketTask.mainReference().maxTimeOfExecution() < limitHours * 60 && !entry.getKey().sameAs(collaborator)) {
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
                    if (collaboratorAndTotalTaskTime.get(entry.getKey()) + ticketTask.mainReference().maxTimeOfExecution() < limitHours * 60 && !entry.getKey().sameAs(collaborator)) {
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
