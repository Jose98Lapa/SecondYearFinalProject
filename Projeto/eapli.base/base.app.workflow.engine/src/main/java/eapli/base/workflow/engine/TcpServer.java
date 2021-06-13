package eapli.base.workflow.engine;


import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketID;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.repository.TicketTaskRepository;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
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
                finalString = compileString(finalString, "http://192.168.1.92/bootstrap.jpg");
                finalString = compileString(finalString, "Lavar as janelas do escriotio do 5º andar");
                finalString = compileString(finalString, "4");
                sendData(finalString);
                byte[] finalPackage = {(byte) 0, (byte) 252, (byte) 0, (byte) 0};
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
                List<TicketTask> lstTicketTask = ticketTaskRepository.getTicketsByCollaborator(collaborator);

                //Sends the Task data
                int finalCode = 252;
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
                    finalString = compileString(finalString, ticket.service().catalogo().toDTO().nivelCriticidade.valorCriticidade);
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
                byte[] fullPackage = ArrayUtils.addAll(info, splitByteArray);
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
            boolean cycle = true;
            while (cycle) {
                byte[] clientRequest = sIn.readNBytes(4);
                switch (clientRequest[1]) {
                    case 1:
                        stopConnection(clientIP);
                        cycle = false;
                        break;
                    case 3:
                        TaskList();
                        break;
                }
            }
        } catch (IOException ex) {
            System.out.println("An error ocurred");
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







