# UC 4002 - Disponibilização de dados pelo Motor de Fluxo
=======================================


# 1. Requisitos

**UC 4002:**  Como Gestor de Projeto, eu pretendo que o Motor de Fluxo de Atividades disponibilize, a pedido, os dados necessários às aplicações "Serviços e RH" e "Portal dos Utilizadores".

Critérios de Aceitação / Observações:

- Deve ser usado o protocolo de aplicação fornecido (SDP2021).
- Deve ser suportado o processamento simultaneo de pedidos.
- Sugere-se que desde já seja considerada a adoção de mecanismos concorrente (e.g. threads) e partilha de estado entre esses mecanismos.
- Neste sprint, para efeitos de demonstração, é aceitável que o processamento associado a algumas destas comunicações seja apenas simulado (mock).


# 2. Análise

Para análise, o modelo de domínio dá resposta ao requisito, não sendo assim necessário estender o mesmo. [Verificar modelo de domínio](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Modelo%20de%20Dominio.svg)

# 3. Design

Para este requisito foi usado o protocolo de aplicação fornecido ([SDP2001]https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Servidor(es)%20Aplicacional(ais)/Motor%20de%20Fluxos%20de%20Atividades/file.md)). Para a que se possa suportar o processamento simultaneo de pedidos para execução de tarefas automáticas foram utilizadas threads, um pequeno programa que trabalha como um subsistema, sendo uma forma de um processo se autodividir em duas ou mais tarefas. A ligação TCP deve persiste apenas durante a execução de cada tarefa automática. Uma vez terminada a execução da tarefa, o server envia feedback ao cliente do sucesso ou insucesso da execução da tarefa automática e ai o cliente solicita o fim da ligação.

# 4. Implementação

### Uso de threads
```java
public static void main(String[] args) {
        Socket cliSock;
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());
        try {
            serverSocket = new ServerSocket(Integer.parseInt(Application.settings().getPortWorkflow()));
        } catch (IOException ex) {
            System.err.println("Failed to open server socket");
            System.exit(1);
        }
        while (true) {
            try {
                cliSock = serverSocket.accept();
                new Thread(new TcpServer(cliSock)).start();

            } catch (IOException e) {
                System.out.println("failed to accept client socket");
            }
        }
    }
```

### Uso do SPD2021
```java
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
			byte[] byteArray = sIn.readNBytes(info[2]&0xff);
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

# 5. Integração/Demonstração
Este implementação consumiu bastante tempo e requeriu pesquisa, devido ao facto de ter sido algo com que não tinha experiencia.  Para efeitos de demonstração, são disponibilados os dados necessários para o Portal dos Utilizadores. A execução desta funcionalidade é desencandeada pelo motor de fluxos de atividade, onde este exerce o papel de cliente SDP2021

# 6. Observações
Penso que todos os critetios foram cumpridos, o protocologo da aplicação foi seguido. São suportados pedidos simultaneos ao servidor, através da adoção do mecanismo de Threads. 

