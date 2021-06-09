package eapli.base.ticketTask.domain;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.task.domain.Task;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class TicketExecutionTask extends TicketManualTask implements DTOable< TicketExecutionTaskDTO >, Serializable {

	@OneToOne
	private Collaborator executedBy;

	protected TicketExecutionTask ( ) {

	}

	public TicketExecutionTask (TicketTaskID ticketTaskID, Transition transition, Task mainReference,
								Form form, Collaborator executedBy, LocalDate deadline ) {
		super( ticketTaskID, transition, mainReference , form, deadline);
		this.executedBy = executedBy;
	}

	@Override
	public TicketExecutionTaskDTO toDTO ( ) {
		return new TicketExecutionTaskDTO(
				super.ticketTaskID.toString(),
				super.transition().previousTask().toString(),
				super.transition().nextTask().toString(),
				super.form(),
				this.executedBy
		);
	}

	public void setExecutedBy(Collaborator executedBy) {
		this.executedBy = executedBy;
	}

	public Collaborator collaborator(){
		return this.executedBy;
	}
}
