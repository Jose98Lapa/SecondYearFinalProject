package eapli.base.ticketTask.application;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.task.domain.ApprovalTask;
import eapli.base.task.domain.AutomaticTask;
import eapli.base.task.domain.ExecutionTask;
import eapli.base.task.domain.Task;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.application.CreateTicketController;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketID;
import eapli.base.ticket.domain.TicketStatus;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.domain.*;
import eapli.base.ticketTask.repository.TicketTaskRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketTaskService {
    private final TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
    private final TicketTaskRepository ticketTaskRepository= PersistenceContext.repositories().ticketTasks();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();

    public Optional<Collaborator> getCollaborator(String email){
        return collaboratorRepository.getColaboradorByEmail(InstituionalEmail.valueOf(email));
    }

    public List<TicketDTO> getPendingTasks(){
        List<Ticket> ticketList = ticketRepository.getPendingTicket();
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (Ticket ticket: ticketList)
            ticketDTOList.add(ticket.toDTO());
        return ticketDTOList;
    }

    public List<TicketApprovalTaskDTO> getPendingApprovalTasksByCollaborator(Collaborator collaborator){
        List<TicketApprovalTaskDTO> toReturn = new ArrayList<>();
        for (Ticket ticket: ticketRepository.getPendingAssignedApprovalTickets()){
            if (ticket.workflow().starterTask().getClass()==TicketApprovalTask.class){
                TicketApprovalTask ticketApprovalTask = (TicketApprovalTask) ticket.workflow().starterTask();
                if (ticketApprovalTask.collaborator().equals(collaborator))
                    toReturn.add(ticketApprovalTask.toDTO());
            }
        }
        return toReturn;
    }

    public List<TicketExecutionTaskDTO> getPendingExecutionTasksByCollaborator(Collaborator collaborator){
        List<TicketExecutionTaskDTO> toReturn = new ArrayList<>();
        for (Ticket ticket:ticketRepository.getPendingAssignedExecutionTickets()){
            TicketTask incompleteTask = ticket.workflow().getFirstIncompleteTask();
            if (incompleteTask.getClass()==TicketExecutionTask.class){
                TicketExecutionTask ticketExecutionTask = (TicketExecutionTask) incompleteTask;
                if (ticketExecutionTask.collaborator().equals(collaborator)){
                    toReturn.add(ticketExecutionTask.toDTO());
                }
             }
        }
        return toReturn;

    }

    public TicketTask getTicketTaskByID(String id){
        Optional<TicketTask> optionalTicketTask = ticketTaskRepository.ofIdentity(TicketTaskID.valueOf(id));
        if (optionalTicketTask.isEmpty())
            throw new IllegalArgumentException("ID invalido");
        return optionalTicketTask.get();
    }

    public Ticket getTicketDTOByTicketTask(TicketTask ticketTask){
        for (Ticket ticket:ticketRepository.findAll()){
            if (ticket.checkIfTicketTaskBelongsToTicket(ticketTask))
                return ticket;
        }
        return null;
    }

    public TicketTask createTicketTask(String deadline, Task starter) {
        CreateTaskController ticketTaskController = new CreateTaskController();
        if (starter instanceof ApprovalTask) {
            TicketApprovalTask approvalTask = new TicketApprovalTask(
                    new TicketTaskID(starter.identity().toString()),
                    new Transition(null, null),starter, ((ApprovalTask) starter).form(),
                    LocalDate.parse(deadline));
            ticketTaskController.registerTask(approvalTask);
            return approvalTask;
        }

        if (starter instanceof ExecutionTask) {
            TicketExecutionTask executionTask = new TicketExecutionTask(
                    new TicketTaskID(starter.identity().toString()),
                    new Transition(null, null),starter,
                    ((ExecutionTask) starter).form(),
                    null,
                    LocalDate.parse(deadline));

            ticketTaskController.registerTask(executionTask);
            return executionTask;
        }

        if (starter instanceof AutomaticTask) {
            TicketAutomaticTask automaticTask = new TicketAutomaticTask(
                    new TicketTaskID(starter.identity().toString()),
                    new Transition(null, null),starter,
                    ((AutomaticTask) starter).scriptPath()
            );

            ticketTaskController.registerTask(automaticTask);
            return automaticTask;
        }

        return null;
    }

    public void updateTask(TicketTask ticketTask){
        String deadline;
        if (ticketTask.mainReference().afterTask()==null)
            return;
        if (ticketTask.mainReference().afterTask().getClass()==AutomaticTask.class){
            deadline = null;
        }else{
            TicketManualTask ticketManualTask = (TicketManualTask) ticketTask;
            deadline = ticketManualTask.deadline();
        }

        TicketTask temp = createTicketTask(deadline,ticketTask.mainReference().afterTask());
        ticketTask.addAfterTask(temp);
        temp.addBeforeTask(ticketTask);
        new CreateTaskController().registerTask(temp);

    }

    public boolean redeemTask(TicketDTO ticketDTO, Collaborator collaborator){
        Optional<Ticket> Oticket = ticketRepository.ofIdentity(ticketDTO.id);
        Ticket ticket;

        if (Oticket.isPresent()) {
            ticket = Oticket.get();
            if (ticketDTO.status.equals("PENDING")) {
                ticket.setStatus(TicketStatus.valueOf("WAITING_APPROVAL"));
                TicketApprovalTask ticketTask = (TicketApprovalTask) ticket.workflow().starterTask();
                ticketTask.setApprovedBy(collaborator);
            }else {
                ticket.setStatus(TicketStatus.valueOf("EXECUTING"));
                TicketTask ticketTask = ticket.workflow().starterTask();
                TicketExecutionTask ticketExecutionTask;
                if (ticketTask.getClass().equals(TicketApprovalTask.class))
                    ticketExecutionTask= (TicketExecutionTask) ticketTask.transition().nextTask();
                else
                    ticketExecutionTask=(TicketExecutionTask) ticketTask;
                ticketExecutionTask.setExecutedBy(collaborator);
            }
            ticketRepository.save(ticket);
            }

        return true;
    }
}
