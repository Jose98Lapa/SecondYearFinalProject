package eapli.base.ticketTask.domain;

import eapli.base.task.domain.Task;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public abstract class TicketTask  implements DomainEntity< TicketTaskID >, AggregateRoot< TicketTaskID >, Serializable {

	@EmbeddedId
	protected TicketTaskID ticketTaskID;

	@Embedded
	private Transition transition;

	@OneToOne
	Task mainReference;

	private String status;

	protected TicketTask ( ) {
	}

	public TicketTask ( TicketTaskID ticketTaskID, Transition transition, Task mainReference ) {
		this.ticketTaskID = ticketTaskID;
		this.transition = transition;
		this.status = "INCOMPLETE";
		this.mainReference = mainReference;
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

	public Task mainReference(){
		return this.mainReference;
	}

}
