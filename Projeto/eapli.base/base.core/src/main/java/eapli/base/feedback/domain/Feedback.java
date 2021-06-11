package eapli.base.feedback.domain;



import eapli.base.feedback.DTO.FeedbackDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Feedback implements AggregateRoot<Long>,DTOable<FeedbackDTO>, Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long identity;
    @Embedded
    private FeedbackValue feedbackValue;
    @OneToOne
    private Ticket relativeToThisTicket;
    private String clientEmail;

    public Feedback(FeedbackValue feedbackValue, Ticket relativeToThisTicket,String clientEmail) {
        this.feedbackValue = feedbackValue;
        this.relativeToThisTicket = relativeToThisTicket;
        this.clientEmail = clientEmail;
    }

    public Feedback(Long identity, FeedbackValue feedbackValue, Ticket relativeToThisTicket,String clientEmail) {
        this.identity = identity;
        this.feedbackValue = feedbackValue;
        this.relativeToThisTicket = relativeToThisTicket;
        this.clientEmail = clientEmail;
    }

    protected Feedback(){
        // For ORM
    }

    public Ticket ticket(){
        return relativeToThisTicket;
    }



    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public Long identity() {
        return identity;
    }

    @Override
    public FeedbackDTO toDTO() {
        return new FeedbackDTO(identity,relativeToThisTicket.toDTO(),Integer.parseInt(feedbackValue.toString()),clientEmail);
    }
}
