package eapli.base.feedback.application;


import eapli.base.feedback.DTO.FeedbackDTO;
import eapli.base.feedback.builder.FeedbackBuilder;
import eapli.base.feedback.domain.Feedback;
import eapli.base.feedback.domain.FeedbackValue;
import eapli.base.feedback.repositories.FeedbackRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.application.TicketListService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class ReviewTicketController {
    private final FeedbackService feedbackService = new FeedbackService();
    private final TicketListService ticketListService = new TicketListService();
    private final FeedbackRepository feedbackRepository = PersistenceContext.repositories().feedback();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private String email;


    public List<TicketDTO> getTicketDTOByClient(){
        this.email = authz.session().get().authenticatedUser().email().toString();
        return this.ticketListService.getPendingTicketsToReview(email);
    }

    public void createFeedback(FeedbackDTO feedbackDTO,TicketDTO ticketDTO){
        FeedbackBuilder feedbackBuilder = new FeedbackBuilder();
        TicketListService ticketListService = new TicketListService();
        Feedback feedback = feedbackBuilder.withFeedbackValue(FeedbackValue.valueOf(feedbackDTO.feedbackValue)).withEmail(feedbackDTO.email).withEmail(email).build();
        feedback =feedbackRepository.save(feedback);

        ticketListService.reviewTicket(ticketDTO.id,feedback);
    }



}
