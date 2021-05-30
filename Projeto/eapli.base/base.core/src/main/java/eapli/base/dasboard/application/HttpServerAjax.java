package eapli.base.dasboard.application;

import eapli.base.collaborator.dto.CollaboratorDTO;

import java.io.IOException;
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
   //static private final String BASE_FOLDER = "base.app.user.console/src/main/java/eapli/base/app/user/console/presentation/dashboard/www";
    static private final String BASE_FOLDER = "base.core/src/main/java/eapli/base/dasboard/application/www";
    static private ServerSocket sock;
    static private DashboardController theController  = new DashboardController();

    @Override
    public void run() {
        Socket cliSock = null;

        accessesCounter = 0;
        for (int i = 0; i < candidatesNumber; i++) {
            candidateName[i] = "Candidate " + i;
            candidateVotes[i] = 0;
        }

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
            incAccessesCounter();
        }
    }

    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static final int candidatesNumber = 4;
    private static final String[] candidateName = new String[candidatesNumber];
    private static final int[] candidateVotes = new int[candidatesNumber];
    private static int accessesCounter;
    private static CollaboratorDTO colab;

    public void setColab(CollaboratorDTO colab) {
        HttpServerAjax.colab = colab;
    }

    private static synchronized void incAccessesCounter() {
        accessesCounter++;
    }

    public static synchronized String getInfoUrgencyStandingInHTML() {
        StringBuilder string = new StringBuilder();
        theController.receiveInfoFromServer(colab.email);
        LinkedList<DashboardInfoDTO> info = theController.infoByUrgency();
        for (DashboardInfoDTO dto :info) {
            string.append("<tr>\n" +
                    "                            <td>\n" +
                    "                                <br>\n" +
                    "                                <div class=\"tooltip\"><img src="+calculateImage(dto.time)+" width=\"40\" height=\"40\">\n" +
                    "                                    <span class=\"tooltiptext\">"+dto.remainingTime+"</span>\n" +
                    "                                </div>\n" +
                    "                            </td>\n" +
                    "                            <td>"+dto.title+"</td>\n" +
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
            string.append("<tr>\n" +
                    "                            <td>\n" +
                    "                                <br>\n" +
                    "                                <div class=\"tooltip\"><img src="+calculateImage(dto.time)+" width=\"40\" height=\"40\">\n" +
                    "                                    <span class=\"tooltiptext\">"+dto.remainingTime+"</span>\n" +
                    "                                </div>\n" +
                    "                            </td>\n" +
                    "                            <td>"+dto.title+"</td>\n" +
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
