package eapli.base.workflow.engine;


import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketID;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TcpServer implements Runnable {

	private static ServerSocket serverSocket;
	private Socket clientSocket;
	private DataOutputStream sOut;
	private DataInputStream sIn;

	public TcpServer(Socket cli_s) {
		clientSocket = cli_s;
	}

	public void stopConnection(InetAddress clientIP) {
		byte[] serverResponse= {(byte)0, (byte)2, (byte)0, (byte)0};
		try {
			sOut.write(serverResponse);
			sOut.flush();
			System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + clientSocket.getPort() + " disconnected");
			clientSocket.close();
		}catch (IOException ex){
			System.out.println("Falied to close client socket");
		}
		}

	public void TaskList() {
		try {
			//Sends response to the client
			byte[] serverResponse = {(byte) 0, (byte) 2, (byte) 0, (byte) 0};
			sOut.write(serverResponse);
			sOut.flush();

			//Recives email
			byte[] emailInfo = sIn.readNBytes(3);
			byte[] emailByteArray = sIn.readNBytes(emailInfo[2]);
			String email = new String(emailByteArray, StandardCharsets.UTF_8);

			//Get Collaborator by email
			CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
			InstituionalEmail iEmail = new InstituionalEmail(email);
			Optional<Collaborator> collabOp =collaboratorRepository.getColaboradorByEmail(iEmail);
			CollaboratorDTO collaboratorDTO;
			if (collabOp.isPresent())
				collaboratorDTO= collabOp.get().toDTO();

			//Get Ticket by collaborator ID
			List<TicketTask>lstTicketTask = new ArrayList<>();

			TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
			int finalCode=254;
			for (TicketTask ticketTask:lstTicketTask){
				Optional<Ticket> ticketOp = ticketRepository.ofIdentity(new TicketID(ticketTask.identity().toString()));
				Ticket ticket;
				if (ticketOp.isPresent())
					ticket=ticketOp.get();
				else{
					System.err.println("No tickets associated with this ticketTast");
					finalCode=253;
					break;
				}
				TicketDTO ticketDTO =ticket.toDTO();
				ServiceDTO serviceDTO = ticket.service().toDTO();
				sendString(ticketDTO.urgency); //urgency
				sendString(ticketDTO.deadLine); //deadline
				sendString(serviceDTO.title); //title
				sendString(serviceDTO.icon); //icon
				sendString(serviceDTO.briefDescription); //briefDesc
				sendString(ticket.service().catalogo().toDTO().nivelCriticidade.toString()); //criticityLvl
			}
			byte[] finalPackage ={(byte) 0, (byte) 254, (byte) 0, (byte) 0};
			sOut.write(finalPackage);

		} catch (IOException ex) {
			System.out.println("An error ocurred");
		}
	}

	public void sendString(String s) throws IOException {
		byte[] byteArray=s.getBytes(StandardCharsets.UTF_8);
		byte[] info ={(byte) 0, (byte) 255, (byte) byteArray.length};
		byte[] fullPackage = ArrayUtils.addAll(info,byteArray);
		sOut.write(fullPackage);
		sOut.flush();
	}


	public void run () {
		InetAddress clientIP=clientSocket.getInetAddress();
		System.out.println( "New client connection from " + clientIP.getHostAddress( ) + ", port number " + clientSocket.getPort( ) );

		try {
			sOut = new DataOutputStream( clientSocket.getOutputStream( ));
			sIn = new DataInputStream( clientSocket.getInputStream( ));
			boolean cycle = true;

			while (cycle){
				byte[] clientRequest = sIn.readNBytes(4);
				switch (clientRequest[1]){
					case 1:
						stopConnection(clientIP);
						cycle=false;
						break;
					case 3:
						TaskList();
						break;
				}

			}
		} catch ( IOException ex ) {
			System.out.println( "An error ocurred" );
		}
	}

	public static void main(String[] args) {
		Socket cliSock;
		AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());
		try {
			serverSocket = new ServerSocket(Integer.parseInt(Application.settings().getPortWorkflow()));
		} catch (IOException ex) {
			System.err.println("Failed to open server socket");
			System.exit(1);
		}
		while (true) {
			try {
				cliSock = serverSocket.accept();
				new Thread(new TcpServer(cliSock)).start();

			} catch (IOException e) {
				System.out.println("failed to accept client socket");
			}
		}
	}
}







