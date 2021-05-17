package eapli.base.app.backoffice.console.presentation.dashboard;

import eapli.base.AppSettings;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**+
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpServerAjax {
    static private final String BASE_FOLDER="base.app.backoffice.console/src/main/java/eapli/base/app/backoffice/console/presentation/dashboard/www/";
    static private ServerSocket sock;

    public static void main(String args[]) throws Exception {
        Socket cliSock;
        /*
        if ( app.getHttpPort() == 0) {
            System.out.println("Local port number required at the command line.");
            System.exit(1);
        }*/

        accessesCounter = 0;
        for (int i = 0; i < candidatesNumber; i++) {
            candidateName[i] = "Candidate " + i;
            candidateVotes[i] = 0;
        }

        try {
            sock = new ServerSocket(55127);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " +  55127);
            System.exit(1);
        }
        while (true) {
            cliSock = sock.accept();
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
    private static String name = "Manel";
    private static String id = "38";
    private static String email = "t@t.com";

    private List<String> tasks = new ArrayList<>();


    private static synchronized void incAccessesCounter() {
        accessesCounter++;
    }

    public static synchronized String getVotesStandingInHTML() {
        String textHtml = "<ul class=\"whiteText\">";
        for (int i = 0; i < candidatesNumber; i++) {
            textHtml = textHtml + "<li><button type=button onclick=voteFor(" + (i + 1) +
                    ")>Vote for " + candidateName[i] + "</button> " +
                    " - " + candidateVotes[i] + " votes </li>";
        }
        textHtml = textHtml + "</ul><p class=\"whiteText\">HTTP server accesses counter: " + accessesCounter + "</p>";
        return textHtml;
    }
    public static synchronized String getColabInfoStandingInHTML() {
        return " <div class=\"topnav whiteText\" id=\"colabInfo\">\n" +
                "    <span class=\"active\">Dashboard</span>\n" +
                "    <span id=\"colabName\">Name: "+name+"</span>\n" +
                "    <span id=\"colabId\">Id: "+id+"</span>\n" +
                "    <span id=\"colabEmail\">Email: "+email+"</span>\n" +
                "</div> ";
    }

    public static synchronized void castVote(String i) {
        int cN;
        try {
            cN = Integer.parseInt(i);
        } catch (NumberFormatException ne) {
            return;
        }
        cN--;
        if (cN >= 0 && cN < candidatesNumber) candidateVotes[cN]++;
    }


}
