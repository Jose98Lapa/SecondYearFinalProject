package eapli.base.ticket.repository;

import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends DomainRepository< TicketID, Ticket > {

	Optional<Ticket> ofIdentity(TicketID number);

	Iterable<Ticket> getPendingTicket();

<<<<<<< HEAD
	Iterable< Ticket > findAll();

	//List<Ticket> getTicketsByCollaborator(MecanographicNumber id);
=======
>>>>>>> 54daa085598de1750342db4240075612710929c3
}
