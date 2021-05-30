package eapli.base.ticket.application;

import eapli.base.service.domain.Service;
import eapli.base.task.domain.ApprovalTask;
import eapli.base.task.domain.Task;
import eapli.base.ticket.builder.TicketBuilder;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketWorkflow;
import eapli.base.ticketTask.application.CreateTaskController;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.Transition;

import java.time.LocalDate;


public class CreateTicketController {

	private TicketBuilder builder;
	private CreateTaskController ticketTaskController;

	public CreateTicketController ( ) {
	}


	public void createTicket ( String deadline, String id, String file, Service service, String urgency  ) {

		this.ticketTaskController = new CreateTaskController( );
		Task starter = service.workflow().starterTask();

		/**if ( starter instanceof ApprovalTask  ) {
			TicketApprovalTask approvalTask = new TicketApprovalTask(
					starter.identity(),
					new Transition( ( ApprovalTask ) starter,  ) );
		}


		/**TicketWorkflow workflow = new TicketWorkflow(
				service.workflow().identity(),
				LocalDate.now(),
				);



		Ticket ticket = builder.solicitedOn( LocalDate.now().toString() )
				.withDeadLine( deadline )
				.withId( id )
				.withPossibleFile( file )
				.withService( service )
				.withStatus( "Pending" )
				.withUrgency( urgency )
				.withWorkFlow( workflow )
				.build();

**/
	}
}
