# US2102 - Proteger comunicações realizadas através do protocolo SDP2021
=======================================


# 1. Requisitos

Exibir o estado atual do motor de fluxos de atividade e que se mantenha atualizado automaticamente. O resultado deve ser apresentado num servidor HTTP existente na aplicação "Serviços e RH" e esteja apenas disponível para o localhost.


# 2. Implementação

Para receber o estado atual do Servidor do Motor de Fluxos esta funcionalidade utiliza sockets. Assim, é feito um request ao referido servidor sempre que é necessária uma atualização. Para concretizar a atualização o servidor HTML ,implementado em java, depois de receber a informação, manipula a String que recebe de modo a representar a informacao de forma correta na pagina web. Uma função em JavaScript assegura que a informaçao é atualizada



# 3. Integração/Demonstração

Para o servidor HTTPS utilizamos a porta 55128 em localhost.

```
function refreshStatus() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("stateDiv");
    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "white";
        console.log(this.responseText);
        setTimeout(refreshStatus, 3000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshStatus, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshStatus, 5000);
    };
    request.open("GET", "/stateDiv", true);
    request.timeout = 5000;
    request.send();
}

public static synchronized String getStatusInfoStandingInHTML() {
        theController.setStatus();
        String toReturn ="<ul>";
        for (String str: status ) {
            toReturn+="<li><span id=\"state\">Estado:" + str + "</span>\n</li>";
        }
        return toReturn+"</ul>";
    }
```
Socket request
```
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
            CheckActivityHttpAjaxRequest req = new CheckActivityHttpAjaxRequest(cliSock, BASE_FOLDER);
            req.start();
        }

}
```

Obtenção de Informação
```
 public void setStatus() {
        ArrayList<String> servidores = new ArrayList<>();
        try {
            File myObj = new File("Executer_ip_list.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String ip = myReader.nextLine();
                servidores.add(checkServer(ip.trim()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        server.setStatusList(servidores);
    }

        public String checkServer ( String ipAddress ) {
        try {
            InetAddress inet = InetAddress.getByName( ipAddress );

            if ( inet.isReachable( 1500 ) ) {
                return ( "O servidor responsavel pelo motor de fluxo de atividades esta online." );
            } else {
                return(  "O servidor responsável pelo motor de fluxo de atividades encontra-se offline." );
            }
        } catch ( Exception e ) {
            System.out.println( "Exception:" + e.getMessage( ) );
        }
        return null;
    }


```

