package eapli.base.ticket.domain;

import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Embeddable
public class TicketWorkflow implements ValueObject, Serializable {



	private LocalDate startingDate;

	@OneToOne(cascade = CascadeType.ALL)
	private TicketTask starterTask;

	protected TicketWorkflow ( ) {
	}

	public TicketWorkflow (LocalDate startingDate, TicketTask starter ) {

		setStartingDate( startingDate );
		setStarterTask( starter );
	}

	public TicketWorkflow valueOf (LocalDate startingDate, TicketTask starter ) {
		return new TicketWorkflow( startingDate, starter );
	}



	public LocalDate startingDate ( ) {
		return startingDate;
	}

	public void setStartingDate ( LocalDate startingDate ) {
		this.startingDate = startingDate;
	}

	public TicketTask starterTask ( ) {
		return starterTask;
	}

	public void setStarterTask ( TicketTask starterTask ) {
		this.starterTask = starterTask;
	}

}
