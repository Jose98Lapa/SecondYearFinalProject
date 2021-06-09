package eapli.base.ticket.domain;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.domain.Form;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.Workflow;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.application.GenerateTicketID;
import eapli.base.ticket.builder.TicketBuilder;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author 1190731
 */
@Entity
public class Ticket implements AggregateRoot< String >, DTOable< TicketDTO >,Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	private Long version;

	private Date solicitedOn, deadLine, completedOn;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
	@GenericGenerator(
			name = "ticket_seq",
			strategy = "eapli.base.ticket.application.GenerateTicketID",
			parameters = {@org.hibernate.annotations.Parameter(name = GenerateTicketID.INCREMENT_PARAM, value = "1")})
	private String ID;

	private TicketStatus status;
	private AttachedFile file;
	private Urgency urgency;

	@OneToOne
	private Service service;

	@OneToOne
	private Collaborator requestedBy;

	@OneToOne( cascade = CascadeType.ALL)
	private Form ticketForm;

	private TicketWorkflow workflow;

	@Transient
	private TicketBuilder builder;

	private String client;

	private LocalDate endDate;



	public Ticket ( Date solicitedOn, Date deadLine,
					TicketStatus status, AttachedFile file,
					Urgency urgency, Service service, TicketWorkflow workflow,
					Form ticketForm, Collaborator requestedBy  ) {
		this.solicitedOn = solicitedOn;
		this.deadLine = deadLine;
		this.status = status;
		this.file = file;
		this.urgency = urgency;
		this.service = service;
		this.workflow = workflow;
		this.ticketForm = ticketForm;
		this.requestedBy = requestedBy;
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
				&& Objects.equals( ID, ticket.ID ) && Objects.equals( status, ticket.status )
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
		return Objects.hash( solicitedOn, deadLine, ID, status, file, urgency );
	}

	@Override
	public boolean sameAs ( Object other ) {
		return DomainEntities.areEqual( this, other );
	}

	@Override
	public String identity ( ) {
		return ID;
	}

	@Override
	public TicketDTO toDTO ( ) {
		return new TicketDTO( solicitedOn.toString( ), deadLine.toString( ), ID.toString( ), status.toString( ), file.toString( ), urgency.toString( ) );
	}

	public TicketStatus status () {
		return this.status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public boolean checkIfTicketTaskBelongsToTicket(TicketTask ticketTask){
		return checkIfTicketTaskBelongsToTicket(ticketTask,this.workflow.starterTask());
	}

	private boolean checkIfTicketTaskBelongsToTicket(TicketTask ticketTask,TicketTask starterTask){
		if (starterTask==null)
			return false;
		if (starterTask.sameAs(ticketTask)){
			return true;
		}else{
			if (starterTask.transition()==null)
				return false;
			return checkIfTicketTaskBelongsToTicket(ticketTask,starterTask.transition().nextTask());
		}
	}

	public Form ticketForm(){
		return this.ticketForm;
	}

	public void approveTicket(){
		this.status = TicketStatus.valueOf("APPROVED");
	}

	public void disapproveTicket(){
		this.status = TicketStatus.valueOf("DISAPPROVED");
		this.endDate = LocalDate.now();
	}

	public void pendingExecutingTicket(){
		this.status = TicketStatus.valueOf("PENDING_EXECUTION");
	}

	public void endTicket(){
		this.status = TicketStatus.valueOf("CONCLUDED");
		this.endDate = LocalDate.now();
	}

}
