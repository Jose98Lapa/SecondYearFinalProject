package eapli.base.ticket.domain;

import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class TicketWorkflow implements DomainEntity< String >, Serializable {

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
