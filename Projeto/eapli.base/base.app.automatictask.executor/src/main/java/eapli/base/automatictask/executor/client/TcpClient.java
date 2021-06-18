package eapli.base.automatictask.executor.client;

import eapli.base.Application;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.attribute.Attribute;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketAutomaticTask;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.utils.SplitInfo;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.io.util.Console;
import org.apache.commons.lang3.ArrayUtils;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class TcpClient {

    private static final int TESTE = 0;
    private static final int FIM = 1;
    private static final int ENTENDIDO = 2;
    private static final int PEDIDO_EXECUCAO = 20;
    private static final int ENVIO_DADOS = 21;
    private static final int EXECUCAO_CONCLUIDA = 22;


    private static final int ERRO = 253;
    private static final int TERMINO_SEGMENTO = 254;
    private static final int SEGMENTO = 255;


    private static InetAddress serverIP;
    private static SSLSocket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public void startConnection(String ip) {

        // Trust these certificates provided by servers
        System.setProperty("javax.net.ssl.trustStore", "server.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", "server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            serverIP = InetAddress.getByName(Application.settings().getIpAutomatictaskExecutor());
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + Application.settings().getIpAutomatictaskExecutor());
            System.exit(1);
        }


        try {
            socket = (SSLSocket) sf.createSocket(serverIP, Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));
        } catch (IOException ex) {
            System.out.println("Failed to connect to: " + Application.settings().getIpAutomatictaskExecutor() + ":" + Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));
            System.out.println("Application aborted.");
            System.exit(1);
        }

        System.out.println("Connected to: " + Application.settings().getIpAutomatictaskExecutor() + ":" + Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));


        try {
            socket.startHandshake();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Failed to establish DataOutputStream or DataInputStream");
            System.exit(1);
        }

        System.out.println("Connection established with Automatic Task excecutor server\n");
    }

    public void stopConnection() {
        try {
            byte[] clientRequest = {(byte) 0, (byte) 1, (byte) 0, (byte) 0};
            sOut.write(clientRequest);
            sOut.flush();
            byte[] serverResponse = sIn.readNBytes(4);
            if ((int) serverResponse[1] == 2)
                System.out.println("Connection terminated with Automatic Task excecutor server");
            sIn.close();
            sOut.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Failed to close DataOutputStream, DataInputStream or client socket");
            System.exit(1);
        }
    }

    public boolean executeAutomaticTask(String data) throws IOException {
        //send initial request
        byte[] clientRequest = {(byte) 0, (byte) 20, (byte) 0, (byte) 0};
        sOut.write(clientRequest);
        sOut.flush();

        //recives server's response
        byte[] serverResponse = sIn.readNBytes(4);

        if ((int) serverResponse[1] == 2)
            System.out.println("Resposta Recebida");

        sendData(data);

        //recives server's response
        serverResponse = sIn.readNBytes(4);
        if ((serverResponse[1] & 0xff) == 253) {
            System.out.println("Não foi possivel executar o script de atividade automática com sucesso.");
            return false;
        }
        if ((serverResponse[1] & 0xff) == 22) {
            System.out.println("Script de atividade automática executado com sucesso.");
            return true;
        }
        return false;
    }

    public void sendData(String data) throws IOException {
        byte[] dataByteArray = data.getBytes(StandardCharsets.UTF_8);
        if (dataByteArray.length <= 255) {
            byte[] dataInfo = {(byte) 0, (byte) 21, (byte) dataByteArray.length};
            byte[] dataPackage = ArrayUtils.addAll(dataInfo, dataByteArray);
            sOut.write(dataPackage);
            sOut.flush();
        } else {
            byte[][] splitData = SplitInfo.splitObjectIntoByteArray(data);
            int code = 255;
            for (int i = 0; i < splitData.length; i++) {
                if (i == splitData.length - 1)
                    code = 254;
                byte[] dataInfo = {(byte) 0, (byte) code, (byte) splitData[i].length};
                byte[] dataPackage = ArrayUtils.addAll(dataInfo, splitData[i]);
                sOut.write(dataPackage);
                sOut.flush();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        TcpClient tcpExecuterClient = new TcpClient();

        tcpExecuterClient.startConnection(Application.settings().getIpAutomatictaskExecutor());

        boolean cycle = true;
        while (cycle) {
            int i = Console.readInteger("Insira num (0 para sair)");
            switch (i) {
                case 0:
                    tcpExecuterClient.stopConnection();
                    cycle = false;
                    break;
                case 20:

                    /*List<Ticket> currentState = new ArrayList<>();
                    TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
                    ticketRepository.findAll().forEach(currentState::add);

                    String email = currentState.get(0).requestedBy();
                    Form ticketform = currentState.get(0).ticketForm();

                    StringBuilder approval = new StringBuilder();
                    Optional<TicketApprovalTask> opApprovalTask = currentState.get(0).workflow().approvalTask();
                    if (opApprovalTask.isPresent()) {
                        TicketApprovalTask approvalTask = opApprovalTask.get();
                        boolean isfirst = true;
                        for (Attribute at : approvalTask.form().atributes()) {
                            if (isfirst) {
                                approval.append(at.label().toString());

                                isfirst = false;
                            } else {
                                approval.append(";;;").append(at.label().toString());
                            }
                        }
                    }

                    //String nomeScript = ((TicketAutomaticTask) currentState.get(0).workflow().starterTask()).scriptPath().toString();
                    System.out.println(email);

                    StringBuilder data = new StringBuilder();

                    StringBuilder answers = new StringBuilder();
                    boolean isfirst = true;

                    for (Attribute at : ticketform.atributes()) {
                        if (isfirst) {
                            answers.append(at.label().toString());

                            isfirst = false;
                        } else {
                            answers.append(";;;").append(at.label().toString());
                        }
                    }
                    */

                    StringBuilder data = new StringBuilder();
                    data.append("raf@isep.ipp.pt").append('|').append("teste_atividade_automatica2.txt").append('|').append("1;;;2;;;3;;;4")
                            .append('|').append("");

                    tcpExecuterClient.executeAutomaticTask(data.toString());
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}