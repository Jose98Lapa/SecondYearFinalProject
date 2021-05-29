package eapli.base.workflow.engine.client;

import eapli.base.Application;
import eapli.base.utils.SplitInfo;
import eapli.framework.io.util.Console;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TcpClient {

	private static InetAddress serverIP;
	private static Socket clientSocket;
	private DataOutputStream sOut;
	private DataInputStream sIn;


	public void startConnection(String ip) {
		try {
			serverIP = InetAddress.getByName(ip);
		} catch (UnknownHostException ex) {
			System.out.println("Invalid server specified: " + ip);
			System.exit(1);
		}

		try {
			clientSocket = new Socket(serverIP, 10020);
		} catch (IOException ex) {
			System.out.println("Failed to establish TCP connection");
			System.exit(1);
		}


		try {
			sOut = new DataOutputStream(clientSocket.getOutputStream());
			sIn = new DataInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			System.out.println("Failed to establish DataOutputStream or DataInputStream");
			System.exit(1);
		}

		System.out.println("Connection established with Worflow server\n");
	}

	public void stopConnection() {
		try {
			byte[] clientRequest = {(byte) 0, (byte) 1, (byte) 0, (byte) 0};
			sOut.write(clientRequest);
			byte[] serverResponse=sIn.readNBytes(4);
			if((int)serverResponse[1]==2)
				System.out.println("Connection terminated with Worflow server");
			sIn.close();
			sOut.close();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Failed to close DataOutputStream, DataInputStream or client socket");
			System.exit(1);
		}
	}

	public void TaskList(String email) throws IOException {
		//send initial request
		byte[] clientRequest = {(byte) 0, (byte) 3, (byte) 0, (byte) 0};
		sOut.write(clientRequest);

		//recives server's response
		byte[] serverResponse = sIn.readNBytes(4);
		if ((int)serverResponse[1]==2)
			System.out.println("Resposta Recebida");


		//send email
		byte[] emailByteArray=email.getBytes(StandardCharsets.UTF_8);
		byte[] emailInfo ={(byte) 0, (byte) 255, (byte) emailByteArray.length};
		byte[] emailPackage = ArrayUtils.addAll(emailInfo, emailByteArray);
		sOut.write(emailPackage);
	}


	public static void main(String[] args) throws IOException {
		TcpClient tcpClient = new TcpClient();
		tcpClient.startConnection(Application.settings().getIpWorkflow());

		boolean cycle = true;
		while (cycle) {
			int i = Console.readInteger("Insira num (0 para sair)");
			switch (i) {
				case 0:
					tcpClient.stopConnection();
					cycle = false;
					break;
				case 1:
					tcpClient.TaskList("tomy@gmail.com");
					break;
				default:
					System.out.println("Invalid Option");
			}
		}
	}
}
