package eapli.base.workflow.engine;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer implements Runnable {

	private static ServerSocket serverSocket;
	private Socket clientSocket;
	//private DataOutputStream sOut;
	//private DataInputStream sIn;
	private PrintWriter sOut;
	private BufferedReader sIn;

	public TcpServer (Socket cli_s) {
		clientSocket = cli_s;
	}

	public void run () {
		InetAddress clientIP=clientSocket.getInetAddress();
		System.out.println( "New client connection from " + clientIP.getHostAddress( ) + ", port number " + clientSocket.getPort( ) );

		try {
			//sOut = new DataOutputStream( socket.getOutputStream( ) );
			//sIn = new DataInputStream( socket.getInputStream( ) );
			sOut = new PrintWriter( clientSocket.getOutputStream( ),true);
			sIn = new BufferedReader( new InputStreamReader(clientSocket.getInputStream( )));

			String inputLine;
			while ((inputLine = sIn.readLine()) != null) {
				if (".".equals(inputLine)) {
					System.out.println("bye, bye");
					break;
				}
			}

			System.out.println( "Client " + clientIP.getHostAddress( ) + ", port number: " + clientSocket.getPort() + " disconnected" );
			clientSocket.close( );
		} catch ( IOException ex ) {
			System.out.println( "IOException" );
		}
	}

	public static void main(String[] args) throws Exception {
		Socket cliSock;
		try {
			serverSocket = new ServerSocket(9999);
		} catch (IOException ex) {
			System.err.println("Failed to open server socket");
			System.exit(1);
		}
		while (true) {
			cliSock = serverSocket.accept();
			new Thread(new TcpServer(cliSock)).start();
		}
	}



}



