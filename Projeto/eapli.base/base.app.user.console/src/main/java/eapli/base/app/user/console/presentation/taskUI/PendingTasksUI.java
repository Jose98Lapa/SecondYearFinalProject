package eapli.base.app.user.console.presentation.taskUI;

import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.application.TicketService;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.application.TicketTaskController;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.fusesource.jansi.Ansi;
import org.springframework.data.util.Pair;

import java.util.List;

public class PendingTasksUI extends AbstractUI {

	private TicketTaskController ticketTaskController;
	private TicketService service;

	@Override
	protected boolean doShow ( ) {

		ticketTaskController = new TicketTaskController( );
		service = new TicketService( );

		System.out.println( "+=====================================================================================+" );
		System.out.println( "|                                  Tarefas Pendentes                                  |" );
		System.out.println( "*=====================================================================================*" );
		System.out.println( "|                                          |                                          |" );
		System.out.println( "|    Como quer ordenar?                    |    Como quer filtrar?                    |" );
		System.out.println( "|                                          |                                          |" );
		System.out.println( "|    1: Urgencia                           |    1: Urgencia [reduzida]                |" );
		System.out.println( "|    2: Deadline[ baixa -> alta ]          |    2: Urgencia [moderada]                |" );
		System.out.println( "|    3: Data solicitacao [ baixa-> alta ]  |    3: Urgencia [urgente]                 |" );
		System.out.println( "|                                          |                                          |" );
		System.out.println( "*=====================================================================================*" );
		int order = Console.readOption( 1, 3, 0 );
		int filter = Console.readOption( 1, 3, 0 );
		clearScreen();

		System.out.println( "*=====================================================================================*" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "|    Tarefas de Aprovacao                                                             |" );
		System.out.println( "|                                                                                     |" );
		displayApprovalTasks( order, filter );
		System.out.println( "|                                                                                     |" );
		System.out.println( "*=====================================================================================*" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "|    Tarefas de Execucao                                                              |" );
		System.out.println( "|                                                                                     |" );
		displayExecutionTasks( order, filter );
		System.out.println( "|                                                                                     |" );
		System.out.println( "*=====================================================================================*" );

		try {
			Thread.sleep( 6000 );
		} catch ( InterruptedException ignored ) {
		}

		return true;
	}

	@Override
	public String headline ( ) {

		return "Tarefas Pendentes";
	}

	public void clearScreen ( ) {
		Ansi.ansi( ).eraseScreen( );
	}

	public void displayApprovalTasks ( int order, int filter ) {

		List< TicketApprovalTask > taskList = ticketTaskController.approvalTasksPending( );
		List< Pair< Ticket, TicketApprovalTask > > tickets = ticketTaskController.listTicketsByApprovalTask( taskList, order, filter );

		for ( TicketApprovalTask task : taskList ) {

			int length = task.identity().toString().length();
			String spaces = new String( new char[ 86 - 28 - length ] ).replace('\0', ' ' );
			System.out.println( "|    Aprovacao para tarefa: " + task.identity().toString() + spaces + "|");
		}
	}

	public void displayExecutionTasks ( int order, int filter ) {

		List< TicketExecutionTask > taskList = ticketTaskController.executionTasksPending( );
		List< Pair< Ticket, TicketExecutionTask > > tickets = ticketTaskController.listTicketsByExecutionTask( taskList, order, filter );

		for ( TicketExecutionTask task : taskList ) {

			int length = task.identity().toString().length();
			String spaces = new String( new char[ 86 - 27 - length ] ).replace('\0', ' ' );
			System.out.println( "|    Execucao para tarefa: " + task.identity().toString() + spaces + "|");
		}
	}

}
