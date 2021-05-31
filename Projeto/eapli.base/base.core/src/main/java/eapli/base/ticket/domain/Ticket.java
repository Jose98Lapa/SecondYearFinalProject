package eapli.base.ticket.domain;

import eapli.base.form.domain.Form;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.Workflow;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.builder.TicketBuilder;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author 1190731
 */
@Entity
public class Ticket implements AggregateRoot< TicketID >, DTOable< TicketDTO >,Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	private Long version;

	private LocalDate solicitedOn, deadLine;

	@EmbeddedId
	private TicketID id;


	private TicketStatus status;
	private AttachedFile file;
	private Urgency urgency;

	@OneToOne
	private Service service;

	@OneToOne
	private Form ticketForm;

	private TicketWorkflow workflow;

	@Transient
	private TicketBuilder builder;



	public Ticket ( LocalDate solicitedOn, LocalDate deadLine,
					TicketID id, TicketStatus status, AttachedFile file,
					Urgency urgency, Service service, TicketWorkflow workflow, Form ticketForm  ) {
		this.solicitedOn = solicitedOn;
		this.deadLine = deadLine;
		this.id = id;
		this.status = status;
		this.file = file;
		this.urgency = urgency;
		this.service = service;
		this.workflow = workflow;
		this.ticketForm = ticketForm;
		this.builder = new TicketBuilder();
	}

	protected Ticket ( ) {
	}

	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass( ) != o.getClass( ) ) return false;
		Ticket ticket = ( Ticket ) o;
		return Objects.equals( solicitedOn, ticket.solicitedOn ) && Objects.equals( deadLine, ticket.deadLine )
				&& Objects.equals( id, ticket.id ) && Objects.equals( status, ticket.status )
				&& Objects.equals( file, ticket.file ) && Objects.equals( urgency, ticket.urgency );
	}

	public TicketWorkflow workflow(){
		return workflow;
	}

	public Service service(){
		return service;
	}

	@Override
	public int hashCode ( ) {
		return Objects.hash( solicitedOn, deadLine, id, status, file, urgency );
	}

	@Override
	public boolean sameAs ( Object other ) {
		return DomainEntities.areEqual( this, other );
	}

	@Override
	public TicketID identity ( ) {
		return id;
	}

	@Override
	public TicketDTO toDTO ( ) {
		return new TicketDTO( solicitedOn.toString( ), deadLine.toString( ), id.toString( ), status.toString( ), file.toString( ), urgency.toString( ) );
	}

	public TicketStatus status () {
		return this.status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}


}
