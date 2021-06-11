package eapli.base.service.domain;

import eapli.base.task.domain.Task;

import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Workflow implements DomainEntity< Long >, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long workflowID;

	private Date startingDate;

	@OneToOne
	private Task starterTask;

	protected Workflow ( ) {
	}

	public Workflow ( Date startingDate, Task starter ) {
		setStartingDate( startingDate );
		setStarterTask( starter );
	}

	@Override
	public boolean sameAs ( Object other ) {
		return false;
	}

	@Override
	public Long identity ( ) {
		return workflowID;
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
