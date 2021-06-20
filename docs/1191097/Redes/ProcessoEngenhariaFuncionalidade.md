# UC 5002 - Proteger comunicações realizadas como aplicação servidora através do protocolo SDP2021
=======================================


# 1. Requisitos

**UC 5002:**  Proteger comunicações realizadas como aplicação servidora através do protocolo SDP2021

Como Gestor de Projeto, eu pretendo que as comunicações realizadas como aplicação servidora através do protocolo SDP2021 estejam protegidas.

Critérios de Aceitação / Observações:
- Aplicar SSL/TLS com autenticação mútua baseada em certificados de chave pública.


# 2. Análise

Para análise, o modelo de domínio dá resposta ao requisito, não sendo assim necessário estender o mesmo. [Verificar modelo de domínio](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Modelo%20de%20Dominio.svg)

# 3. Design

## 3.1. Realização da Funcionalidade
Para este requisito foi aplicado SSL/TLS com uma autenticação mutua baseada em certificados, tal como requirido.

# 4. Implementação

### Uso de threads
```java
class TcpServer {

    static SSLServerSocket sock;

    public static void main(String[] args) throws Exception {
        Socket cliSock;

        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", "server.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", "server.keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sock = (SSLServerSocket) sslF.createServerSocket(Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));
            System.exit(1);
        }


        while (true) {
            cliSock = sock.accept();
            new Thread(new TcpServerThread(cliSock)).start();
        }
    }

}
```

# 5. Integração/Demonstração

Na implementação desta funcionalidade demos com alguns problemas referentes ao certificado.
