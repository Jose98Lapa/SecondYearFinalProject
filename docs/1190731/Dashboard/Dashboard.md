# US4002 - Disponibilizar os dados necessários às aplicações "Serviços e RH" e "Portal dos Utilizadores"
=======================================


# 1. Requisitos

Exibir dashboard com tarefas pendentes. Do dashboard deve constar, entre outras dados, o número de tarefas pendentes do utilizador, quantas dessas tarefas já terminou o prazo limite de resolução indicado no pedido e quantas terminam esse prazo em breve (e.g. em menos de 1 hora), a distribuição dessas tarefas pelos patamares de urgência e de criticidade. Este deve ser exibido imediatamente após autenticação do utilizador e manter-se sempre atualizado (e.g., ao ser-lhe atribuída a realização de uma nova tarefa, o dashboard deve atualizar, sem intervenção do utilizador, a quantidade de tarefas pendentes).


# 2. Implementação

Para receber a informação disponibilizada pelo Servidor do Motor de Fluxos esta funcionalidade utiliza sockets. Assim, é feito um request ao referido servidor sempre que é necessária uma atualização. Para concretizar a atualização o servidor HTML ,implementado em java, depois de receber os dados, manipula as Strings que recebe de modo a representar a informacao de forma correta na pagina web. Uma função em JavaScript assegura que a informaçao é atualizada

# 3. Integração/Demonstração

```
function refreshCriticality() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("criticality");
    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "white";
        console.log(this.responseText);
        setTimeout(refreshCriticality, 2000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshCriticality, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshCriticality, 5000);
    };
    request.open("GET", "/criticality", true);
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


public List<String> TaskInfoList(String email) throws IOException {
//send initial request
byte[] clientRequest = {(byte) 0, (byte) 3, (byte) 0, (byte) 0};
sOut.write(clientRequest);
sOut.flush();

//recives server's response
byte[] serverResponse = sIn.readNBytes(4);
if ((int)serverResponse[1]!=2) {
    System.out.println("Resposta invalida");
    System.exit(1);
}

//send email
byte[] emailByteArray=email.getBytes(StandardCharsets.UTF_8);
byte[] emailInfo ={(byte) 0, (byte) 255, (byte) emailByteArray.length};
byte[] emailPackage = ArrayUtils.addAll(emailInfo,emailByteArray);
sOut.write(emailPackage);
sOut.flush();

//receber os atributos
List<String> taskInfoList = new ArrayList<>();
int count=0;
String taskInfo;
while(true){
    byte[] info = sIn.readNBytes(3);
    if ((info[1]&0xff)==254)
        break;
    if ((info[1]&0xff)==253){
        System.out.println("A error occurred");
        break;
    }
    byte[] byteArray = sIn.readNBytes(info[2]);
    String atribute = new String(byteArray, StandardCharsets.UTF_8);
    StringBuilder taskInfobuilder = new StringBuilder();
    taskInfo=taskInfobuilder.append(atribute).append("|").toString();
    if (count==5){
        taskInfoList.add(taskInfo);
        taskInfo="";
        count=0;
    }
    count++;
}

if (taskInfoList.isEmpty()){
    System.out.println("Não existem tarefas associadas a este colaborador");
    return null;
}

return taskInfoList;

}
```

# 4. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



