package eapli.base.dasboard.application;

import javax.net.ssl.SSLSocket;
import java.io.*;
import java.net.Socket;

/**
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpAjaxRequest extends Thread {
    String baseFolder;
    SSLSocket sock;
    DataInputStream inS;
    DataOutputStream outS;

    public HttpAjaxRequest(SSLSocket s, String f) {
        baseFolder = f;
        sock = s;
    }

    public void run() {
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());
        } catch (IOException ex) {
            System.out.println("Thread error on data streams creation");
        }
        try {
            HTTPmessage request = new HTTPmessage(inS);
            HTTPmessage response = new HTTPmessage();
            if (request.getMethod().equals("GET")) {
                if (request.getURI().equals("/colabInfo")) {
                    response.setContentFromString(HttpServerAjax.getColabInfoStandingInHTML(), "text/html");
                    response.setResponseStatus("200 Ok");
                } else if (request.getURI().equals("/criticality")) {
                    response.setContentFromString(HttpServerAjax.getInfoCriticalityStandingInHTML(), "text/html");
                    response.setResponseStatus("200 Ok");
                } else if (request.getURI().equals("/urgency")){
                    response.setContentFromString(HttpServerAjax.getInfoUrgencyStandingInHTML(), "text/html");
                    response.setResponseStatus("200 Ok");
                } else {
                    String fullname = baseFolder + "/";
                    if (request.getURI().equals("/")) {
                        fullname = fullname + "index.html";
                    } else {
                        fullname = fullname + request.getURI();
                    }
                    if (response.setContentFromFile(fullname)) {
                        response.setResponseStatus("200 Ok");
                    } else {
                        response.setContentFromString(
                                "<html><body><h1>404 File not found</h1></body></html>",
                                "text/html");
                        response.setResponseStatus("404 Not Found");
                    }
                }
                response.send(outS);
            } else { // NOT GET
                if ((request.getMethod().equals("PUT") && request.getURI().startsWith("/votes/"))) {
                    response.setResponseStatus("200 Ok");
                } else {
                    response.setContentFromString(
                            "<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
                            "text/html");
                    response.setResponseStatus("405 Method Not Allowed");
                }
                response.send(outS);
            }
        } catch (IOException ex) {
            //System.out.println("Thread error when reading request");
        }
        try {
            sock.close();
        } catch (IOException ex) {
            System.out.println("CLOSE IOException");
        }
    }
}

