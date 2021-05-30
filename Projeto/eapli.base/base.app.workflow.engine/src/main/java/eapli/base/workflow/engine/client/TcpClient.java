package eapli.base.workflow.engine.client;

import eapli.base.Application;
import eapli.framework.io.util.Console;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TcpClient {

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
			socket = new Socket(serverIP, Integer.parseInt(Application.settings().getPortWorkflow()));
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

		System.out.println("Connection established with Worflow server\n");
	}

	public void stopConnection() {
		try {
			byte[] clientRequest = {(byte) 0, (byte) 1, (byte) 0, (byte) 0};
			sOut.write(clientRequest);
			sOut.flush();
			byte[] serverResponse=sIn.readNBytes(4);
			if((int)serverResponse[1]==2)
				System.out.println("Connection terminated with Worflow server");
			sIn.close();
			sOut.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Failed to close DataOutputStream, DataInputStream or client socket");
			System.exit(1);
		}
	}

	public List<String> TaskInfoList(String email) throws IOException {
		//send initial request
		byte[] clientRequest = {(byte) 0, (byte) 3, (byte) 0, (byte) 0};
		sOut.write(clientRequest);
		sOut.flush();

		//recives server's response
		byte[] serverResponse = sIn.readNBytes(4);
		if ((int)serverResponse[1]!=2) {
			System.out.println("Resposta invalida");
			System.exit(1);
		}

		//send email
		byte[] emailByteArray=email.getBytes(StandardCharsets.UTF_8);
		byte[] emailInfo ={(byte) 0, (byte) 255, (byte) emailByteArray.length};
		byte[] emailPackage = ArrayUtils.addAll(emailInfo,emailByteArray);
		sOut.write(emailPackage);
		sOut.flush();

		//receber os atributos
		List<String> taskInfoList = new ArrayList<>();
		int count=0;
		String taskInfo;
		while(true){
			byte[] info = sIn.readNBytes(3);
			if ((info[1]&0xff)==254)
				break;
			if ((info[1]&0xff)==253){
				System.out.println("A error occurred");
				break;
			}
			byte[] byteArray = sIn.readNBytes(info[2]);
			String atribute = new String(byteArray, StandardCharsets.UTF_8);
			StringBuilder taskInfobuilder = new StringBuilder();
			taskInfo=taskInfobuilder.append(atribute).append("|").toString();
			if (count==5){
				taskInfoList.add(taskInfo);
				taskInfo="";
				count=0;
			}
			count++;
		}

		if (taskInfoList.isEmpty()){
			System.out.println("Não existem tarefas associadas a este colaborador");
			return null;
		}

		return taskInfoList;

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
					tcpClient.TaskInfoList("guilli@isep.ipp.pt");
					break;
				default:
					System.out.println("Invalid Option");
			}
		}
	}
}
