package eapli.base.workflow.engine.client;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	private static InetAddress serverIP;
	private static Socket clientSocket;
	//private DataOutputStream sOut;
	//private DataInputStream sIn;
	private PrintWriter sOut;
	private BufferedReader sIn;

	private final AuthorizationService authz = AuthzRegistry.authorizationService();

	public void startConnection(String ip) {
		try {
			serverIP = InetAddress.getByName(ip);
		} catch ( UnknownHostException ex ) {
			System.out.println( "Invalid server specified: " + ip );
			System.exit( 1 );
		}

		try {
			clientSocket = new Socket( serverIP, 9999 );
		} catch ( IOException ex ) {
			System.out.println( "Failed to establish TCP connection" );
			System.exit( 1 );
		}

		//BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		try {
			//sOut = new DataOutputStream( clientSocket.getOutputStream( ) );
			//sIn = new DataInputStream( clientSocket.getInputStream( ) );
			sOut = new PrintWriter( clientSocket.getOutputStream( ),true);
			sIn = new BufferedReader( new InputStreamReader(clientSocket.getInputStream( )));
		} catch (IOException e) {
			System.out.println( "Failed to establish DataOutputStream or DataInputStream" );
			System.exit( 1 );
		}
	}

	public void stopConnection(){
		try {
			sIn.close();
			sOut.close();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println( "Failed to close DataOutputStream, DataInputStream or client socket" );
			System.exit( 1 );
		}
	}

	public void serviceList(){
		String email = authz.session().get().authenticatedUser().email().toString();
		sOut.write(email);
	}
}
