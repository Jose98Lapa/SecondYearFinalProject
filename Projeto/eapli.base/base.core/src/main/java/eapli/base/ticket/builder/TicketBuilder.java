package eapli.base.ticket.builder;

import eapli.base.form.DTO.FormDTO;
import eapli.base.form.DTO.FormDTOParser;
import eapli.base.form.domain.Form;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.service.DTO.ServiceDTOParser;
import eapli.base.service.domain.Service;
import eapli.base.ticket.domain.*;
import eapli.framework.domain.model.DomainFactory;

import java.time.LocalDate;

public class TicketBuilder implements DomainFactory< Ticket > {

	/*public String solicitedOn, deadLine, completedOn;
	public TicketID id;
	public TicketStatus status;
	public AttachedFile file;
	public Urgency urgency;
	public ServiceDTO service;
	public TicketWorkflow workflow;
	public FormDTO form;
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

	*//*public TicketBuilder withService ( ServiceDTO service ) {
		this.service = service;
		return this;
	}*//*

	public TicketBuilder withService ( Service service ) {
		this.service = service;
		return this;
	}

	public TicketBuilder withWorkFlow ( TicketWorkflow workflow ) {
		this.workflow = workflow;
		return this;
	}

	public TicketBuilder withForm ( FormDTO form ) {
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
				LocalDate.parse( completedOn ),
				status,
				file,
				urgency,
				new ServiceDTOParser( ).valueOf( this.service ),
				workflow,
				new FormDTOParser( ).valueOf( this.form ),
				requestedBy );
	}*/

	private LocalDate solicitedOn, deadLine;
	private TicketStatus status;
	private AttachedFile file;
	private Urgency urgency;
	private Service service;
	private TicketWorkflow workflow;
	private Form form;
	public String requestedBy;

	public TicketBuilder solicitedOn ( String solicitedOn ) {
		this.solicitedOn = LocalDate.parse( solicitedOn );
		return this;
	}

	public TicketBuilder withDeadLine ( String deadLine ) {
		this.deadLine = LocalDate.parse( deadLine );
		return this;
	}

	public TicketBuilder withRequestedBy ( String collaboratorEmail ) {
		this.requestedBy = collaboratorEmail;
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

	@Override
	public Ticket build ( ) {
		return new Ticket( solicitedOn, deadLine, status, file, urgency, service, workflow, form , requestedBy);
	}

}
