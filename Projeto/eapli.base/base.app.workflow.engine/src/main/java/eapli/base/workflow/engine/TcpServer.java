package eapli.base.workflow.engine;


import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.repository.TicketTaskRepository;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.apache.commons.lang3.ArrayUtils;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class TcpServer implements Runnable {

    private static SSLServerSocket sslServerSocket;
    private final Socket clientSocket;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public TcpServer(Socket cli_s) {
        clientSocket = cli_s;
    }

    public void stopConnection(InetAddress clientIP) {
        byte[] serverResponse = {(byte) 0, (byte) 2, (byte) 0, (byte) 0};
        try {
            sOut.write(serverResponse);
            sOut.flush();
            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + clientSocket.getPort() + " disconnected");
            clientSocket.close();
        } catch (IOException ex) {
            System.out.println("Falied to close client socket");
        }
    }

    public void TaskList() {
        try {
            //Sends response to the client
            byte[] serverResponse = {(byte) 0, (byte) 2, (byte) 0, (byte) 0};
            sOut.write(serverResponse);
            sOut.flush();

            //Receives email
            byte[] emailInfo = sIn.readNBytes(3);
            byte[] emailByteArray = sIn.readNBytes(emailInfo[2] & 0xff);
            String email = new String(emailByteArray, StandardCharsets.UTF_8);

            boolean mock = false;
            if (mock) {
                String finalString = "5";
                finalString = compileString(finalString, "30/06/2021 23:34");
                finalString = compileString(finalString, "Lavar janelas");
                finalString = compileString(finalString, "https://192.168.1.92/bootstrap.jpg");
                finalString = compileString(finalString, "Lavar as janelas do escriotio do 5º andar");
                finalString = compileString(finalString, "4");
                sendData(finalString);
                String finalString2 = "5";
                finalString2 = compileString(finalString2, "31/06/2021 23:34");
                finalString2 = compileString(finalString2, "Lavar portas");
                finalString2 = compileString(finalString2, "https://192.168.1.92/bootstrap.jpg");
                finalString2 = compileString(finalString2, "Lavar as portas do escriotio do 5º andar");
                finalString2 = compileString(finalString2, "3");
                sendData(finalString2);
                byte[] finalPackage = {(byte) 0, (byte) 4, (byte) 0, (byte) 0};
                sOut.write(finalPackage);
                sOut.flush();
            } else {

                //Get Collaborator by email
                CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
                InstituionalEmail iEmail = new InstituionalEmail(email);
                Optional<Collaborator> collabOp = collaboratorRepository.getColaboradorByEmail(iEmail);
                Collaborator collaborator = null;
                if (collabOp.isPresent())
                    collaborator = collabOp.get();
                else {
                    System.out.println("Invalid email");
                    System.exit(1);
                }

                //Gets Tasks belonging to the collaborator
                TicketTaskRepository ticketTaskRepository = PersistenceContext.repositories().ticketTasks();
                TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
                List<TicketTask> lstTicketTask = ticketTaskRepository.getIncompleteTicketsByCollaborator(collaborator);

                //Sends the Task data
                int finalCode = 4;
                for (TicketTask ticketTask : lstTicketTask) {
                    Optional<Ticket> ticketOp = ticketRepository.ofIdentity(ticketTask.identity().toString());
                    Ticket ticket;
                    if (ticketOp.isPresent())
                        ticket = ticketOp.get();
                    else {
                        System.err.println("No tickets associated with this ticketTast");
                        finalCode = 253;
                        break;
                    }

                    TicketDTO ticketDTO = ticket.toDTO();
                    ServiceDTO serviceDTO = ticket.service().toDTO();
                    String finalString = ticketDTO.urgency;
                    finalString = compileString(finalString, ticketDTO.deadLine);
                    finalString = compileString(finalString, serviceDTO.title);
                    finalString = compileString(finalString, serviceDTO.icon);
                    finalString = compileString(finalString, serviceDTO.briefDescription);
                    finalString = compileString(finalString, ticket.service().catalogue().toDTO().nivelCriticidade.valorCriticidade);
                    sendData(finalString);
                }

                byte[] finalPackage = {(byte) 0, (byte) finalCode, (byte) 0, (byte) 0};
                sOut.write(finalPackage);
                sOut.flush();
            }

        } catch (IOException ex) {
            System.out.println("An error ocurred");
            stopConnection(clientSocket.getInetAddress());
        }
    }

    public static String compileString(String finalString, String toAddString) {
        return finalString = finalString + "|" + toAddString;
    }

    public void sendData(String finalString) throws IOException {
        byte[] fullByteArray = finalString.getBytes(StandardCharsets.UTF_8);
        byte[] info = {(byte) 0, (byte) 255, (byte) 255};

        int dataSize = 255; // Data size to divide
        for (int i = 0; i < fullByteArray.length; i += dataSize) {
            byte[] splitByteArray = Arrays.copyOfRange(fullByteArray, i, Math.min(fullByteArray.length, i + dataSize));
            if (splitByteArray.length == dataSize) {
                byte[] fullPackage = ArrayUtils.addAll(info, splitByteArray);
                sOut.write(fullPackage);
                sOut.flush();
            } else {
                byte[] finalInfo = {(byte) 0, (byte) 254, (byte) splitByteArray.length};
                byte[] fullPackage = ArrayUtils.addAll(finalInfo, splitByteArray);
                sOut.write(fullPackage);
                sOut.flush();
            }
        }
    }

    public void run() {
        InetAddress clientIP = clientSocket.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + clientSocket.getPort());

        try {
            sOut = new DataOutputStream(clientSocket.getOutputStream());
            sIn = new DataInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            System.out.println("Failed to establish DataOutputStream or DataInputStream");
            System.exit(1);
        }

        try {
            EngineV2 engine = new EngineV2( );
            boolean cycle = true;
            while (cycle) {
                byte[] clientRequest = sIn.readNBytes( 3 );
                byte data[] = sIn.readNBytes( clientRequest[2] );
                switch (clientRequest[1]) {
                    case 1:
                        stopConnection(clientIP);
                        cycle = false;
                        break;
                    case 3:
                        TaskList();
                        break;
                    case 10:
                        engine.processIncomingTicket( data );
                        break;
                    case 11:
                        //String[] parameters = new String( data ).split( ";" );
                        //engine.processStatusChange( parameters[0], parameters[1] );
                        break;
                }
            }
        } catch (IOException ex) {
            System.out.println("An error ocurred");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Socket cliSock;

        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", "server.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", "server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(Application.settings().getPortWorkflow()));
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + Integer.parseInt(Application.settings().getPortWorkflow()));
            System.exit(1);
        }
        while (true) {
            try {
                cliSock = sslServerSocket.accept();
                new Thread(new TcpServer(cliSock)).start();

            } catch (IOException e) {
                System.out.println("failed to accept client socket");
            }
        }

        /*while (true){
            EngineV2 engineV2 = new EngineV2();
            for (Ticket ticket : PersistenceContext.repositories().tickets().getPendingTicket()){
                engineV2.processStatusChange(ticket.identity(),ticket.status().toString());
                System.out.println("Mexelhoes");
            }

            TimeUnit.MINUTES.sleep(1);
        }*/
    }
}







