package eapli.base.ticketTask.repository;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TicketTaskRepository extends DomainRepository< Long, TicketTask > {

    List<TicketTask> getTicketsByCollaborator(Collaborator collab);

}
