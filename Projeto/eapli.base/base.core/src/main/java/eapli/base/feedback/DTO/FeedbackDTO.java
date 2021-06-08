package eapli.base.feedback.DTO;

import eapli.base.ticket.DTO.TicketDTO;


import java.time.LocalDateTime;

public class FeedbackDTO {
    public float id;
    public TicketDTO ticketDTO;
    public int feedbackValue;
    public String email;
    public LocalDateTime localDateTime;

    public FeedbackDTO(float id, TicketDTO ticketDTO, int feedbackValue, String email, LocalDateTime localDateTime) {
        this.id = id;
        this.ticketDTO = ticketDTO;
        this.feedbackValue = feedbackValue;
        this.email = email;
        this.localDateTime = localDateTime;
    }


    public FeedbackDTO(TicketDTO ticketDTO, int feedbackValue, String email, LocalDateTime localDateTime) {
        this.ticketDTO = ticketDTO;
        this.feedbackValue = feedbackValue;
        this.email = email;
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "FeedbackDTO{" +
                "id=" + id +
                ", ticketDTO=" + ticketDTO +
                ", feedbackValue=" + feedbackValue +
                ", email='" + email + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
