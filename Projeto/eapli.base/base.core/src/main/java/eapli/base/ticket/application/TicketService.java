package eapli.base.ticket.application;

import eapli.base.Application;
import eapli.base.dasboard.application.TcpClient;

public class TicketService {

	public static boolean sendToWorkflowServer ( String ticketID ) {

		boolean sentSuccessfully = false;

		TcpClient tcpClient = new TcpClient();
		tcpClient.startConnection( Application.settings().getIpWorkflow() );



		tcpClient.stopConnection();
		return sentSuccessfully;
	}

}
