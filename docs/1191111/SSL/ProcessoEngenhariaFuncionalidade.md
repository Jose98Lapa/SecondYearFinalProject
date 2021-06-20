# UC 4051 - Proteger comunicações realizadas como aplicação servidora através do protocolo SDP2021
=======================================


# 1. Requisitos

**UC 4051:**  Proteger comunicações realizadas como aplicação servidora através do protocolo SDP2021

Como Gestor de Projeto, eu pretendo que as comunicações realizadas como aplicação servidora através do protocolo SDP2021 estejam protegidas.

Critérios de Aceitação / Observações:
- Aplicar SSL/TLS com autenticação mútua baseada em certificados de chave pública.


# 2. Análise

Para análise, o modelo de domínio dá resposta ao requisito, não sendo assim necessário estender o mesmo. [Verificar modelo de domínio](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Modelo%20de%20Dominio.svg)

# 3. Design

## 3.1. Realização da Funcionalidade
Para este requisito foi aplicado SSL/TLS com uma autenticação mutua baseada em certificados, tal como requirido.

# 4. Implementação

### TCP SERVER
```java
 public static void main(String[] args) throws InterruptedException {
        Socket cliSock;

        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", "server.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", "server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(Application.settings().getPortWorkflow()));
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + Integer.parseInt(Application.settings().getPortWorkflow()));
            System.exit(1);
        }
        while (true) {
            try {
                cliSock = sslServerSocket.accept();
                //new Thread(new TcpServer(cliSock)).start();
                new TcpServer(cliSock).run();

            } catch (IOException e) {
                System.out.println("failed to accept client socket");
            }
        }
```

### TCP CLIENT
```java
 public class TcpClient {

    private static InetAddress serverIP;
    private static SSLSocket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;


    public boolean startConnection(String ip) {

        // Trust these certificates provided by servers
        System.setProperty("javax.net.ssl.trustStore", "server.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", "server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            serverIP = InetAddress.getByName(ip);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + ip);
            //System.exit(1);
        }

        try {
            socket = (SSLSocket) sslSocketFactory.createSocket(serverIP, Integer.parseInt(Application.settings().getPortWorkflow()));
        } catch (IOException ex) {
            //System.out.println("Failed to establish TCP connection");
            //System.exit(1);
            return false;
        }


        //System.out.println("Connected to: " + ip + ":" + Integer.parseInt(Application.settings().getPortWorkflow()));

        try {
            socket.startHandshake();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        ...
```

# 5. Integração/Demonstração

Na implementação desta funcionalidade demos com alguns problemas referentes ao certificado.
