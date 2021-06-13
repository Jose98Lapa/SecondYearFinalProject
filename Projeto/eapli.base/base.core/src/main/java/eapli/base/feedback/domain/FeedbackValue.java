package eapli.base.feedback.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FeedbackValue implements ValueObject, Serializable {
    private int feedbackValue;

    public FeedbackValue(int feedbackValue) {
        if (feedbackValue<0||feedbackValue>5){
            throw new IllegalArgumentException("O feedback tem de ser um numero entre 0 e 5");
        }
        this.feedbackValue = feedbackValue;
    }

    protected FeedbackValue(){
        // For ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackValue that = (FeedbackValue) o;
        return feedbackValue == that.feedbackValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackValue);
    }

    public static FeedbackValue valueOf(int feedbackValue){
        return new FeedbackValue(feedbackValue);
    }

    @Override
    public String toString() {
        return feedbackValue+"";
    }

    public int value(){
        return feedbackValue;
    }
}
