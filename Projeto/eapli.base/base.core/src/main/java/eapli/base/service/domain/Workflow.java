package eapli.base.ticket.domain;

import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

public class Workflow implements DomainEntity< String >, Serializable {

	@Id
	private String workflowID;

	private Date startingDate;

	@OneToOne
	private TicketTask starterTask;

	protected Workflow ( ) {
	}

	protected Workflow ( String workflowID, Date startingDate, TicketTask starter ) {
		setWorkflowID( workflowID );
		setStartingDate( startingDate );
		setStarterTask( starter );
	}

	@Override
	public boolean sameAs ( Object other ) {
		return false;
	}

	@Override
	public String identity ( ) {
		return workflowID;
	}

	public void setWorkflowID ( String workflowID ) {
		this.workflowID = workflowID;
	}

	public Date startingDate ( ) {
		return startingDate;
	}

	public void setStartingDate ( Date startingDate ) {
		this.startingDate = startingDate;
	}

	public TicketTask starterTask ( ) {
		return starterTask;
	}

	public void setStarterTask ( TicketTask starterTask ) {
		this.starterTask = starterTask;
	}

}
