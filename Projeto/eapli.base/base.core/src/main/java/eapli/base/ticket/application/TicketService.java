package eapli.base.ticket.application;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import eapli.base.Application;
import eapli.base.dasboard.application.TcpClient;
import eapli.base.form.domain.Form;
import eapli.base.utils.SFTPClient;

import java.io.File;

public class TicketService {

	public static boolean sendToWorkflowServer ( String ticketID ) {

		boolean sentSuccessfully = false;
		TcpClient tcpClient = new TcpClient();

		tcpClient.startConnection( Application.settings().getIpWorkflow() );
		sentSuccessfully = tcpClient.dispatchTicket( ticketID );
		tcpClient.stopConnection();

		return sentSuccessfully;
	}

	public File getFIleFromServer(Form form){
		String script = form.script().toString();
		SFTPClient sftp = new SFTPClient();
		try {
			return sftp.getScript(script);
		} catch (JSchException | SftpException e) {
			e.printStackTrace();
		}
		return null;
	}

}
