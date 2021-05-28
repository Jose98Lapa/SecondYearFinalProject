package eapli.base.automatictask.executor.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	private static InetAddress serverIP;
	private static Socket socket;

	public static void main ( String[] args ) throws Exception {
		if ( args.length != 1 ) {
			System.out.println( "Server IPv4/IPv6 address or DNS name is required as argument" );
			System.exit( 1 );
		}

		TcpClient tcpClient = new TcpClient();
		tcpClient.startConnection(args[0]);

	}

	private void startConnection(String ip) throws IOException {
		try {
			serverIP = InetAddress.getByName(ip);
		} catch ( UnknownHostException ex ) {
			System.out.println( "Invalid server specified: " + ip );
			System.exit( 1 );
		}

		try {
			socket = new Socket( serverIP, 9999 );
		} catch ( IOException ex ) {
			System.out.println( "Failed to establish TCP connection" );
			System.exit( 1 );
		}

		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		DataOutputStream sOut = new DataOutputStream( socket.getOutputStream( ) );
		DataInputStream sIn = new DataInputStream( socket.getInputStream( ) );
	}

	private void serviceList(){

	}
}
