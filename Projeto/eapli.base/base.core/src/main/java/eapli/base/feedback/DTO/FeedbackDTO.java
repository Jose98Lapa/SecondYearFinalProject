package eapli.base.feedback.DTO;

import eapli.base.ticket.DTO.TicketDTO;

import java.time.LocalDate;


public class FeedbackDTO {
    public float id;
    public TicketDTO ticketDTO;
    public int feedbackValue;
    public String email;
    public LocalDate localDate;

    public FeedbackDTO(float id, TicketDTO ticketDTO, int feedbackValue, String email, LocalDate localDate) {
        this.id = id;
        this.ticketDTO = ticketDTO;
        this.feedbackValue = feedbackValue;
        this.email = email;
        this.localDate = localDate;
    }


    public FeedbackDTO(TicketDTO ticketDTO, int feedbackValue, String email, LocalDate localDate) {
        this.ticketDTO = ticketDTO;
        this.feedbackValue = feedbackValue;
        this.email = email;
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "FeedbackDTO{" +
                "id=" + id +
                ", ticketDTO=" + ticketDTO +
                ", feedbackValue=" + feedbackValue +
                ", email='" + email + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}
