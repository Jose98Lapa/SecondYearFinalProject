package eapli.base.ticket.application;

import eapli.base.dasboard.application.TcpClient;
import eapli.base.ticket.domain.Ticket;

public class TicketService {

	public static boolean sendToWorkflowServer ( Ticket ticket ) {

		TcpClient client = new TcpClient();
		return false;
	}

}
