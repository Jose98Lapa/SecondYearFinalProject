package eapli.base.ticketTask.application;

import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class CompleteTaskController {
    private final TicketTaskService ticketTaskService = new TicketTaskService();
    private final ListCollaboratorService listCollaboratorService = new ListCollaboratorService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public List<TicketApprovalTaskDTO> getListOfTicketApprovalTasks(){
        return ticketTaskService.getPendingApprovalTasksByCollaborator(listCollaboratorService.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));
    }

    public List<TicketExecutionTaskDTO> getListOfTicketExecutionTasks(){
        return ticketTaskService.getPendingExecutionTasksByCollaborator(listCollaboratorService.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));
    }

    public TicketDTO getTickedDTOByTask(TicketApprovalTaskDTO ticketApprovalTask){
        return ticketTaskService.getTicketDTOByTicketTask(ticketTaskService.getTicketTaskByID(ticketApprovalTask.ticketTaskID));
    }

    public TicketDTO getTickedDTOByTask(TicketExecutionTaskDTO ticketApprovalTask){
        return ticketTaskService.getTicketDTOByTicketTask(ticketTaskService.getTicketTaskByID(ticketApprovalTask.ticketTaskID));
    }

}
