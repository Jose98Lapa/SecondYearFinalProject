package eapli.base.ticketTask.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public abstract class TicketTask  implements DomainEntity< TicketTaskID >, AggregateRoot< TicketTaskID >, Serializable {

	@EmbeddedId
	protected TicketTaskID ticketTaskID;

	private Transition transition;

	protected TicketTask ( ) {
	}

	public TicketTask ( TicketTaskID ticketTaskID, Transition transition ) {
		this.ticketTaskID = ticketTaskID;
		this.transition = transition;
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

}
