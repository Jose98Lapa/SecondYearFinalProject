package eapli.base.app.backoffice.console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.List;

public class Utils {

	public void checkServer ( String ipAddress, String name ) {
		try {
			InetAddress inet = InetAddress.getByName( ipAddress );
			System.out.println( "Testing  " + name + " on " + ipAddress );
			if ( inet.isReachable( 1500 ) ) {
				System.out.println( "\u001B[32m" + name + " server is online. \u001B[0m" );
			} else {
				System.out.println( "\u001B[31m" + name + " server is offline. \u001B[0m" );
			}
		} catch ( Exception e ) {
			System.out.println( "Exception:" + e.getMessage( ) );
		}
	}

	public void checkServers ( ) {
		System.out.println( "+= Testing Servers ======================================================================+\n" );
        /*checkServer(Application.settings().getDatabaseIp(),"DATABASE");
        checkServer(Application.settings().getImageServerIp(),"IMAGE SERVER");
        checkServer(Application.settings().getWorkflowServer(),"WORKFLOW ENGINE");*/
		checkServer( "10.9.20.221", "DATABASE" );
		checkServer( "10.9.21.17", "IMAGE SERVER" );
		checkServer( "10.9.21.27", "WORKFLOW ENGINE" );
	}

	static public String readLineFromConsole ( String prompt ) {
		try {
			System.out.println( "\n" + prompt );

			InputStreamReader input = new InputStreamReader( System.in );
			BufferedReader in = new BufferedReader( input );

			return in.readLine( );
		} catch ( Exception e ) {
			e.printStackTrace( );
			return null;
		}
	}

	public static < E > int showAndSelectIndex ( List< E > list, String header ) {
		showList( list, header );
		return selectsIndex( list );
	}

	public static < E > void showList ( List< E > list, String header ) {
		System.out.println( header );
		int index = 0;

		for ( Object o : list ) {

			index++;
			System.out.println( "-------------------------------- | Index : " + index + " | -------------------------------------------" );
			System.out.println( o.toString() );
		}

		System.out.println( "" );
		System.out.println( "0 - Cancel" );
	}

	static public < E > int selectsIndex ( List< E > list ) {
		String input;
		Integer value;

		do {
			input = Utils.readLineFromConsole( "Type your option: " );
			value = Integer.valueOf( input );
		} while ( value < 0 || value > list.size( ) );

		return value - 1;
	}

}
