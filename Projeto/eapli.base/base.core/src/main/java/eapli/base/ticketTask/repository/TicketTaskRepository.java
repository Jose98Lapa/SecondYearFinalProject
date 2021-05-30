package eapli.base.ticketTask.repository;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.domain.TicketTaskID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TicketTaskRepository extends DomainRepository< TicketTaskID, TicketTask > {

    List<TicketTask> getTicketsByCollaborator(Collaborator collab);
}
