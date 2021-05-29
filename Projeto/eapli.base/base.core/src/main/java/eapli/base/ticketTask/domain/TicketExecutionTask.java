package eapli.base.ticketTask.domain;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class TicketExecutionTask extends TicketManualTask implements DTOable< TicketExecutionTaskDTO >, Serializable {

	@OneToOne
	private Collaborator executedBy;

	protected TicketExecutionTask ( ) {

	}

	public TicketExecutionTask ( TicketTaskID ticketTaskID, Transition transition,
								 Form form, Collaborator executedBy, LocalDateTime deadline ) {
		super( ticketTaskID, transition, form, deadline );
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

}
