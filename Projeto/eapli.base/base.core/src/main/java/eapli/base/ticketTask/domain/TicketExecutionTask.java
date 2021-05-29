package eapli.base.ticketTask.domain;

import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class TicketExecutionTask extends TicketManualTask implements DTOable< TicketExecutionTaskDTO >, Serializable {

	protected TicketExecutionTask ( ) {

	}

	@Override
	public TicketExecutionTaskDTO toDTO ( ) {
		return new TicketExecutionTaskDTO(
				super.ticketTaskID.toString(),
				super.transition().previousTask().toString(),
				super.transition().nextTask().toString(),
				super.form()
		);
	}

}
