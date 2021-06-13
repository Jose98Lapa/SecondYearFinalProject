package eapli.base.ticket.builder;
import eapli.base.form.domain.Form;
import eapli.base.service.domain.Service;
import eapli.base.ticket.domain.*;
import eapli.framework.domain.model.DomainFactory;

import java.time.LocalDate;

public class TicketBuilder implements DomainFactory< Ticket > {

	public String solicitedOn, deadLine, completedOn;
	public TicketID id;
	public TicketStatus status;
	public AttachedFile file;
	public Urgency urgency;
	public Service service;
	public TicketWorkflow workflow;
	public Form form;
	public String requestedBy;

	public TicketBuilder solicitedOn ( String solicitedOn ) {
		this.solicitedOn = solicitedOn;
		return this;
	}

	public TicketBuilder withDeadLine ( String deadLine ) {
		this.deadLine = deadLine;
		return this;
	}

	public TicketBuilder completedOn ( String completedOn ) {
		this.completedOn = completedOn;
		return this;
	}


	public TicketBuilder withStatus ( String status ) {
		this.status = TicketStatus.valueOf( status );
		return this;
	}

	public TicketBuilder withPossibleFile ( String ficheiro ) {
		this.file = AttachedFile.valueOf( ficheiro );
		return this;
	}

	public TicketBuilder withUrgency ( String urgencia ) {
		this.urgency = Urgency.valueOf( urgencia );
		return this;
	}

	public TicketBuilder withService ( Service service ) {
		this.service = service;
		return this;
	}

	public TicketBuilder withWorkFlow ( TicketWorkflow workflow ) {
		this.workflow = workflow;
		return this;
	}

	public TicketBuilder withForm ( Form form ) {
		this.form = form;
		return this;
	}

	public TicketBuilder requestedBy ( String collaboratorEmail ) {
		this.requestedBy = collaboratorEmail;
		return this;
	}

	@Override
	public Ticket build ( ) {
		return new Ticket(
				LocalDate.parse( solicitedOn ),
				LocalDate.parse( deadLine ),
				this.status,
				this.file,
				this.urgency,
				this.service,
				this.workflow,
				this.form,
				this.requestedBy );
	}
}
