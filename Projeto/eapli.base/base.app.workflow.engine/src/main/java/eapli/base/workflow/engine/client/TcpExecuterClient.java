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

class TcpExecuterClient {

	private static InetAddress serverIP;
	private static Socket socket;
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
			socket = new Socket(serverIP, Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));
		} catch (IOException ex) {
			System.out.println("Failed to establish TCP connection");
			System.exit(1);
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

	public void executeAutomaticTask(String script) throws IOException {
		//send initial request
		byte[] clientRequest = {(byte) 0, (byte) 20, (byte) 0, (byte) 0};
		sOut.write(clientRequest);
		sOut.flush();

		//recives server's response
		byte[] serverResponse = sIn.readNBytes(4);
		if ((int) serverResponse[1] == 2)
			System.out.println("Resposta Recebida");

		//send script
		byte[] scriptByteArray = script.getBytes(StandardCharsets.UTF_8);
		if (scriptByteArray.length <= 255) {
			byte[] scriptInfo = {(byte) 0, (byte) 21, (byte) scriptByteArray.length};
			byte[] scriptPackage = ArrayUtils.addAll(scriptInfo, scriptByteArray);
			sOut.write(scriptPackage);
			sOut.flush();
		} else {
			byte[][] splitScript = SplitInfo.splitObjectIntoByteArray(script);
			int code = 255;
			for (int i = 0; i < splitScript.length; i++) {
				if (i == splitScript.length - 1)
					code = 254;
				byte[] scriptInfo = {(byte) 0, (byte) code, (byte) splitScript[i].length};
				byte[] scriptPackage = ArrayUtils.addAll(scriptInfo, splitScript[i]);
				sOut.write(scriptPackage);
				sOut.flush();
			}
		}

		//recives server's response
		serverResponse = sIn.readNBytes(4);
		if ((serverResponse[1] & 0xff) == 22)
			System.out.println("Script de atividade automática executado com sucesso.");
		if ((serverResponse[1] & 0xff) == 253)
			System.out.println("Não foi possivel executar o script de atividade automática com sucesso.");
	}


	public static void main(String[] args) throws IOException {

		TcpExecuterClient tcpClient = new TcpExecuterClient();
		tcpClient.startConnection(Application.settings().getIpAutomatictaskExecutor());

		boolean cycle = true;
		while (cycle) {
			int i = Console.readInteger("Insira num (0 para sair)");
			switch (i) {
				case 0:
					tcpClient.stopConnection();
					cycle = false;
					break;
				case 20:
					tcpClient.executeAutomaticTask("");
					break;
				default:
					System.out.println("Invalid Option");
			}
		}
	}
}