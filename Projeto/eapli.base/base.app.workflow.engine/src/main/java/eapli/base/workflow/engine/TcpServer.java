package eapli.base.workflow.engine;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TcpServer implements Runnable {

	private static ServerSocket serverSocket;
	private Socket clientSocket;
	private DataOutputStream sOut;
	private DataInputStream sIn;

	public TcpServer (Socket cli_s) {
		clientSocket = cli_s;
	}

	public void run () {
		InetAddress clientIP=clientSocket.getInetAddress();
		System.out.println( "New client connection from " + clientIP.getHostAddress( ) + ", port number " + clientSocket.getPort( ) );

		try {
			sOut = new DataOutputStream( clientSocket.getOutputStream( ) );
			sIn = new DataInputStream( clientSocket.getInputStream( ) );

			boolean cycle = true;
			while (cycle){
				byte[] clientMsg = sIn.readAllBytes();
				int code = clientMsg[1];
				switch (clientMsg[1]){
					case 1:
						byte[] msg= {(byte)0, (byte)2, (byte)0, (byte)0};
						sOut.write(msg);
						cycle=false;
						break;
					case 3:
						for (int i = 0; i <(int) clientMsg[2] ; i++) {
							byte[] msgs=sIn.readAllBytes();
							byte[] variable = Arrays.copyOfRange(msgs, 3,msgs.length);
							System.out.printf("%s\n", Arrays.toString(variable));
						}
						break;
				}

			}

			System.out.println( "Client " + clientIP.getHostAddress( ) + ", port number: " + clientSocket.getPort() + " disconnected" );
			clientSocket.close( );
		} catch ( IOException ex ) {
			System.out.println( "Failed to close client socket" );
		}
	}

	public static void main(String[] args) {
		Socket cliSock;
		try {
			serverSocket = new ServerSocket(10020);
		} catch (IOException ex) {
			System.err.println("Failed to open server socket");
			System.exit(1);
		}
		while (true) {
			try {
				cliSock = serverSocket.accept();
				new Thread(new TcpServer(cliSock)).start();

			} catch (IOException e) {
				System.out.println("failed to accept client socket");
			}
		}
	}



}







