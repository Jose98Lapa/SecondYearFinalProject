package eapli.base.feedback.DTO;

import eapli.base.feedback.domain.Feedback;
import eapli.base.feedback.domain.FeedbackValue;
import eapli.base.ticket.DTO.TicketDTOParser;

public class FeedbackDTOParser {
    public static Feedback valueOf(FeedbackDTO feedbackDTO){
        return new Feedback(FeedbackValue.valueOf(feedbackDTO.feedbackValue), feedbackDTO.email);
    }
}
