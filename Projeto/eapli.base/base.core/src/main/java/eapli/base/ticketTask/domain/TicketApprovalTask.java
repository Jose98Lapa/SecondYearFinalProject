package eapli.base.ticketTask.domain;

import eapli.base.form.domain.Form;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class TicketApprovalTask extends TicketManualTask implements DTOable< TicketApprovalTaskDTO >, Serializable {

	protected TicketApprovalTask () {

	}

	public TicketApprovalTask ( TicketTaskID ticketTaskID, Transition transition, Form form ) {
		super( ticketTaskID, transition, form );
	}

	public Form form(){
		return super.form();
	}

	@Override
	public TicketApprovalTaskDTO toDTO ( ) {
		return new TicketApprovalTaskDTO(
				this.ticketTaskID.toString(),
				this.transition().previousTask().toString(),
				this.transition().nextTask().toString(),
				this.form()
		);
	}

}
