# UC 5001 - Executor de Tarefas Automáticas
=======================================


# 1. Requisitos

**UC 5001:**  Como Gestor de Projeto, eu pretendo que seja desenvolvido o Executor de Tarefas Automáticas.

Critérios de Aceitação / Observações:

- Deve ser usado o protocolo de aplicação fornecido (SDP2021).
- Deve ser suportado o processamento simultaneo de pedidos para execução de tarefas automáticas.
- Neste sprint, para efeitos de demonstração, é aceitável que a execução das tarefas automáticas seja apenas simulada (mock).


# 2. Análise

Para análise, o modelo de domínio dá resposta ao requisito, não sendo assim necessário estender o mesmo. [Verificar modelo de domínio](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Modelo%20de%20Dominio.svg)

# 3. Design

Para este requisito foi usado o protocolo de aplicação fornecido ([SDP2001](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Servidor(es)%20Aplicacional(ais)/Executor%20de%20Tarefas%20Autom%C3%A1ticas/file.md)). Para a que se possa suportar o processamento simultaneo de pedidos para execução de tarefas automáticas foram utilizadas threads, um pequeno programa que trabalha como um subsistema, sendo uma forma de um processo se autodividir em duas ou mais tarefas. A ligação TCP deve persiste apenas durante a execução de cada tarefa automática. Uma vez terminada a execução da tarefa, o server envia feedback ao cliente do sucesso ou insucesso da execução da tarefa automática e ai o cliente solicita o fim da ligação.

# 4. Implementação

### Uso de threads
```java
class TcpServer {

    static ServerSocket sock;

    public static void main(String[] args) throws Exception {
        Socket cliSock;

        try {
            sock = new ServerSocket(Integer.parseInt(Application.settings().getPortAutomatictaskExecutor()));
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
```

### Uso do SPD2021
```java
public void executeAutomaticTask(String script) throws IOException {
		//send initial request
		byte[] clientRequest = {(byte) 0, (byte) 20, (byte) 0, (byte) 0};
		sOut.write(clientRequest);
		sOut.flush();

		//recives server's response
		byte[] serverResponse = sIn.readNBytes(4);
		if ((int) serverResponse[1] == 2)
			System.out.println("Resposta Recebida");

		//send script
		byte[] scriptByteArray = script.getBytes(StandardCharsets.UTF_8);
		if (scriptByteArray.length <= 255) {
			byte[] scriptInfo = {(byte) 0, (byte) 21, (byte) scriptByteArray.length};
			byte[] scriptPackage = ArrayUtils.addAll(scriptInfo, scriptByteArray);
			sOut.write(scriptPackage);
			sOut.flush();
		} else {
			byte[][] splitScript = SplitInfo.splitObjectIntoByteArray(script);
			int code = 255;
			for (int i = 0; i < splitScript.length; i++) {
				if (i == splitScript.length - 1)
					code = 254;
				byte[] scriptInfo = {(byte) 0, (byte) code, (byte) splitScript[i].length};
				byte[] scriptPackage = ArrayUtils.addAll(scriptInfo, splitScript[i]);
				sOut.write(scriptPackage);
				sOut.flush();
			}
		}

		//recives server's response
		serverResponse = sIn.readNBytes(4);
		if ((serverResponse[1] & 0xff) == 22)
			System.out.println("Script de atividade automática executado com sucesso.");
		if ((serverResponse[1] & 0xff) == 253)
			System.out.println("Não foi possivel executar o script de atividade automática com sucesso.");
	}
```

# 5. Integração/Demonstração

Para a implementação desta funcionalidade foi necessário um bocado mais tempo do que o habitual pois é algo novo. Todavia, o trabalho foi sempre bastante fluido. Para efeitos de demonstração, a execução das tarefas automáticas foi apenas simulada. A execução desta funcionalidade é desencandeada pelo motor de fluxos de atividade, onde este exerce o papel de cliente SDP2021

# 6. Observações

Penso que esta funcionalidade esteja de acordo com os requerimentos do cliente. Os requerimentos foram bastante claros, o que ajudou bastante, pois, sendo esta uma coisa nova, ajuda sempre. Dito isto, penso que esta funcionalidade está de acordo com o pedido, foi usado o protocolo de aplicação fornecido(SPD2021) e é suposrtado o processo simultanio de execuções. Para alem disso, a funcionalidade funciona como esperado com o fluxo de atividades.
