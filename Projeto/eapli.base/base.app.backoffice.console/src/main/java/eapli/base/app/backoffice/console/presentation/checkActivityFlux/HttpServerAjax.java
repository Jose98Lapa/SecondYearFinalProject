package eapli.base.app.backoffice.console.presentation.checkActivityFlux;

import eapli.base.app.backoffice.console.presentation.checkActivityFlux.HttpAjaxRequest;
import eapli.base.app.backoffice.console.presentation.checkActivityFlux.application.CheckActivityFluxController;
import eapli.base.collaborator.dto.CollaboratorDTO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * +
 *
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpServerAjax extends Thread {
    static private final String BASE_FOLDER = "base.app.backoffice.console/src/main/java/eapli/base/app/backoffice/console/presentation/checkActivityFlux/www";
    static private ServerSocket sock;
    static CheckActivityFluxController theController = new CheckActivityFluxController();

    public void setStatus(String status) {
        HttpServerAjax.status = status;
    }

    @Override
    public void run() {
        Socket cliSock = null;


        try {
            sock = new ServerSocket(55128);
        } catch (IOException ex) {
            System.err.println("Server failed to open local port " + 55128);

        }
        while (true) {

            try {
                cliSock = sock.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpAjaxRequest req = new HttpAjaxRequest(cliSock, BASE_FOLDER);
            req.start();
        }
    }

    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static String status;


    public static synchronized String getStatusInfoStandingInHTML() {
        theController.checkServer("192.168.1.92");
        return "<span id=\"state\">Estado:" + status + "</span>";
    }




}
