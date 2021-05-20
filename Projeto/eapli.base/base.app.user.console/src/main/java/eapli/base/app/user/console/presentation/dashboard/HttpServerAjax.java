package eapli.base.app.user.console.presentation.dashboard;

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
    static private final String BASE_FOLDER = "base.app.user.console/src/main/java/eapli/base/app/user/console/presentation/dashboard/www";
    static private ServerSocket sock;

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
                "    <span id=\"colabName\">Name: " + colab.fullName + "</span>\n" +
                "    <span id=\"colabId\">Mecanografic Number: " + colab.mNumber + "</span>\n" +
                "    <span id=\"colabEmail\">Email: " + colab.email + "</span>\n" +
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
