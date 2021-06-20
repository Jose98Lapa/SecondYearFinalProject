package eapli.base.app.backoffice.console.presentation.checkActivityFlux.application;

import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.checkActivityFlux.HttpServerAjax;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CheckActivityFluxController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final HttpServerAjax server = new HttpServerAjax();

    public void showCollaborator() {
       setStatus();
        server.start();
    }

    public void setStatus() {
        ArrayList<String> servidores = new ArrayList<>();
        try {
            File myObj = new File("Executer_ip_list.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String ip = myReader.nextLine();
                servidores.add(checkServer(ip.trim()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        server.setStatusList(servidores);
    }

        public String checkServer ( String ipAddress ) {
        try {
            InetAddress inet = InetAddress.getByName( ipAddress );

            if ( inet.isReachable( 1500 ) ) {
                return ( "O servidor responsavel pelo motor de fluxo de atividades esta online." );
            } else {
                return(  "O servidor responsável pelo motor de fluxo de atividades encontra-se offline." );
            }
        } catch ( Exception e ) {
            System.out.println( "Exception:" + e.getMessage( ) );
        }
        return null;
    }
}
