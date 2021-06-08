package eapli.base.ticketTask.domain;

import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public abstract class TicketTask  implements DomainEntity< TicketTaskID >, AggregateRoot< TicketTaskID >, Serializable {

	@EmbeddedId
	protected TicketTaskID ticketTaskID;

	private Transition transition;

	private String status;

	protected TicketTask ( ) {
	}

	public TicketTask ( TicketTaskID ticketTaskID, Transition transition ) {
		this.ticketTaskID = ticketTaskID;
		this.transition = transition;
		this.status = "INCOMPLETE";
	}

	@Override
	public TicketTaskID identity ( ) {
		return ticketTaskID;
	}

	@Override
	public boolean sameAs ( Object other ) {
		return DomainEntities.areEqual( this, other );
	}

	public Transition transition ( ) {
		return transition;
	}

	public void completeTask(){
		this.status = "COMPLETE";
	}

	public String status(){
		return this.status;
	}



}
