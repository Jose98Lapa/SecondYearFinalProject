package eapli.base.persistence.impl.jpa;


import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketID;
import eapli.base.ticket.domain.TicketStatus;
import eapli.base.ticket.repository.TicketRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class JpaTicketRepository extends JpaAutoTxRepository<Ticket, String, String> implements TicketRepository {
    public JpaTicketRepository(TransactionalContext tx) {
        super(tx,"TicketID");
    }

    public JpaTicketRepository(String persistenceUnitName) {
        super(persistenceUnitName, "TicketID");
    }

    @Override
    public Optional<Ticket> ofIdentity(String id) {
        final TypedQuery<Ticket> q = createQuery("SELECT e FROM eapli.base.ticket.domain.Ticket e WHERE e.id = :id", Ticket.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }



    @Override
    public List<Ticket> getPendingTicket(){
        final TypedQuery<Ticket> q = createQuery("SELECT e FROM eapli.base.ticket.domain.Ticket e WHERE e.status = :id", Ticket.class);
        q.setParameter("id", TicketStatus.valueOf("PENDING"));

        List<Ticket> ticketList = new ArrayList<>();
        for (Iterator<Ticket> it = q.getResultStream().iterator(); it.hasNext(); ) {
            Ticket ticket = it.next();
            ticketList.add(ticket);
        }

        final TypedQuery<Ticket> p = createQuery("SELECT e FROM eapli.base.ticket.domain.Ticket e WHERE e.status = :id", Ticket.class);
        p.setParameter("id", TicketStatus.valueOf("PENDING_EXECUTION"));
        for (Iterator<Ticket> it = p.getResultStream().iterator(); it.hasNext(); ) {
            Ticket ticket = it.next();
            ticketList.add(ticket);
        }

        return ticketList;

    }

    @Override
    public List<Ticket> getPendingAssignedApprovalTickets() {
        final TypedQuery<Ticket> q = createQuery("SELECT e FROM eapli.base.ticket.domain.Ticket e WHERE e.status = :id", Ticket.class);
        q.setParameter("id", TicketStatus.valueOf("WAITING_APPROVAL"));
        return q.getResultList();
    }

    @Override
    public List<Ticket> getPendingAssignedExecutionTickets() {
        final TypedQuery<Ticket> p = createQuery("SELECT e FROM eapli.base.ticket.domain.Ticket e WHERE e.status = :id", Ticket.class);
        p.setParameter("id", TicketStatus.valueOf("PENDING_EXECUTION"));
        return p.getResultList();
    }
}