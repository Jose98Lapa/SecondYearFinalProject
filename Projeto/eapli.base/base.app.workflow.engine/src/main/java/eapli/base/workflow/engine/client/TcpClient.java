package eapli.base.workflow.engine.client;

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
			byte[] msg = {(byte) 0, (byte) 1, (byte) 0, (byte) 0};
			sOut.write(msg);
			System.out.println("");
			sIn.close();
			sOut.close();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Failed to close DataOutputStream, DataInputStream or client socket");
			System.exit(1);
		}
	}

	public void serviceList(String email) throws IOException {
		byte[][] splitObject=SplitInfo.splitObjectIntoByteArray(email);
		for (byte[] bytes : splitObject) {
			byte[] msg = {(byte) 0, (byte) 3, (byte) splitObject.length};
			byte[] finalMsg = ArrayUtils.addAll(bytes, msg);
			sOut.write(msg);
		}
	}


	public static void main(String[] args) throws IOException {
		TcpClient tcpClient = new TcpClient();
		tcpClient.startConnection("172.17.0.2");

		boolean cycle = true;
		while (cycle) {
			int i = Console.readInteger("Insira num (0 para sair)");
			switch (i) {
				case 0:
					tcpClient.stopConnection();
					cycle = false;
					break;
				case 1:
					tcpClient.serviceList("tomy");
					break;
				default:
					System.out.println("Invalid Option");
			}
		}
	}
}
