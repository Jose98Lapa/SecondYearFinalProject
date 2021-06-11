package eapli.base.ticket.application;

import eapli.base.Application;
import eapli.base.dasboard.application.TcpClient;
import eapli.base.ticket.domain.Ticket;

public class TicketService {

	public static boolean sendToWorkflowServer ( Ticket ticket ) {

		boolean sentSuccessfully = false;

		TcpClient tcpClient = new TcpClient();
		tcpClient.startConnection( Application.settings().getIpWorkflow() );



		tcpClient.stopConnection();
		return sentSuccessfully;
	}

}
