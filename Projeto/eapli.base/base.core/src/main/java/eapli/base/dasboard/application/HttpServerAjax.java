package eapli.base.dasboard.application;

import eapli.base.collaborator.dto.CollaboratorDTO;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * +
 *
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpServerAjax extends Thread {
    static private final String BASE_FOLDER = "base.core/src/main/java/eapli/base/dasboard/application/www";
    static private SSLServerSocket sock;
    static private DashboardController theController  = new DashboardController();

    @Override
    public void run() {
        SSLSocket cliSock = null;
        System.setProperty("javax.net.ssl.keyStore", "server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");


        try {
            SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sock = (SSLServerSocket) sslF.createServerSocket(55128);
        } catch (IOException ignored) {
            System.err.println("Server failed to open local port " + 55128 );
            System.out.println();
            ignored.printStackTrace();
        }
        while (true) {

            try {
                cliSock = (SSLSocket) sock.accept();
            } catch (IOException e) {
            }
            HttpAjaxRequest req = new HttpAjaxRequest(cliSock, BASE_FOLDER);
            req.start();
        }

    }

    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static CollaboratorDTO colab;

    public static synchronized void setColab(CollaboratorDTO colab) {
        HttpServerAjax.colab = colab;
    }

    public static synchronized String getInfoUrgencyStandingInHTML() {
        StringBuilder string = new StringBuilder();
        theController.receiveInfoFromServer(colab.email);
        LinkedList<DashboardInfoDTO> info = theController.infoByUrgency();
        for (DashboardInfoDTO dto :info) {
            string.append("<tr>" +
                    "                            <td>\n" +
                    "                                <br>\n" +
                    "                                <div class=\"tooltip\"><img src="+calculateImage(dto.time)+" width=\"40\" height=\"40\">\n" +
                    "                                    <span class=\"tooltiptext\">"+dto.remainingTime+"</span>\n" +
                    "                                </div>\n" +
                    "                            </td>\n" +
                    "                            <td>"+dto.title+"</td>\n" +
                    "                            <td><img src="+dto.icon+" width=40 height=40></td>" +
                    "                            <td>"+dto.briefDesc+"</td>\n" +
                    "                            <td>"+dto.deadline+"</td>\n" +
                    "                            <td>"+dto.criticidade+"</td>\n" +
                    "                            <td>"+dto.urgency+"</td>\n" +
                    "                        </tr>");
        }
        return string.toString();
    }

    public static synchronized String getInfoCriticalityStandingInHTML() {
        StringBuilder string = new StringBuilder();
        theController.receiveInfoFromServer(colab.email);
        LinkedList<DashboardInfoDTO> info = theController.infoByCriticality();
        for (DashboardInfoDTO dto :info) {
            string.append("<tr>" +
                    "                            <td>\n" +
                    "                                <br>\n" +
                    "                                <div class=\"tooltip\"><img src="+calculateImage(dto.time)+" width=\"40\" height=\"40\">\n" +
                    "                                    <span class=\"tooltiptext\">"+dto.remainingTime+"</span>\n" +
                    "                                </div>\n" +
                    "                            </td>\n" +
                    "                            <td>"+dto.title+"</td>\n" +
                    "                            <td><img src="+dto.icon+" width=40 height=40></td>" +
                    "                            <td>"+dto.briefDesc+"</td>\n" +
                    "                            <td>"+dto.deadline+"</td>\n" +
                    "                            <td>"+dto.criticidade+"</td>\n" +
                    "                            <td>"+dto.urgency+"</td>\n" +
                    "                        </tr>");
        }
        return string.toString();
    }

    public static synchronized String getColabInfoStandingInHTML() {
        return " <div class=\"topnav whiteText\" id=\"colabInfo\">\n" +
                "    <span class=\"active\">Dashboard</span>\n" +
                "    <span id=\"colabName\">Name: " + colab.fullName + "</span>\n" +
                "    <span id=\"colabId\">Mecanografic Number: " + colab.mNumber + "</span>\n" +
                "    <span id=\"colabEmail\">Email: " + colab.email + "</span>\n" +
                "</div> ";
    }

    public static synchronized String calculateImage(String time) {
        if (time=="1"){
            return "1hour.png";
        }
        if (time=="2"){
            return "ended.png";
        }
        return "default.png";
    }
}
