package eapli.base.ticket.builder;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.service.domain.Service;
import eapli.base.ticket.domain.*;
import eapli.framework.domain.model.DomainFactory;

import java.sql.Date;
import java.time.LocalDate;

public class TicketBuilder implements DomainFactory< Ticket > {

	private Date solicitedOn, deadLine;
	private TicketID id;
	private TicketStatus status;
	private AttachedFile file;
	private Urgency urgency;
	private Service service;
	private TicketWorkflow workflow;
	private Form form;
	private Collaborator requestedBy;

	public TicketBuilder solicitedOn ( String solicitedOn ) {
		this.solicitedOn = Date.valueOf( solicitedOn );
		return this;
	}

	public TicketBuilder withDeadLine ( String deadLine ) {
		this.deadLine = Date.valueOf( deadLine );
		return this;
	}

	public TicketBuilder withId ( String id ) {
		this.id = TicketID.valueOf( id );
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

	public TicketBuilder requestedBy ( Collaborator collaborator ) {
		this.requestedBy = collaborator;
		return this;
	}

	@Override
	public Ticket build ( ) {
		return new Ticket( solicitedOn, deadLine, status, file, urgency, service, workflow, form, requestedBy );
	}

}
