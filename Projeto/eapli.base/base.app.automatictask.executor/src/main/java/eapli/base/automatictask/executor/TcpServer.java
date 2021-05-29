package eapli.base.automatictask.executor;

import eapli.base.task.DTO.ExecutionTaskDTO;
import eapli.base.task.application.CheckPendingAssignedTasksController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

class TcpServer {

    static ServerSocket sock;

    public static void main(String[] args) throws Exception {
        Socket cliSock;

        try {
            sock = new ServerSocket(9999);
        } catch (IOException ex) {
            System.err.println("Failed to open server socket");
            System.exit(1);
        }

        while (true) {
            cliSock = sock.accept();
            new Thread(new TcpServerThread(cliSock)).start();
        }
    }

}


class TcpServerThread implements Runnable {

    private static ServerSocket serverSocket;
    private Socket clientSocket;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public TcpServerThread(Socket cli_s) {
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

            //Get Pending Task List
            CheckPendingAssignedTasksController pTasksController = new CheckPendingAssignedTasksController();
            List<ExecutionTaskDTO> pTaskList = (List<ExecutionTaskDTO>) pTasksController.getPendingTasksByCollaborator(email);
            for (ExecutionTaskDTO task : pTaskList){

            }

        } catch (IOException ex) {
            System.out.println("An error ocurred");
        }
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

}



