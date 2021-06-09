package eapli.base.ticketTask.domain;

import eapli.base.form.domain.Form;
import eapli.base.task.domain.Task;

import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class TicketManualTask extends TicketTask implements Serializable {

	@OneToOne
	private Form form;

	private LocalDate deadline;


	protected TicketManualTask ( ) {
	}

	public TicketManualTask (TicketTaskID ticketTaskID, Transition transition, Task mainReference, Form form, LocalDate deadline ) {
		super( ticketTaskID, transition, mainReference );
		this.form = form;
		this.deadline = deadline;
	}

	public Form form () {
		return form;
	}

}
