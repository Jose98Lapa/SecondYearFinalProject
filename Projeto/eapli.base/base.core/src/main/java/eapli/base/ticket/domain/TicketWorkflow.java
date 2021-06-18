package eapli.base.ticket.domain;

import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketAutomaticTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import javax.swing.text.html.Option;
import java.io.Serializable;
import java.nio.file.OpenOption;
import java.time.LocalDate;
import java.util.Optional;

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

	public String starterTaskType ( ) {
		return starterTask.taskType();
	}

	public boolean hasSecondTask ( ) {
		return starterTask.transition().hasNextTask();
	}

	public String secondTaskType ( ) {
		return starterTask.transition().nextTask().taskType();
	}

	public Optional< TicketApprovalTask > approvalTask () {

		Optional< TicketApprovalTask > optional = Optional.empty();

		if ( starterTask.taskType( ).equals( "APPROVAL" ) ) {
			optional = Optional.of( ( TicketApprovalTask ) starterTask );
		}

		return optional;
	}

	public Optional< TicketAutomaticTask > automaticTask () {

		Optional< TicketAutomaticTask > optional = Optional.empty();

		if ( starterTask.taskType( ).equals( "AUTOMATIC" ) ) {
			optional = Optional.of( ( TicketAutomaticTask ) starterTask );
		} else if ( secondTaskType().equals( "AUTOMATIC" ) ) {
			optional = Optional.of( ( TicketAutomaticTask ) starterTask.transition().nextTask() );
		}

		return optional;
	}

	public Optional< TicketExecutionTask > executionTask () {

		Optional< TicketExecutionTask > optional = Optional.empty();

		if ( starterTask.taskType( ).equals( "EXECUTION" ) ) {
			optional = Optional.of( ( TicketExecutionTask ) starterTask );
		} else if ( secondTaskType().equals( "EXECUTION" ) ) {
			optional = Optional.of( ( TicketExecutionTask ) starterTask.transition().nextTask() );
		}

		return optional;
	}
}
