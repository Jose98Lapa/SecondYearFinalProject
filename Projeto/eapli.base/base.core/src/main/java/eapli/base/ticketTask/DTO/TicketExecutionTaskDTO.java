package eapli.base.ticketTask.DTO;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;

public class TicketExecutionTaskDTO {

	public String ticketTaskID;
	public String previousTask;
	public String nextTask;
	public Form form;
	public Collaborator executedBy;

	public TicketExecutionTaskDTO ( String ticketTaskID, String previousTask, String nextTask,
									Form form, Collaborator executedBy ) {
		this.ticketTaskID = ticketTaskID;
		this.previousTask = previousTask;
		this.nextTask = nextTask;
		this.form = form;
		this.executedBy = executedBy;
	}

}
