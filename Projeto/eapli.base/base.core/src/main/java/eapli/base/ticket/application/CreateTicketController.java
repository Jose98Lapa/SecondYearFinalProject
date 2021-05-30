package eapli.base.ticket.application;

import eapli.base.AppSettings;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;
import eapli.base.task.domain.ApprovalTask;
import eapli.base.task.domain.AutomaticTask;
import eapli.base.task.domain.ExecutionTask;
import eapli.base.task.domain.Task;
import eapli.base.ticket.builder.TicketBuilder;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketWorkflow;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.application.CreateTaskController;
import eapli.base.ticketTask.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class CreateTicketController {

	private TicketBuilder builder;
	private CreateTaskController ticketTaskController;
	private final TicketRepository ticketRepository = PersistenceContext.repositories().tickets();

	public CreateTicketController ( ) {
	}


	public void createTicket ( String deadline, String id, String file, Service service, String urgency ) {

		this.ticketTaskController = new CreateTaskController( );
		if ( service.workflow()!=null && service.workflow().starterTask() != null ) {

		Task starter = service.workflow( ).starterTask( );

		TicketTask starterTicketTask = createTicketTask( deadline, starter );

		if ( starterTicketTask.transition().hasNextTask() ) {
			createTicketTask( deadline, starterTicketTask );
		}

		TicketWorkflow workflow = new TicketWorkflow(
				service.workflow( ).identity( ),
				LocalDate.now( ),
				starterTicketTask
				);


		Ticket ticket = builder.solicitedOn( LocalDate.now( ).toString( ) )
				.withDeadLine( deadline )
				.withId( id )
				.withPossibleFile( file )
				.withService( service )
				.withStatus( "Pending" )
				.withUrgency( urgency )
				.withWorkFlow( workflow )
				.build( );

		ticketRepository.save( ticket );
		}
	}

	private TicketTask createTicketTask ( String deadline, Task starter ) {
		if ( starter instanceof ApprovalTask ) {
			TicketApprovalTask approvalTask = new TicketApprovalTask(
					new TicketTaskID( starter.identity( ).toString( ) ),
					new Transition( null, null ), ( ( ApprovalTask ) starter ).form( ),
					LocalDateTime.parse( deadline ) );

			this.ticketTaskController.registerApprovalTask( approvalTask );
			return approvalTask;
		}

		if ( starter instanceof ExecutionTask ) {
			TicketExecutionTask executionTask = new TicketExecutionTask(
					new TicketTaskID( starter.identity( ).toString( ) ),
					new Transition( null, null ),
					( ( ExecutionTask ) starter ).form( ),
					null,
					LocalDateTime.parse( deadline ) );

			this.ticketTaskController.registerExecutionTask( executionTask );
			return executionTask;
		}

		if ( starter instanceof AutomaticTask ) {
			TicketAutomaticTask automaticTask = new TicketAutomaticTask(
					new TicketTaskID( starter.identity( ).toString( ) ),
					new Transition( null, null ),
					( ( AutomaticTask ) starter ).scriptPath( )
			);

			this.ticketTaskController.registerAutomaticTask( automaticTask );
			return automaticTask;
		}

		return null;
	}

	private TicketTask createTicketTask ( String deadline, TicketTask starter ) {
		if ( starter instanceof TicketApprovalTask ) {
			TicketApprovalTask approvalTask = new TicketApprovalTask(
					new TicketTaskID( starter.identity( ).toString( ) ),
					new Transition( null, null ), ( ( TicketApprovalTask ) starter ).form( ),
					LocalDateTime.parse( deadline ) );

			this.ticketTaskController.registerApprovalTask( approvalTask );
			return approvalTask;
		}

		if ( starter instanceof TicketExecutionTask ) {
			TicketExecutionTask executionTask = new TicketExecutionTask(
					new TicketTaskID( starter.identity( ).toString( ) ),
					new Transition( null, null ),
					( ( TicketExecutionTask ) starter ).form( ),
					null,
					LocalDateTime.parse( deadline ) );

			this.ticketTaskController.registerExecutionTask( executionTask );
			return executionTask;
		}

		if ( starter instanceof TicketAutomaticTask ) {
			TicketAutomaticTask automaticTask = new TicketAutomaticTask(
					new TicketTaskID( starter.identity( ).toString( ) ),
					new Transition( null, null ),
					( ( TicketAutomaticTask ) starter ).scriptPath( )
			);

			this.ticketTaskController.registerAutomaticTask( automaticTask );
			return automaticTask;
		}

		return null;
	}

}
