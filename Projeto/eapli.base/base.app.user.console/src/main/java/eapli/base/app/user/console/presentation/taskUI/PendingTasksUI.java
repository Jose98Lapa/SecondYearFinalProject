package eapli.base.app.user.console.presentation.taskUI;

import eapli.base.ticket.application.TicketService;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticketTask.application.TicketTaskController;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
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

		for ( Pair< Ticket, TicketApprovalTask > pair : tickets ) {

			String info = pair.getSecond().identity() +
					") deadline " + pair.getSecond().deadline() +
					", pedido a " + pair.getFirst().solictedOn() +
					"[ " + pair.getFirst().urgency() + " ].";
			String spaces = new String( new char[ 86 - info.length() - 4 ] ).replace('\0', ' ' );
			System.out.println( "|\t" + info + spaces + "|");
		}
	}

	public void displayExecutionTasks ( int order, int filter ) {

		List< TicketExecutionTask > taskList = ticketTaskController.executionTasksPending( );
		List< Pair< Ticket, TicketExecutionTask > > tickets = ticketTaskController.listTicketsByExecutionTask( taskList, order, filter );

		for ( Pair< Ticket, TicketExecutionTask > pair : tickets ) {

			String info = pair.getSecond().identity() +
					") deadline " + pair.getSecond().deadline() +
					", pedido a " + pair.getFirst().solictedOn() +
					"[ " + pair.getFirst().urgency() + " ].";
			String spaces = new String( new char[ 86 - info.length() - 4 ] ).replace('\0', ' ' );
			System.out.println( "|\t" + spaces + "|");
		}
	}

}
