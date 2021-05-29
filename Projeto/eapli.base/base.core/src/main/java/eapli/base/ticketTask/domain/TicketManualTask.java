package eapli.base.ticketTask.domain;

import eapli.base.form.domain.Form;

import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class TicketManualTask extends TicketTask implements Serializable {

	@OneToOne
	private Form form;

	private LocalDateTime deadline;


	protected TicketManualTask ( ) {
	}

	public TicketManualTask ( TicketTaskID ticketTaskID, Transition transition, Form form, LocalDateTime deadline ) {
		super( ticketTaskID, transition );
		this.form = form;
		this.deadline = deadline;
	}

	public Form form () {
		return form;
	}

}
