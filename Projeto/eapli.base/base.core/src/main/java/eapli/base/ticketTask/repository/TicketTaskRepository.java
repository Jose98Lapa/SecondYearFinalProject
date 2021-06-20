package eapli.base.ticketTask.repository;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TicketTaskRepository extends DomainRepository< Long, TicketTask > {

    List<TicketTask> getIncompleteTicketsByCollaborator(Collaborator collab);

    List<TicketTask> getCompleteApprovedTicketsByCollaborator(Collaborator collab);

    List<TicketTask> getIncompleteUnassignedTickets();

    List< TicketApprovalTask > pendingApproval ( Collaborator collaboratorEmail );

    List< TicketExecutionTask > pendingExecution ( Collaborator collaboratorEmail );

    List<TicketTask> getTaskByCollaborator(Collaborator collab);

    List<TicketTask> getTaskCompletionTime();
}
