package eapli.base.ticketTask.DTO;


public class TicketAutomaticTaskDTO {

	public String ticketTaskID;
	public String scriptPath;
	public String previousTask;
	public String nextTask;

	public TicketAutomaticTaskDTO ( String ticketTaskID, String scriptPath, String previousTask, String nextTask ) {
		this.ticketTaskID = ticketTaskID;
		this.scriptPath = scriptPath;
		this.previousTask = previousTask;
		this.nextTask = nextTask;
	}

	@Override
	public String toString() {
		return
				"ticket Task ID=" + ticketTaskID +
				", script Path=" + scriptPath +
				", previous Task=" + previousTask +
				", next Task=" + nextTask;
	}
}
