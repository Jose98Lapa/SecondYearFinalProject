package eapli.base.persistence.impl.jpa;


import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketID;
import eapli.base.ticket.repository.TicketRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaTicketRepository extends JpaAutoTxRepository<Ticket, TicketID, TicketID> implements TicketRepository {
    public JpaTicketRepository(TransactionalContext tx) {
        super(tx,"TicketID");
    }

    public JpaTicketRepository(String persistenceUnitName) {
        super(persistenceUnitName, "TicketID");
    }

    @Override
    public Optional<Ticket> ofIdentity(TicketID id) {
        final TypedQuery<Ticket> q = createQuery("SELECT e FROM eapli.base.ticket.domain.Ticket e WHERE e.TicketID = :id", Ticket.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }
    @Override
    public Iterable<Ticket> getPendingTicket(){
        final TypedQuery<Ticket> q = createQuery("SELECT e FROM eapli.base.ticket.domain.Ticket e WHERE e.TicketStatus = :id", Ticket.class);
        //TODO
        //update when status name is known
        q.setParameter("id", "pending");
        return q.getResultList();

    }
}