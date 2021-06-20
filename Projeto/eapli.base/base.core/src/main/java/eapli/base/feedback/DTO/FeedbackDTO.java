package eapli.base.feedback.DTO;

import eapli.base.ticket.DTO.TicketDTO;

import java.time.LocalDate;


public class FeedbackDTO {
    public float id;
    public int feedbackValue;
    public String email;


    public FeedbackDTO(float id, int feedbackValue, String email) {
        this.id = id;

        this.feedbackValue = feedbackValue;
        this.email = email;
    }


    public FeedbackDTO(int feedbackValue, String email) {

        this.feedbackValue = feedbackValue;
        this.email = email;
    }

    public FeedbackDTO( int feedbackValue) {
        this.feedbackValue = feedbackValue;
    }

    @Override
    public String toString() {
        return "FeedbackDTO{" +
                "id=" + id +
                ", feedbackValue=" + feedbackValue +
                ", email='" + email + '\'' +
                '}';
    }
}
