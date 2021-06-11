package eapli.base.feedback.DTO;

import eapli.base.ticket.DTO.TicketDTO;

import java.time.LocalDate;


public class FeedbackDTO {
    public float id;
    public TicketDTO ticketDTO;
    public int feedbackValue;
    public String email;


    public FeedbackDTO(float id, TicketDTO ticketDTO, int feedbackValue, String email) {
        this.id = id;
        this.ticketDTO = ticketDTO;
        this.feedbackValue = feedbackValue;
        this.email = email;
    }


    public FeedbackDTO(TicketDTO ticketDTO, int feedbackValue, String email) {
        this.ticketDTO = ticketDTO;
        this.feedbackValue = feedbackValue;
        this.email = email;
    }

    public FeedbackDTO(TicketDTO ticketDTO, int feedbackValue) {
        this.ticketDTO = ticketDTO;
        this.feedbackValue = feedbackValue;
    }

    @Override
    public String toString() {
        return "FeedbackDTO{" +
                "id=" + id +
                ", ticketDTO=" + ticketDTO +
                ", feedbackValue=" + feedbackValue +
                ", email='" + email + '\'' +
                '}';
    }
}
