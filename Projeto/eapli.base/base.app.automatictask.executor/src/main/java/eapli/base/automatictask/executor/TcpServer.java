package eapli.base.automatictask.executor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TcpServer {

    static ServerSocket sock;

    public static void main(String[] args) throws Exception {
        Socket cliSock;

        try {
            sock = new ServerSocket(9999);
        } catch (IOException ex) {
            System.err.println("Failed to open server socket");
            System.exit(1);
        }

        while (true) {
            cliSock = sock.accept();
            new Thread(new TcpServerThread(cliSock)).start();
        }
    }

}


class TcpServerThread implements Runnable {

    private Socket s;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public TcpServerThread(Socket cli_s) {
        s = cli_s;
    }

    public void run() {

        long f, i, num, sum;
        InetAddress clientIP;

        clientIP = s.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() +
                ", port number " + s.getPort());
        try {

            sOut = new DataOutputStream(s.getOutputStream());
            sIn = new DataInputStream(s.getInputStream());

            int info = sIn.read();
            sum = onMessage();

            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() +
                    " disconnected");
            s.close();
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    private long onMessage() throws IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0L;
    }

}



