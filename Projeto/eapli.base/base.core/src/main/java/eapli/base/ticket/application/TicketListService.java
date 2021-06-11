package eapli.base.ticket.application;

import eapli.base.feedback.domain.Feedback;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TicketListService {
    TicketRepository ticketRepository = PersistenceContext.repositories().tickets();


    public Ticket getTicketByID(String ID){
        Optional<Ticket> optionalTicket = ticketRepository.ofIdentity(ID);
        if (optionalTicket.isEmpty())
            throw new IllegalArgumentException(ID + " is a invalid TicketID");
        return optionalTicket.get();
    }

    public List<TicketDTO> getPendingTicketsToReview(String email){

        List<Ticket> feedbackBetweenDatesFromAClient= ticketRepository.getFeedbackBetweenDatesFromAClient(email, LocalDate.now().minusDays(7),LocalDate.now());
        List<TicketDTO> toReturn = new ArrayList<>(feedbackBetweenDatesFromAClient.size());
        feedbackBetweenDatesFromAClient.forEach(ticket -> toReturn.add(ticket.toDTO()));
        return toReturn;
    }

    public Ticket reviewTicket(String ID){
        Ticket ticket = getTicketByID(ID);
        ticket.reviewed();
        return this.ticketRepository.save(ticket);
    }

}
