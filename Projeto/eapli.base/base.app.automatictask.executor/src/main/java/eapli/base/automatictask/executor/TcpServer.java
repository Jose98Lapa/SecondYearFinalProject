package eapli.base.automatictask.executor;


import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.SFTPClient;
import eapli.base.utils.SplitInfo;
import org.apache.commons.lang3.ArrayUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

class TcpServer {

    static ServerSocket sock;

    public static void main(String[] args) throws Exception {
        Socket cliSock;

        try {
            sock = new ServerSocket(Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));
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

    private Socket clientSocket;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public TcpServerThread(Socket cli_s) {
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

    public void wasExecutionSuccessfull(boolean wasIt) {
        int code = 22;
        if (!wasIt)
            code = 253;
        byte[] serverResponse = {(byte) 0, (byte) code, (byte) 0, (byte) 0};
        try {
            sOut.write(serverResponse);
            sOut.flush();
        } catch (IOException ex) {
            System.out.println("Falied to communicate with client");
        }
    }

    public boolean executeAutomaticTask() {
        try {
            //Sends response to the client
            byte[] serverResponse = {(byte) 0, (byte) 2, (byte) 0, (byte) 0};
            sOut.write(serverResponse);
            sOut.flush();

            //Recives script
            byte[] scriptByteArray = null;
            byte[] scriptInfo = sIn.readNBytes(3);
            int code = (scriptInfo[1] & 0xff);
            if (code == 21)
                scriptByteArray = sIn.readNBytes(scriptInfo[2] & 0xff);
            else if (code == 255) {
                byte[][] splitScript = new byte[10][250];
                int index = 0;
                while (code != 254) {
                    code = scriptInfo[1] & 0xff;
                    splitScript[index] = sIn.readNBytes(scriptInfo[2] & 0xff);
                    if (code != 254)
                        scriptInfo = sIn.readNBytes(3);
                    index++;
                }
                scriptByteArray = SplitInfo.serializeObject(SplitInfo.joinSplitInfo(splitScript));
            }
            if (scriptByteArray == null)
                return false;
            String scriptName = new String(scriptByteArray, StandardCharsets.UTF_8);
            if (code != 21)
                scriptName = scriptName.substring(7);
            SFTPClient scriptClient = new SFTPClient();
            String script = scriptClient.getScriptToString(scriptName);
            String[] data = script.split("\n");

            Calendar calendar = Calendar.getInstance();
            System.out.printf("[%s] - Executing %s ...%n", calendar.getTime(), scriptName);

            for (String line : data) {
                System.out.println(line);
                Thread.sleep(1000);
            }
            calendar = Calendar.getInstance();
            System.out.printf("[%s] - %s executed.%n", calendar.getTime(), scriptName);

        } catch (IOException | InterruptedException | JSchException | SftpException ex) {
            System.out.println("An error ocurred");
            return false;
        }
        return true;
    }


    public void run() {
        InetAddress clientIP = clientSocket.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + clientSocket.getPort());

        try {
            sOut = new DataOutputStream(clientSocket.getOutputStream());
            sIn = new DataInputStream(clientSocket.getInputStream());
            boolean cycle = true;

            while (cycle) {
                byte[] clientRequest = sIn.readNBytes(4);
                switch (clientRequest[1]) {
                    case 1:
                        stopConnection(clientIP);
                        cycle = false;
                        break;
                    case 20:
                        wasExecutionSuccessfull(executeAutomaticTask());
                        break;
                }

            }
        } catch (IOException ex) {
            System.out.println("An error ocurred");
        }
    }

}



