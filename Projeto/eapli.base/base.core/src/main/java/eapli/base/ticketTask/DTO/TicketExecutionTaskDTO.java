package eapli.base.ticketTask.DTO;

import eapli.base.form.domain.Form;

public class TicketExecutionTaskDTO {

	public String ticketTaskID;
	public String previousTask;
	public String nextTask;
	public Form form;

	public TicketExecutionTaskDTO ( String ticketTaskID, String previousTask, String nextTask, Form form ) {
		this.ticketTaskID = ticketTaskID;
		this.previousTask = previousTask;
		this.nextTask = nextTask;
		this.form = form;
	}

}
