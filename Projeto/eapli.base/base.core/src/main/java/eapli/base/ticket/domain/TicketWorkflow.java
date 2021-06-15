package eapli.base.ticket.domain;

import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class TicketWorkflow implements ValueObject, Serializable {

	@OneToOne(cascade = CascadeType.ALL)
	private TicketTask starterTask;

	protected TicketWorkflow ( ) {
	}

	public TicketWorkflow ( TicketTask starter ) {

		setStarterTask( starter );
	}

	public TicketWorkflow valueOf ( TicketTask starter ) {
		return new TicketWorkflow( starter );
	}


	public TicketTask starterTask ( ) {
		return starterTask;
	}

	public void setStarterTask ( TicketTask starterTask ) {
		this.starterTask = starterTask;
	}

	public TicketTask getFirstIncompleteTask(){
		return this.getFirstIncompleteTask(starterTask());
	}

	private TicketTask getFirstIncompleteTask(TicketTask starterTask){
		if (starterTask == null)
			return null;

		if (starterTask.status().equals("INCOMPLETE")){
			return starterTask;
		}else{
			return getFirstIncompleteTask(starterTask.transition().nextTask());
		}
	}


}
