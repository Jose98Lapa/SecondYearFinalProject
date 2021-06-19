package eapli.base.app.user.console.presentation.taskUI;

import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.application.TicketTaskController;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.fusesource.jansi.Ansi;

import javax.xml.stream.events.Characters;
import java.util.List;

public class PendingTasksUI extends AbstractUI {

	private TicketTaskController ticketTaskController;

	@Override
	protected boolean doShow ( ) {

		ticketTaskController = new TicketTaskController( );

		System.out.println( "+=====================================================================================+" );
		System.out.println( "|                                  Tarefas Pendentes                                  |" );
		System.out.println( "*=====================================================================================*" );
		System.out.println( "|                                          |                                          |" );
		System.out.println( "|    Como quer ordenar?                    |    Como quer filtrar?                    |" );
		System.out.println( "|                                          |                                          |" );
		System.out.println( "|    1: O carlos quer comer pao            |    1: O carlos come pao                  |" );
		System.out.println( "|    1: O carlos quer comer pao            |    2: o carlos come pao                  |" );
		System.out.println( "|    1: O carlos quer comer pao            |    3: O carlos come pao                  |" );
		System.out.println( "|                                          |                                          |" );
		System.out.println( "*=====================================================================================*" );

		int order = Console.readOption( 1, 3, 0 );
		int filter = Console.readOption( 1, 3, 0 );
		clearScreen();

		System.out.println( "*=====================================================================================*" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "|    Tarefas de Aprovacao                                                             |" );
		System.out.println( "|                                                                                     |" );
		displayApprovalTasks();
		System.out.println( "|                                                                                     |" );
		System.out.println( "*=====================================================================================*" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "|    Tarefas de Execucao                                                              |" );
		System.out.println( "|                                                                                     |" );
		displayExecutionTasks();
		System.out.println( "|                                                                                     |" );
		System.out.println( "*=====================================================================================*" );

		return false;
	}

	@Override
	public String headline ( ) {

		return "Tarefas Pendentes";
	}

	public void clearScreen ( ) {
		Ansi.ansi( ).eraseScreen( );
	}

	public void displayApprovalTasks (  ) {

		List< TicketApprovalTaskDTO > taskDTOList = ticketTaskController.approvalTasksPending( );

		for ( TicketApprovalTaskDTO task : taskDTOList ) {

			int length = task.ticketTaskID.length();
			String spaces = new String( new char[ length ] ).replace('\0', ' ' );
			System.out.println( "|    Aprovacao para tarefa: " + task.ticketTaskID + spaces + "|");
		}
	}

	public void displayExecutionTasks (  ) {

		List< TicketExecutionTaskDTO > taskDTOList = ticketTaskController.executionTasksPending( );

		for ( TicketExecutionTaskDTO task : taskDTOList ) {

			int length = task.ticketTaskID.length();
			String spaces = new String( new char[ length ] ).replace('\0', ' ' );
			System.out.println( "|    Execucao para tarefa: " + task.ticketTaskID + spaces + "|");
		}
	}

}
