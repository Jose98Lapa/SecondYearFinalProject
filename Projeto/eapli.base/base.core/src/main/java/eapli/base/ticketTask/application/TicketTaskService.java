package eapli.base.ticketTask.application;

import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.form.DTO.FormDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.task.domain.*;
import eapli.base.team.application.TeamListService;
import eapli.base.team.domain.Team;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.domain.*;
import eapli.base.ticketTask.repository.TicketTaskRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TicketTaskService {

    private final TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
    private final TicketTaskRepository ticketTaskRepository = PersistenceContext.repositories().ticketTasks();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();

    public Optional<Collaborator> getCollaborator(String email) {
        return collaboratorRepository.getColaboradorByEmail(InstituionalEmail.valueOf(email));
    }

    public List<TicketDTO> getPendingTasks(String emailCollaborator) {
        Collaborator collaborator = new ListCollaboratorService().getCollaboratorByEmail(emailCollaborator);
        Set<Team> teamList = new TeamListService().getACollaboratorTeams(collaborator);

        List<Ticket> ticketList = ticketRepository.getPendingTicket();
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (TicketTask ticketTask : ticketTaskRepository.getIncompleteTicketsByCollaborator(collaborator))
            if (checkIfCollaboratorIsValid(ticketTask,collaborator,teamList))
                ticketDTOList.add(getTicketByTicketTask(ticketTask).toDTO());

        for (TicketTask ticketTask : ticketTaskRepository.getIncompleteUnassignedTickets())
            if (checkIfCollaboratorIsValid(ticketTask,collaborator,teamList))
                ticketDTOList.add(getTicketByTicketTask(ticketTask).toDTO());

        return ticketDTOList;
    }

    private boolean checkIfCollaboratorIsValid(TicketTask ticketTask,Collaborator collaborator,Set<Team> collaboratorTeams){
        if (ticketTask.getClass()==TicketApprovalTask.class){
            ApprovalTask approvalTask = (ApprovalTask) ticketTask.mainReference();
            return collaborator.function().sameAs(approvalTask.necessaryRoleForApproval());
        }
        if (ticketTask.getClass()==TicketExecutionTask.class){
            ExecutionTask executionTask = (ExecutionTask) ticketTask.mainReference();
            return executionTask.executingTeams().stream().anyMatch(collaboratorTeams::contains);
        }
        return ticketTask.getClass()==TicketAutomaticTask.class;
    }

    public List<TicketApprovalTaskDTO> getPendingApprovalTasksByCollaborator(Collaborator collaborator) {
        List<TicketApprovalTaskDTO> toReturn = new ArrayList<>();
        for (Ticket ticket : ticketRepository.getPendingAssignedApprovalTickets()) {
            if (ticket.workflow().starterTask().getClass() == TicketApprovalTask.class) {
                TicketApprovalTask ticketApprovalTask = (TicketApprovalTask) ticket.workflow().starterTask();
                if (ticketApprovalTask.collaborator() != null && ticketApprovalTask.collaborator().equals(collaborator))
                    toReturn.add(ticketApprovalTask.toDTO());
            }
        }
        return toReturn;
    }

    public List<TicketExecutionTaskDTO> getPendingExecutionTasksByCollaborator(Collaborator collaborator) {
        List<TicketExecutionTaskDTO> toReturn = new ArrayList<>();
        for (Ticket ticket : ticketRepository.getPendingAssignedExecutionTickets()) {
            TicketTask incompleteTask = ticket.workflow().getFirstIncompleteTask();
            if (incompleteTask.getClass() == TicketExecutionTask.class) {
                TicketExecutionTask ticketExecutionTask = (TicketExecutionTask) incompleteTask;
                if (ticketExecutionTask.collaborator().equals(collaborator)) {
                    toReturn.add(ticketExecutionTask.toDTO());
                }
            }
        }
        return toReturn;

    }

    public TicketTask getTicketTaskByID(String id) {
        Optional<TicketTask> optionalTicketTask = ticketTaskRepository.ofIdentity(Long.parseLong(id));
        if (optionalTicketTask.isEmpty())
            throw new IllegalArgumentException("ID invalido");
        return optionalTicketTask.get();
    }

    public Ticket getTicketByTicketTask(TicketTask ticketTask) {
        for (Ticket ticket : ticketRepository.findAll()) {
            if (ticket.checkIfTicketTaskBelongsToTicket(ticketTask))
                return ticket;
        }
        return null;
    }

    public TicketTask createTicketTask(String deadline, Task starter) {

        CreateTaskController ticketTaskController = new CreateTaskController();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        if (starter instanceof ApprovalTask) {
            TicketApprovalTask approvalTask = new TicketApprovalTask(
                    new Transition(null, null),
                    starter,
                    ((ApprovalTask) starter).form(),
                    LocalDate.parse(deadline, formatter)
            );

            return ticketTaskController.registerTicketTask(approvalTask);
        }

        if (starter instanceof ExecutionTask) {
            TicketExecutionTask executionTask = new TicketExecutionTask(
                    new Transition(null, null), starter,
                    ((ExecutionTask) starter).form(),
                    null,
                    LocalDate.parse(deadline, formatter)
            );

            return ticketTaskController.registerTicketTask(executionTask);
        }

        if (starter instanceof AutomaticTask) {
            TicketAutomaticTask automaticTask = new TicketAutomaticTask(
                    new Transition(null, null),
                    starter,
                    ((AutomaticTask) starter).scriptPath()
            );

            return ticketTaskController.registerTicketTask(automaticTask);
        }

        return null;
    }

    public void updateTask(TicketTask ticketTask) {
        String deadline;
        if (ticketTask.mainReference().afterTask() == null)
            return;
        if (ticketTask.mainReference().afterTask().getClass() == AutomaticTask.class) {
            deadline = null;
        } else {
            TicketManualTask ticketManualTask = (TicketManualTask) ticketTask;
            deadline = ticketManualTask.deadline();
        }

        TicketTask temp = createTicketTask(deadline, ticketTask.mainReference().afterTask());
        ticketTask.addAfterTask(temp);
        temp.addBeforeTask(ticketTask);
        new CreateTaskController().registerTicketTask(temp);

    }

    public void addCollaborator(TicketTask ticketTask, Collaborator collaborator) {
        if (ticketTask.getClass() == TicketApprovalTask.class) {
            ((TicketApprovalTask) ticketTask).setApprovedBy(collaborator);
        }
        if (ticketTask.getClass() == TicketExecutionTask.class) {
            ((TicketExecutionTask) ticketTask).setExecutedBy(collaborator);
        }

        ticketTaskRepository.save(ticketTask);

    }

    public boolean redeemTask(TicketDTO ticketDTO, Collaborator collaborator) {
        Optional<Ticket> Oticket = ticketRepository.ofIdentity(ticketDTO.id);
        Ticket ticket;

        if (Oticket.isPresent()) {
            ticket = Oticket.get();
            if (ticketDTO.status.equals("PENDING")) {
                ticket.statusWaitingApproval();
                TicketApprovalTask ticketTask = (TicketApprovalTask) ticket.workflow().starterTask();
                ticketTask.setApprovedBy(collaborator); //Atribuir a aprovação ao colaborador
                ticketTask.redeemTask();
            } else {
                ticket.statusExecuting();
                TicketTask ticketTask = ticket.workflow().starterTask();
                TicketExecutionTask ticketExecutionTask;
                if (ticketTask.getClass().equals(TicketApprovalTask.class))
                    ticketExecutionTask = (TicketExecutionTask) ticketTask.transition().nextTask().getFirstIncompleteTask();
                else
                    ticketExecutionTask = (TicketExecutionTask) ticketTask.getFirstIncompleteTask();
                ticketExecutionTask.setExecutedBy(collaborator);
                ticketExecutionTask.redeemTask();
            }
            ticketRepository.save(ticket);
        }

        return true;
    }

    public List<FormDTO> getPreviousTicketTasksForm(Ticket ticket) {
        List<FormDTO> formDTOList = new ArrayList<>();
        TicketTask temp = ticket.workflow().starterTask();
        while (temp.transition().hasNextTask()) {
            if (temp.status().equals("COMPLETE")) {
                if (temp.getClass() == TicketApprovalTask.class || temp.getClass() == TicketExecutionTask.class) {
                    TicketManualTask ticketTask = (TicketManualTask) temp;
                    formDTOList.add(ticketTask.form().toDTO());
                }
            }
        }
        return formDTOList;
    }

    public long getTimeToFinishAllTasks(Collaborator collaborator) {
        List<TicketTask> ticketTaskList = ticketTaskRepository.getIncompleteTicketsByCollaborator(collaborator);
        long time = 0;
        for (TicketTask ticketTask : ticketTaskList) {
            Task task = ticketTask.mainReference();
            if (task.getClass() == ApprovalTask.class || task.getClass() == ExecutionTask.class) {
                time += task.maxTimeOfExecution();
            }
        }
        return time;
    }

    public List<TicketTask> getPendingApprovalTasks(Collaborator collaborator) {
        return ticketTaskRepository.getIncompleteTicketsByCollaborator(collaborator);
    }


    public List<TicketTask> getCompletedApprovalTasksByCollaborator(Collaborator collaborator) {
        return ticketTaskRepository.getCompleteApprovedTicketsByCollaborator(collaborator);
    }

    public Set<Collaborator> getCollaboratorByTicketTask(TicketTask ticketTask) {
        if (!(ticketTask instanceof TicketExecutionTask))
            throw new IllegalArgumentException("TicketTask inválida");
        ExecutionTask executionTask = (ExecutionTask) ticketTask.mainReference();
        Set<Team> teams = new HashSet<>(executionTask.executingTeams());
        return new TeamListService().getCollaboratorByTeams(teams);
    }

}
