package eapli.base.feedback.builder;

import eapli.base.feedback.domain.Feedback;
import eapli.base.feedback.domain.FeedbackValue;
import eapli.base.ticket.domain.Ticket;

public class FeedbackBuilder {
    private Ticket ticket;
    private FeedbackValue feedbackValue;

    public FeedbackBuilder withTicket(Ticket ticket){
        this.ticket = ticket;
        return this;
    }

    public FeedbackBuilder withFeedbackValue(FeedbackValue feedbackValue){
        this.feedbackValue = feedbackValue;
        return this;
    }

    public Feedback build(){
        return new Feedback(feedbackValue,ticket);
    }
}
