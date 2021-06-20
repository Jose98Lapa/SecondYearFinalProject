package eapli.base.ticketTask.DTO;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;

public class TicketApprovalTaskDTO {

	public String ticketTaskID;
	public String previousTask;
	public String nextTask;
	public Form form;
	public Collaborator approvedBy;
	public String mainReference;
	public String deadline;

	public TicketApprovalTaskDTO ( String ticketTaskID, String previousTask,
								   String nextTask, Form form, Collaborator approvedBy ) {
		this.ticketTaskID = ticketTaskID;
		this.previousTask = previousTask;
		this.nextTask = nextTask;
		this.form = form;
		this.approvedBy = approvedBy;
	}

	public TicketApprovalTaskDTO(String ticketTaskID, Form form, Collaborator approvedBy) {
		this.ticketTaskID = ticketTaskID;
		this.form = form;
		this.approvedBy = approvedBy;
	}

	@Override
	public String toString() {
		return "TicketApprovalTaskDTO{" +
				"ticketTaskID='" + ticketTaskID + '\'' +
				", form=" + form +
				", approvedBy=" + approvedBy +
				'}';
	}
}
