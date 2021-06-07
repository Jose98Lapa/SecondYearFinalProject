package eapli.base.feedback.DTO;

import eapli.base.ticket.DTO.TicketDTO;

public class FeedbackDTO {
    public float id;
    public TicketDTO ticketDTO;
    public int feedbackValue;

    public FeedbackDTO(float id, TicketDTO ticketDTO, int feedbackValue) {
        this.id = id;
        this.ticketDTO = ticketDTO;
        this.feedbackValue = feedbackValue;
    }

    public FeedbackDTO(TicketDTO ticketDTO, int feedbackValue) {
        this.ticketDTO = ticketDTO;
        this.feedbackValue = feedbackValue;
    }
}
