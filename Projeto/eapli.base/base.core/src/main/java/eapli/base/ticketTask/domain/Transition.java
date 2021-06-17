package eapli.base.ticketTask.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class Transition implements ValueObject, Comparable< Transition >, Serializable {

	@OneToOne
	private TicketTask previousTask;

	@OneToOne
	private TicketTask nextTask;

	protected Transition ( ) {
	}

	public Transition ( TicketTask previousTask, TicketTask nextTask ) {
		this.previousTask = previousTask;
		this.nextTask = nextTask;
	}

	@Override
	public int compareTo ( Transition transition ) {
		return 0;
	}

	public TicketTask previousTask ( ) {
		return previousTask;
	}

	public boolean hasPreviousTask (  ) {
		return this.previousTask != null;

	}

	public TicketTask nextTask ( ) {
		return nextTask;
	}

	public boolean hasNextTask ( ) {
		return this.nextTask != null;
	}

	public void setPreviousTask ( TicketTask previousTask ) {
		this.previousTask = previousTask;
	}

	public void setNextTask ( TicketTask nextTask ) {
		this.nextTask = nextTask;
	}

}
