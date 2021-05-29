package eapli.base.ticketTask.domain;

import eapli.base.form.domain.Form;

import javax.persistence.OneToOne;
import java.io.Serializable;

public abstract class TicketManualTask extends TicketTask implements Serializable {

	@OneToOne
	private Form form;

	protected TicketManualTask ( ) {
	}

	public TicketManualTask ( TicketTaskID ticketTaskID, Transition transition, Form form ) {
		super( ticketTaskID, transition );
		this.form = form;
	}

	public Form form () {
		return form;
	}

}
