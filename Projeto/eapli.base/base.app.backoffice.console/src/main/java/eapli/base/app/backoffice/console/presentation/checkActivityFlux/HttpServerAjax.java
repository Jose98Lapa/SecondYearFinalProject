package eapli.base.app.backoffice.console.presentation.checkActivityFlux;

import eapli.base.app.backoffice.console.presentation.checkActivityFlux.application.CheckActivityFluxController;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.dasboard.application.HttpAjaxRequest;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
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
        SSLSocket cliSock = null;
        System.setProperty("javax.net.ssl.keyStore", "server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
        System.setProperty("javax.net.ssl.keyStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");


        try {
            SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sock = sslF.createServerSocket(55128);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Server failed to open local port " + 55128);
        }
        while (true) {

            try {
                cliSock = (SSLSocket) sock.accept();
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
        theController.setStatus();
        return "<span id=\"state\">Estado:" + status + "</span>";
    }




}
