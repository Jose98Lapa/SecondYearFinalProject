package eapli.base.ticket.repository;

import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends DomainRepository< TicketID, Ticket > {

	Optional<Ticket> ofIdentity(TicketID number);

	List<Ticket> getPendingTicket();

	Iterable< Ticket > findAll();

	List<Ticket> getPendingAssignedApprovalTickets();

	List<Ticket> getPendingAssignedExecutionTickets();

}
