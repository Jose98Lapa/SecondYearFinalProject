# US2011 - Conhecer o estado atual do motor de fluxos de atividades
=======================================


# 1. Requisitos

Exibir o estado atual do motor de fluxos de atividade e que se mantenha atualizado automaticamente. O resultado deve ser apresentado num servidor HTTP existente na aplicação "Serviços e RH" e esteja apenas disponível para o localhost.


# 2. Implementação

Para receber o estado atual do Servidor do Motor de Fluxos esta funcionalidade utiliza sockets. Assim, é feito um request ao referido servidor sempre que é necessária uma atualização. Para concretizar a atualização o servidor HTML ,implementado em java, depois de receber a informação, manipula a String que recebe de modo a representar a informacao de forma correta na pagina web. Uma função em JavaScript assegura que a informaçao é atualizada

# 3. Integração/Demonstração

```
function refreshStatus() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("stateDiv");
    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "white";
        console.log(this.responseText);
        setTimeout(refreshStatus, 1);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshStatus, 1);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshStatus, 1);
    };
    request.open("GET", "/stateDiv", true);
    request.timeout = 5000;
    request.send();
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
```
Socket request
```
public void startConnection(String ip) {
    try {
        serverIP = InetAddress.getByName(ip);
    } catch (UnknownHostException ex) {
        System.out.println("Invalid server specified: " + ip);
        System.exit(1);
    }

    try {
        socket = new Socket(serverIP, Integer.parseInt(Application.settings().getPortWorkflow()));
    } catch (IOException ex) {
        System.out.println("Failed to establish TCP connection");
        System.exit(1);
    }


    try {
        sOut = new DataOutputStream(socket.getOutputStream());
        sIn = new DataInputStream(socket.getInputStream());
    } catch (IOException e) {
        System.out.println("Failed to establish DataOutputStream or DataInputStream");
        System.exit(1);
    }

    System.out.println("Connection established with Worflow server\n");
}
```
Conexão com o server

```
public String checkServer ( String ipAddress ) {
        try {
            InetAddress inet = InetAddress.getByName( ipAddress );

            if ( inet.isReachable( 1500 ) ) {
                return ( "O servidor responsável pelo motor de fluxo de atividades está online." );
            } else {
                return(  "O servidor responsável pelo motor de fluxo de atividades encontra-se offline." );
            }
        } catch ( Exception e ) {
            System.out.println( "Exception:" + e.getMessage( ) );
        }
        return null;
    }



# 4. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



