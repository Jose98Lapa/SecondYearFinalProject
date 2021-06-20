package eapli.base.dasboard.application;

import eapli.base.Application;
import org.apache.commons.lang3.ArrayUtils;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TcpClient {

    private static InetAddress serverIP;
    private static SSLSocket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;


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
            //System.exit(1);
        }

        try {
            socket = (SSLSocket) sslSocketFactory.createSocket(serverIP, Integer.parseInt(Application.settings().getPortWorkflow()));
        } catch (IOException ex) {
            //System.out.println("Failed to establish TCP connection");
            //System.exit(1);
            return false;
        }


        //System.out.println("Connected to: " + ip + ":" + Integer.parseInt(Application.settings().getPortWorkflow()));

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
            //System.out.println("Failed to establish DataOutputStream or DataInputStream");
            //System.exit(1);
            return false;
        }
       // System.out.println("Connection established with Worflow server\n");
        return true;
    }

    public boolean stopConnection() {

        boolean stopped = false;

        try {
            byte[] clientRequest = {(byte) 0, (byte) 1, (byte) 0, (byte) 0};
            sOut.write(clientRequest);
            sOut.flush();
            byte[] serverResponse = sIn.readNBytes(4);
            if ((int) serverResponse[1] == 2)
                System.out.println("Connection terminated with Worflow server");
            sIn.close();
            sOut.close();
            socket.close();
            stopped = true;

        } catch (IOException e) {
            System.out.println("Failed to close DataOutputStream, DataInputStream or client socket");
        }

        return stopped;
    }

    public List<String> TaskInfoList(String email) throws IOException {
        //send initial request
        byte[] clientRequest = {(byte) 0, (byte) 3, (byte) 0, (byte) 0};
        sOut.write(clientRequest);
        sOut.flush();

        //recives server's response
        byte[] serverResponse = sIn.readNBytes(4);
        if ((int) serverResponse[1] != 2) {
            System.out.println("Resposta invalida");
            System.exit(1);
        }

        //send email
        byte[] emailByteArray = email.getBytes(StandardCharsets.UTF_8);
        byte[] emailInfo = {(byte) 0, (byte) 255, (byte) emailByteArray.length};
        byte[] emailPackage = ArrayUtils.addAll(emailInfo, emailByteArray);
        sOut.write(emailPackage);
        sOut.flush();

        //receber os atributos
        List<String> taskInfoList = new ArrayList<>();
        StringBuilder taskInfoBuilder = new StringBuilder();


        while (true) {
            byte[] info = sIn.readNBytes(3);

            //No more tasks associated with the collaborator
            if ((info[1] & 0xff) == 4)
                break;
            if ((info[1] & 0xff) == 253) {
                //System.out.println("A error occurred");
                break;
            }

            byte[] byteArray = sIn.readNBytes(info[2] & 0xff);
            String atribute = new String(byteArray, StandardCharsets.UTF_8);
            taskInfoBuilder.append(atribute);
            if ((info[1] & 0xff) == 254) {
                String taskInfo = taskInfoBuilder.toString();
                taskInfoList.add(taskInfo);
                taskInfoBuilder.setLength(0);
                taskInfo = "";
            }
        }

        return taskInfoList;

    }

    public boolean dispatchTicket(String ticketID) {

        byte version = 1, code = 10, payloadSize;
        byte[] payload = ticketID.getBytes(StandardCharsets.UTF_8);
        payloadSize = (byte) payload.length;
        byte[] headers = {version, code, payloadSize};
        byte[] packet = buildPacket(headers, payload);

        try {

            sOut.write(packet);
            sOut.flush();
            return true;

        } catch (IOException exception) {
            return false;
        }
    }

    public boolean statusChange ( String ticketID ) {

        byte version = 1, code = 11, payloadSize;
        byte[] payload = ticketID.getBytes(StandardCharsets.UTF_8);
        payloadSize = (byte) payload.length;
        byte[] headers = {version, code, payloadSize};
        byte[] packet = buildPacket(headers, payload);

        try {

            sOut.write(packet);
            sOut.flush();
            return true;

        } catch (IOException exception) {
            return false;
        }
    }

    private byte[] buildPacket(byte[] headers, byte[] payload) {

        return ArrayUtils.addAll(headers, payload);
    }
}

