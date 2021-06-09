package eapli.base.service.domain;

import eapli.base.task.domain.Task;

import eapli.framework.domain.model.DomainEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Workflow implements DomainEntity< String >, Serializable {

	@Id
	private String workflowID;

	private Date startingDate;

	@OneToOne
	private Task starterTask;

	protected Workflow ( ) {
	}

	public Workflow ( String workflowID, Date startingDate, Task starter ) {
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

	public Task starterTask ( ) {
		return starterTask;
	}

	public void setStarterTask ( Task starterTask ) {
		this.starterTask = starterTask;
	}

}
