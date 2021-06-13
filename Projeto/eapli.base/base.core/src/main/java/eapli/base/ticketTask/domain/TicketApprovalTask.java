package eapli.base.ticketTask.domain;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.task.domain.Task;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class TicketApprovalTask extends TicketManualTask implements DTOable< TicketApprovalTaskDTO >, Serializable {

	public void setApprovedBy(Collaborator approvedBy) {
		this.approvedBy = approvedBy;
	}

	@OneToOne
	private Collaborator approvedBy;

	protected TicketApprovalTask () {

	}

	public TicketApprovalTask (Transition transition, Task mainReference, Form form,
							   LocalDate deadline ) {
		super( transition,mainReference, form, deadline );
	}

	public Form form(){
		return super.form();
	}

	public Collaborator collaborator(){
		return this.approvedBy;
	}

	@Override
	public TicketApprovalTaskDTO toDTO ( ) {
		return new TicketApprovalTaskDTO(
				this.ticketTaskID.toString(),
				this.form(),
				approvedBy
		);
	}

}
