package eapli.base.ticket.repository;

import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketID;
import eapli.framework.domain.repositories.DomainRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends DomainRepository< String, Ticket > {



	List<Ticket> getPendingTicket();

	Iterable< Ticket > findAll();

	List<Ticket> getPendingAssignedApprovalTickets();

	List<Ticket> getPendingAssignedExecutionTickets();


	List<Ticket> getTicketsByClient(String client);

	List<Ticket> getFeedbackBetweenDatesFromAClient(String client, LocalDate localDateStart, LocalDate localDateEnd);

	List<Ticket> getCompletedTickets();


	List< Ticket > getIncomplete ( );

}
