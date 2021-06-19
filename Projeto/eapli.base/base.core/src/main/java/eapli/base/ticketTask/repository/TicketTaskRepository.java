package eapli.base.ticketTask.repository;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketAutomaticTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface TicketTaskRepository extends DomainRepository< Long, TicketTask > {

    List<TicketTask> getIncompleteTicketsByCollaborator(Collaborator collab);

    List<TicketTask> getCompleteApprovedTicketsByCollaborator(Collaborator collab);

    List<TicketTask> getIncompleteUnassignedTickets();

    List< TicketApprovalTask > pendingApproval ( String collaboratorEmail );

    List< TicketExecutionTask > pendingExecution ( String collaboratorEmail );

}
