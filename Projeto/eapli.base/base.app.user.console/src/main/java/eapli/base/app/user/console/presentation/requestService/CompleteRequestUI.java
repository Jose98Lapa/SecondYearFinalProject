package eapli.base.app.user.console.presentation.requestService;

import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.application.CreateTicketController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class CompleteRequestUI extends AbstractUI {

	private CreateTicketController createTicketController;

	@Override
	protected boolean doShow ( ) {

		createTicketController = new CreateTicketController( );

		System.out.println( "*=====================================================================================*" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "|    Tickets em draft                                                                 |" );
		System.out.println( "|                                                                                     |" );
		List< TicketDTO > tickets = displayDrafts();
		System.out.println( "|                                                                                     |" );
		System.out.println( "*=====================================================================================*" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "|    Qual vai escolher? ( 0 para sair                                                 |" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "*=====================================================================================*" );
		int ticketOption = Console.readOption( 1, tickets.size(), 0 );

		if ( ticketOption == 0 ) {
			return false;
		}

		TicketDTO chosenTicket = tickets.get( ticketOption );

		System.out.println( "*=====================================================================================*" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "|    O que deseja alterar?                                                            |" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "|    0 -> Nada                                                                        |" );
		System.out.println( "|    1 -> Deadline                                                                    |" );
		System.out.println( "|    2 -> Urgencia                                                                    |" );
		System.out.println( "|                                                                                     |" );
		System.out.println( "*=====================================================================================*" );

		int option = Console.readOption( 0, 2, -1 );
		editData( chosenTicket, option );

		return true;
	}

	public List< TicketDTO > displayDrafts ( ) {

		List< TicketDTO > tickets = createTicketController.incompleteTickets();
		int number = 1;

		for ( TicketDTO ticket : tickets ) {

			String info = ticket.id +
					" [ " + ticket.urgency +
					" ] " + ticket.serviceDTO.catalogo +
					" :" + ticket.serviceDTO.title + " ].";
			String spaces = new String( new char[ 86 - info.length() - 4 - Integer.toString( number ).length() ] )
					.replace('\0', ' ' );
			System.out.println( "|\t" + number + info + spaces + "|");
			number++;
		}

		return tickets;
	}

	public void editData ( TicketDTO ticket, int option ){

		switch ( option ) {
			case 0:
				createTicketController.createTicket( ticket, true );
				break;
				case 1:
				String deadline = Console.readLine(  "Introduza uma nova deadline: ");
				ticket.deadLine = deadline;
				System.out.println( "*=====================================================================================*" );
				createTicketController.finishTicket( ticket, true );
				break;

				case 2:
					String urgency = Console.readLine(  "Introduza uma nova urgencia ( reduzida, moderada, urgente): ");
					ticket.urgency = urgency;
					System.out.println( "*=====================================================================================*" );
					createTicketController.finishTicket( ticket, true );
				break;
		}
	}

	@Override
	public String headline ( ) {

		return null;
	}

}
