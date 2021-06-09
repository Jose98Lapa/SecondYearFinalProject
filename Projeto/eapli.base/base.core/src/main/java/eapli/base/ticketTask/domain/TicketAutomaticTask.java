package eapli.base.ticketTask.domain;

import eapli.base.task.domain.ScriptPath;
import eapli.base.task.domain.Task;
import eapli.base.ticketTask.DTO.TicketAutomaticTaskDTO;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class TicketAutomaticTask extends TicketTask implements DTOable< TicketAutomaticTaskDTO > , Serializable {

	@Embedded
	private ScriptPath scriptPath;

	protected TicketAutomaticTask () {

	}

	public TicketAutomaticTask (TicketTaskID ticketTaskID, Transition transition, Task mainReference, ScriptPath scriptPath ) {
		super( ticketTaskID, transition, mainReference );
		this.scriptPath = scriptPath;
	}

	@Override
	public TicketAutomaticTaskDTO toDTO ( ) {
		return new TicketAutomaticTaskDTO(
				this.ticketTaskID.toString(),
				this.scriptPath.toString(),
				this.transition().previousTask().toString(),
				this.transition().nextTask().toString()
		);
	}

	public ScriptPath scriptPath () {
		return scriptPath;
	}
}
