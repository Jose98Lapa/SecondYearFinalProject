package eapli.base.automatictask.executor;


import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.SFTPClient;
import eapli.base.utils.SplitInfo;
import org.antlr.v4.runtime.misc.Pair;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

class TcpServer {

    static SSLServerSocket sock;

    public static void main(String[] args) throws Exception {
        Socket cliSock;

        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", "server.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", "server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sock = (SSLServerSocket) sslF.createServerSocket(Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));
            System.exit(1);
        }


        while (true) {
            cliSock = sock.accept();
            new Thread(new TcpServerThread(cliSock)).start();
        }
    }

}

class TcpServerThread implements Runnable {

    //SDP2021
    private static final int TESTE = 0;
    private static final int FIM = 1;
    private static final int ENTENDIDO = 2;
    private static final int PEDIDO_EXECUCAO = 20;
    private static final int ENVIO_DADOS = 21;
    private static final int EXECUCAO_CONCLUIDA = 22;
    private static final int ERRO = 253;
    private static final int TERMINO_SEGMENTO = 254;
    private static final int SEGMENTO = 255;

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
        int code = EXECUCAO_CONCLUIDA;
        if (!wasIt)
            code = ERRO;
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
            byte[] serverResponse = {(byte) 0, (byte) ENTENDIDO, (byte) 0, (byte) 0};
            sOut.write(serverResponse);
            sOut.flush();

            //Recives script
            byte[] dataByteArray = null;
            byte[] dataInfo = sIn.readNBytes(3);
            int code = (dataInfo[1] & 0xff);
            if (code == ENVIO_DADOS)
                dataByteArray = sIn.readNBytes(dataInfo[2] & 0xff);
            else if (code == SEGMENTO) {
                byte[][] splitData = new byte[10][250];
                int index = 0;
                while (code != TERMINO_SEGMENTO) {
                    code = dataInfo[1] & 0xff;
                    splitData[index] = sIn.readNBytes(dataInfo[2] & 0xff);
                    if (code != TERMINO_SEGMENTO)
                        dataInfo = sIn.readNBytes(3);
                    index++;
                }
                dataByteArray = SplitInfo.serializeObject(SplitInfo.joinSplitInfo(splitData));
            }

            if (dataByteArray == null)
                return false;

            String dataString = new String(dataByteArray, StandardCharsets.UTF_8);

            if (code != ENVIO_DADOS)
                dataString = dataString.substring(7);

            String[] data = dataString.split("\\|");
            String email = data[0];
            String scriptName = data[1];
            List<String> answerData = new ArrayList<>();
            List<String> approvalData = new ArrayList<>();

            if(data.length>2) {
                String answerString = data[2];
                answerData = Arrays.asList(answerString.split(";;;"));
            }

            if(data.length>3) {
                String approvalString = data[3];
                approvalData = Arrays.asList(approvalString.split(";;;"));
            }

            SFTPClient scriptClient = new SFTPClient();
            File script = scriptClient.getScript(scriptName);
            Calendar calendar = Calendar.getInstance();
            System.out.printf("[%s] - Executing %s ...%n", calendar.getTime(), script.getName());
            Pair<Boolean, String> wasItSuccessfull = null;
            Pair<Boolean, String> wasItSuccessfull2 = null;

            if (Application.settings().getGRAMMARAUTOMATICTYPE().equals("VISITOR")){
               wasItSuccessfull = ExecutorAtividadeAutomatica.parseWithVisitor(email, script.getName(), answerData, approvalData);
            }else{
                wasItSuccessfull2 = ExecutorAtividadeAutomatica.parseWithListener(email, script.getName(), answerData, approvalData);
            }

            calendar = Calendar.getInstance();
            if (wasItSuccessfull.a)
                System.out.printf("[%s] - %s executed successfully.%n", calendar.getTime(), scriptName);
            else
                System.out.printf("[%s] - Something went wrong when executing %s: %s%n", calendar.getTime(), scriptName, wasItSuccessfull.b);
            if (wasItSuccessfull2.a)
                System.out.printf("[%s] - %s executed successfully.%n", calendar.getTime(), scriptName);
            else
                System.out.printf("[%s] - Something went wrong when executing %s: %s%n", calendar.getTime(), scriptName, wasItSuccessfull2.b);

            return wasItSuccessfull.a ;
        } catch (IOException | JSchException | SftpException ex) {
            System.out.println("An error ocurred");
            ex.printStackTrace();
            return false;
        }
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
                    case PEDIDO_EXECUCAO:
                        wasExecutionSuccessfull(executeAutomaticTask());
                        break;
                }

            }
        } catch (IOException ex) {
            System.out.println("An error ocurred");
        }
    }

}



