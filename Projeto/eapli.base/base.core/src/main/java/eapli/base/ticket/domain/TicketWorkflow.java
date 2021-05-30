package eapli.base.ticket.domain;

import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class TicketWorkflow implements ValueObject, Serializable {

	@Id
	private String workflowID;

	private LocalDate startingDate;

	@OneToOne
	private TicketTask starterTask;

	protected TicketWorkflow ( ) {
	}

	public TicketWorkflow ( String workflowID, LocalDate startingDate, TicketTask starter ) {
		setWorkflowID( workflowID );
		setStartingDate( startingDate );
		setStarterTask( starter );
	}

	public TicketWorkflow valueOf ( String workflowID, LocalDate startingDate, TicketTask starter ) {
		return new TicketWorkflow( workflowID, startingDate, starter );
	}

	public void setWorkflowID ( String workflowID ) {
		this.workflowID = workflowID;
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
