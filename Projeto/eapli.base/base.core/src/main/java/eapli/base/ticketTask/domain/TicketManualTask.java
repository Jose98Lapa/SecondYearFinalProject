package eapli.base.ticketTask.domain;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.task.domain.Task;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public abstract class TicketManualTask extends TicketTask implements Serializable {

	@OneToOne
	private Form form;

	private LocalDate deadline;

	private LocalDateTime dateStarted, dateEnded;


	protected TicketManualTask ( ) {
	}

	public TicketManualTask (Transition transition, Task mainReference, Form form, LocalDate deadline ) {
		super( transition, mainReference );
		this.form = form;
		this.deadline = deadline;
	}

	public Form form () {
		return form;
	}

	public void updateForm(Form form){
		this.form = form;
	}

	public String deadline(){
		return deadline.toString();
	}

	public void redeemTask() {
		dateStarted = LocalDateTime.now();
	}

	@Override
	public void completeTask(){
		super.completeTask();
		dateEnded = LocalDateTime.now();
	}

	public long getTimeInMinutesOfExecution(){
		return dateStarted.until(dateEnded, ChronoUnit.MINUTES);
	}

}
