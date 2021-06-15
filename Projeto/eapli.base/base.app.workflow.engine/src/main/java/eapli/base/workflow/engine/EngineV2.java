package eapli.base.workflow.engine;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Workflow;
import eapli.base.task.domain.ApprovalTask;
import eapli.base.task.domain.AutomaticTask;
import eapli.base.task.domain.ExecutionTask;
import eapli.base.task.domain.Task;
import eapli.base.task.repository.TaskRepository;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketWorkflow;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.application.CreateTaskController;
import eapli.base.ticketTask.domain.*;
import eapli.base.workflow.engine.utils.TicketTaskPair;
import org.springframework.data.util.Pair;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class EngineV2 {

	private final TicketRepository ticketRepository;
	private final TaskRepository taskRepository;
	private final CreateTaskController ticketTaskController;

	public EngineV2 ( ) {

		this.ticketRepository = PersistenceContext.repositories( ).tickets( );
		this.taskRepository = PersistenceContext.repositories( ).tasks( );
		this.ticketTaskController = new CreateTaskController();
	}

	public void processIncomingTicket ( byte[] payload ) {

		Optional< Ticket > ticketOptional = ticketRepository.ofIdentity( Arrays.toString( payload ) );
		Ticket ticket;

		if ( ticketOptional.isPresent( ) ) {

			ticket = ticketOptional.get( );
			createWorkFlow( ticket );
		}
	}

	private void createWorkFlow ( Ticket ticket ) {

		List< Task > taskList = taskRepository.serviceTasks( ticket.service( ) );
		TicketTaskPair ticketTaskPair;
		TicketWorkflow workflow;

		if ( taskList.size() == 2 ) {

			ticketTaskPair = TicketTaskPair.of( createTask( ticket, taskList.get( 0 ) ), createTask( ticket, taskList.get( 1 ) ) );
			TicketApprovalTask approvalTask = ticketTaskPair.ticketApprovalTask();

			if ( ticketTaskPair.hasAutomaticTask() ) {

				approvalTask.addAfterTask( ticketTaskPair.ticketAutomaticTask( ) );
				ticketTaskController.registerTicketTask( approvalTask );
				ticketTaskController.registerTicketTask( ticketTaskPair.ticketAutomaticTask() );

			} else {

				approvalTask.addAfterTask( ticketTaskPair.ticketExecutionTask( ) );
				ticketTaskController.registerTicketTask( approvalTask );
				ticketTaskController.registerTicketTask( ticketTaskPair.ticketExecutionTask() );

			}

			workflow = new TicketWorkflow( approvalTask );

		} else {

			ticketTaskPair = TicketTaskPair.of( createTask( ticket, taskList.get( 0 ) ), null );

			if ( ticketTaskPair.hasAutomaticTask() ) {

				workflow = new TicketWorkflow( ticketTaskPair.ticketAutomaticTask() );
				ticketTaskController.registerTicketTask( ticketTaskPair.ticketAutomaticTask() );

			} else {
				workflow = new TicketWorkflow( ticketTaskPair.ticketExecutionTask() );
				ticketTaskController.registerTicketTask( ticketTaskPair.ticketExecutionTask() );

			}
		}

		ticket.setWorkflow( workflow );
		ticketRepository.save( ticket );
	}

	private TicketTask createTask( Ticket ticket, Task task ) {

		TicketTask ticketTask;

		if ( task instanceof ApprovalTask ) {

			ApprovalTask approvalTask = ( ApprovalTask ) task;

			ticketTask = new TicketApprovalTask(
					new Transition( null, null ),
					approvalTask,
					approvalTask.form(),
					ticket.deadline()
			);
		} else if ( task instanceof AutomaticTask ) {

			AutomaticTask automaticTask = ( AutomaticTask ) task;

			ticketTask = new TicketAutomaticTask (
					new Transition( null, null ),
					automaticTask,
					automaticTask.scriptPath()
			);
		} else {

			Collaborator executingCollaborator = delegateTask( );

			ExecutionTask executionTask = ( ExecutionTask ) task;

			ticketTask = new TicketExecutionTask(
					new Transition( null, null ),
					executionTask,
					executionTask.form(),
					executingCollaborator,
					ticket.deadline()
			);
		}

		return ticketTask;
	}

	private Collaborator delegateTask ( ) {
		return null;
	}

}
