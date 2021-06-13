package eapli.base.feedback.builder;

import eapli.base.feedback.domain.Feedback;
import eapli.base.feedback.domain.FeedbackValue;
import eapli.base.ticket.domain.Ticket;

public class FeedbackBuilder {

    private FeedbackValue feedbackValue;
    private String email;

    public FeedbackBuilder withFeedbackValue(FeedbackValue feedbackValue){
        this.feedbackValue = feedbackValue;
        return this;
    }

    public FeedbackBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public Feedback build(){
        return new Feedback(feedbackValue,email);
    }
}
