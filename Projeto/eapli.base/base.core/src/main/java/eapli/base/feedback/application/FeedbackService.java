package eapli.base.feedback.application;

import eapli.base.feedback.domain.Feedback;
import eapli.base.feedback.repositories.FeedbackRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.DTO.TicketDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FeedbackService {
    FeedbackRepository feedbackRepository = PersistenceContext.repositories().feedback();
    public List<TicketDTO> getPendingTicketsToReview(String email){
        List<Feedback> feedbackBetweenDatesFromACliente= feedbackRepository.getFeedbackBetweenDatesFromACliente(email, LocalDate.now(),LocalDate.now().minusDays(7));
        List<TicketDTO> toReturn = new ArrayList<>(feedbackBetweenDatesFromACliente.size());
        feedbackBetweenDatesFromACliente.forEach(feedback -> toReturn.add(feedback.ticket().toDTO()));
        return toReturn;
    }
}
