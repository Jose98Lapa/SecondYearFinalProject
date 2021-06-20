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

## 3.1. Realização da Funcionalidade
Para este requisito foi usado o protocolo de aplicação fornecido ([SDP2001](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Servidor(es)%20Aplicacional(ais)/Executor%20de%20Tarefas%20Autom%C3%A1ticas/file.md)). Para a que se possa suportar o processamento simultaneo de pedidos para execução de tarefas automáticas foram utilizadas threads, um pequeno programa que trabalha como um subsistema, sendo uma forma de um processo se autodividir em duas ou mais tarefas. A ligação TCP deve persiste apenas durante a execução de cada tarefa automática. Uma vez terminada a execução da tarefa, o server envia feedback ao cliente do sucesso ou insucesso da execução da tarefa automática e ai o cliente solicita o fim da ligação.

## 3.2. Testes 
Para assegurar que a serialização e a desserialização estão funcionais foi necessário a criação de um teste. Neste caso foi feito com uma String com mais de 255 carateres.

```java
    @Test
    public void ensureObjectStaysTheSame() throws IOException {
        String expected = "ESTEmedotoéusadoParaquandoUmObjetoÉDemasiadoGrandeParaSerEnviadouiehfuiehfuiheiufheifiuwehfiuhiufehwliurfhuiwgfuiwehfuioewhiofehwioufhifehwfhewiofheiowhfioewfhioewfioewhfiowehiofeiofewhiofehwiofewoifhewiofheiwofioewfhiowehfioefhioehfioehfioehiofheiofehwiofhewiofheiofheiofhioehfio";
        byte[][] temp = SplitInfo.splitObjectIntoByteArray(expected);
        byte[] actualArray = SplitInfo.serializeObject(SplitInfo.joinSplitInfo(temp));
        String actual = new String(actualArray, StandardCharsets.UTF_8);
        actual = actual.substring(7);
        assertEquals(expected,actual);
    }
```

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
public boolean executeAutomaticTask() {
        try {
            //Sends response to the client
            byte[] serverResponse = {(byte) 0, (byte) ENTENDIDO, (byte) 0, (byte) 0};
            sOut.write(serverResponse);
            sOut.flush();

            //Recives script
            byte[] dataByteArray = null;
            byte[] dataInfo = sIn.readNBytes(3);
            int code = (dataInfo[1] & 0xff);
            if (code == ENVIO_DADOS)
                dataByteArray = sIn.readNBytes(dataInfo[2] & 0xff);
            else if (code == SEGMENTO) {
                byte[][] splitData = new byte[10][250];
                int index = 0;
                while (code != TERMINO_SEGMENTO) {
                    code = dataInfo[1] & 0xff;
                    splitData[index] = sIn.readNBytes(dataInfo[2] & 0xff);
                    if (code != TERMINO_SEGMENTO)
                        dataInfo = sIn.readNBytes(3);
                    index++;
                }
                dataByteArray = SplitInfo.serializeObject(SplitInfo.joinSplitInfo(splitData));
            }

            if (dataByteArray == null)
                return false;

            String dataString = new String(dataByteArray, StandardCharsets.UTF_8);

            if (code != ENVIO_DADOS)
                dataString = dataString.substring(7);

            String[] data = dataString.split("\\|");
            String email = data[0];
            String scriptName = data[1];
            List<String> answerData = new ArrayList<>();
            List<String> approvalData = new ArrayList<>();

            if (data.length > 2) {
                String answerString = data[2];
                answerData = Arrays.asList(answerString.split(";;;"));
            }

            if (data.length > 3) {
                String approvalString = data[3];
                approvalData = Arrays.asList(approvalString.split(";;;"));
            }

            SFTPClient scriptClient = new SFTPClient();
            File script = scriptClient.getScript(scriptName);
            Calendar calendar = Calendar.getInstance();
            System.out.printf("[%s] - Executing %s ...%n", calendar.getTime(), script.getName());
            Pair<Boolean, String> wasItSuccessfull = null;

            if (Application.settings().getGRAMMARAUTOMATICTYPE().equals("VISITOR"))
                wasItSuccessfull = ExecutorAtividadeAutomatica.parseWithVisitor(email, script.getName(), answerData, approvalData);
            else
                wasItSuccessfull = ExecutorAtividadeAutomatica.parseWithListener(email, script.getName(), answerData, approvalData);

            calendar = Calendar.getInstance();
            if (wasItSuccessfull.a)
                System.out.printf("[%s] - %s executed successfully.%n", calendar.getTime(), scriptName);
            else
                System.out.printf("[%s] - Something went wrong when executing %s: %s%n", calendar.getTime(), scriptName, wasItSuccessfull.b);

            return wasItSuccessfull.a;
        } catch (IOException | JSchException | SftpException ex) {
            System.out.println("An error ocurred");
            //ex.printStackTrace();
            return false;
        }
    }
```

## Split info
Para quando o objeto possuia mais de 255 bytes foram usadas os seguintes metodos

```java
public static <V> byte[][] splitObjectIntoByteArray (V object){
        try{
            byte[] bytes;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(object);
            outputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
            outputStream.close();
            byteArrayOutputStream.close();
            byte[][] returnInfo = new byte[bytes.length/SIZE_LIMIT+1][SIZE_LIMIT];
            int bytesCount = 0;
            for (int i=0;i< returnInfo.length;i++){
                for (int j=0;j<SIZE_LIMIT;j++){
                    if (bytesCount==bytes.length)
                        break;
                    returnInfo[i][j] = bytes[bytesCount];
                    bytesCount++;
                }
            }
            return returnInfo;

        }catch (IOException e){
            e.printStackTrace();
        }
        return new byte[0][0];
    }

    public static Object joinSplitInfo(byte [][]info){
        byte[] arr = new byte[info.length*info[0].length];
        int byteCount = 0;
        for (int i=0;i<info.length;i++){
            for (int j=0;j<info[i].length;j++){
                arr[byteCount] = info[i][j];
                byteCount++;
            }
        }
        try{
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            byteArrayInputStream.close();
            objectInputStream.close();
            return object;

        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;

    }

    public static byte[] serializeObject(Object obj) throws IOException {
        ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bytesOut);
        oos.writeObject(obj);
        oos.flush();
        byte[] bytes = bytesOut.toByteArray();
        bytesOut.close();
        oos.close();
        return bytes;
    }
```


# 5. Integração/Demonstração

Para a implementação desta funcionalidade foi necessário um bocado mais tempo do que o habitual pois é algo novo. Todavia, o trabalho foi sempre bastante fluido. Para efeitos de demonstração, a execução das tarefas automáticas foi apenas simulada. A execução desta funcionalidade é desencandeada pelo motor de fluxos de atividade, onde este exerce o papel de cliente SDP2021.

# 6. Observações

Penso que esta funcionalidade esteja de acordo com os requerimentos do cliente. Os requerimentos foram bastante claros, o que ajudou bastante, pois, sendo esta uma coisa nova, ajuda sempre. Dito isto, penso que esta funcionalidade está de acordo com o pedido, foi usado o protocolo de aplicação fornecido(SPD2021) e é suposrtado o processo simultanio de execuções. Para alem disso, a funcionalidade funciona como esperado com o fluxo de atividades.
