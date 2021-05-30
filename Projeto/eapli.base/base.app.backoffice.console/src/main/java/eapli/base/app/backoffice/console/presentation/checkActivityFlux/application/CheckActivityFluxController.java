package eapli.base.app.backoffice.console.presentation.checkActivityFlux.application;

import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.checkActivityFlux.HttpServerAjax;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.net.InetAddress;

public class CheckActivityFluxController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final HttpServerAjax server = new HttpServerAjax();

    public void showCollaborator() {
       setStatus();
        server.start();
    }

    public void setStatus(){
        server.setStatus(checkServer(Application.settings().getWorkflowServer()));
    }

    public String checkServer ( String ipAddress ) {
        try {
            InetAddress inet = InetAddress.getByName( ipAddress );

            if ( inet.isReachable( 1500 ) ) {
                return ( "O servidor responsável pelo motor de fluxo de atividades está online." );
            } else {
                return(  "O servidor responsável pelo motor de fluxo de atividades encontra-se offline." );
            }
        } catch ( Exception e ) {
            System.out.println( "Exception:" + e.getMessage( ) );
        }
        return null;
    }
}
