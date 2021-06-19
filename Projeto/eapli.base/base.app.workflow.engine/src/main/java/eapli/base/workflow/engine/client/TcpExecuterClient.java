package eapli.base.workflow.engine.client;

import eapli.base.Application;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.attribute.Attribute;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketAutomaticTask;
import eapli.base.utils.SplitInfo;
import org.apache.commons.lang3.ArrayUtils;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class TcpExecuterClient {

    private static InetAddress serverIP;
    private static SSLSocket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public void connection(String ip) {

    }

    public boolean startConnection(String ip) {

        // Trust these certificates provided by servers
        System.setProperty("javax.net.ssl.trustStore", "server.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", "server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {

            serverIP = InetAddress.getByName(ip);

        } catch (UnknownHostException ex) {

            System.out.println("Invalid server specified: " + ip);
            return false;
        }

        try {

            socket = (SSLSocket) sslSocketFactory.createSocket(serverIP, Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));

        } catch (IOException ex) {

            System.out.println("Failed to establish TCP connection");
            return false;
        }


        System.out.println("Connected to: " + ip + ":" + Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));

        try {

            socket.startHandshake();
        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }


        try {

            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
        } catch (IOException | NullPointerException e) {

            System.out.println("Failed to establish DataOutputStream or DataInputStream");
            return false;
        }

        System.out.println("Connection established with Worflow server\n");
        return true;
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

    public void executeAutomaticTask(Ticket ticket) throws IOException {
        //send initial request
        byte[] clientRequest = {(byte) 0, (byte) 20, (byte) 0, (byte) 0};
        sOut.write(clientRequest);
        sOut.flush();

        //recives server's response
        byte[] serverResponse = sIn.readNBytes(4);
        if ((int) serverResponse[1] == 2)
            System.out.println("Resposta Recebida");

        String data = organizeData(ticket);
        sendData(data);

        //recives server's response
        serverResponse = sIn.readNBytes(4);
        if ((serverResponse[1] & 0xff) == 22)
            System.out.println("Script de atividade automática executado com sucesso.");
        if ((serverResponse[1] & 0xff) == 253)
            System.out.println("Não foi possivel executar o script de atividade automática com sucesso.");
    }

    private String organizeData(Ticket ticket) {
        boolean isfirst = true;

        Form ticketForm = ticket.ticketForm();
        StringBuilder answers = new StringBuilder();
        ArrayList<Attribute> attributeFormList = new ArrayList<>( ticketForm.atributes() );
        attributeFormList.sort( Comparator.comparing(Attribute::number) );
        for (Attribute at : attributeFormList) {
            if (isfirst) {
                answers.append(at.label().toString());
                isfirst = false;
            } else {
                answers.append(";;;").append(at.label().toString());
            }
        }

        StringBuilder approval = new StringBuilder();
        Optional<TicketApprovalTask> opApprovalTask = ticket.workflow().approvalTask();
        if (opApprovalTask.isPresent()) {
            TicketApprovalTask approvalTask = opApprovalTask.get();
            isfirst = true;
            ArrayList< Attribute > attributeApprovalList = new ArrayList<>( approvalTask.form().atributes() );
            attributeApprovalList.sort( Comparator.comparing(Attribute::number) );
            for (Attribute at : attributeApprovalList) {
                if (isfirst) {
                    approval.append(at.label().toString());
                    isfirst = false;
                } else {
                    approval.append(";;;").append(at.label().toString());
                }
            }
        }

        String script = ((TicketAutomaticTask) ticket.workflow().getFirstIncompleteTask()).scriptPath().toString();

        StringBuilder data = new StringBuilder();
        data.append(ticket.requestedBy()).append('|').append(script).append('|').append(answers).append(approval);
        return data.toString();
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

    }

}