package eapli.base.ticketTask.repository;

import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.domain.TicketTaskID;
import eapli.framework.domain.repositories.DomainRepository;

public interface TicketTaskRepository extends DomainRepository< TicketTaskID, TicketTask > {

}
