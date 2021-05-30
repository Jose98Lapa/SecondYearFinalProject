# RCOMP - SPRINT D - 1191097 - Tiago Machado

## Dados do Servidor
 - Os dados do servidor, ip e porta utilizada, encontram-se no ficheiro **application.properties** da aplicação **base.app.automatictask.executor**.
 - **IP:** 172.17.0.3
 - **SERVER PORT:** 10030
 
## Protocolo de comunicação de controlo (TCP2021) - v0
<br>

### - Bytes por pacote 

<br>

[ Byte 0 ] : versão do protocolo ( atualmente 0 )

[ Byte 1 ] : código

[ Byte 2 ] : número de bytes transposrtados no campo dados

[ Byte 3 ] : dados (script da atividade automática)

<br>

---
<br>

### - Códigos
<br>
[ 0 ] : Teste -> Pedido de teste, sem qualquer efeito, com devolução de resposta com código 2. Não transporta dados.

[ 1 ] : Fim -> Pedido de fim de ligação. Servidor devolve resposta com código 2, devendo ambas as aplicações fechar a ligação TCP.

[ 2 ] : Entendido -> Não tansporta dados. Acusa receção de pedido. É
enviada em resposta a pedidos com código 0 e código 1.

[ 20 ] : Pedido de execução -> Pedido de execução de um script de uma atividade automática.

[ 21 ] : Envio dos dados (script) -> Transporte dos dados do script quando este não tem um tamanho superior a 255.

[ 22 ] : Execução concluida ->  Feedback ao cliente para que este saiba que o script foi executado com sucesso. Não tansporta dados. 

[ 253 ] : Erro -> Servidor devolve quando se dá um erro no pedido. Não tansporta dados.

[ 254 ] : Término segmento -> Representa o conjunto de dados final de um segmento.

[ 255 ] : Segmento -> Identifica os dados transportados como sendo parte de um conjunto de dados mais extenso.

---
<br>


## Executado

### - 1191097

Cliente TCP presente no <b>Motor de Fluxos de Atividades</b> que comunica com o Servidor TCP presente no <b>Executor de Tarefas Automáticas</b>.
Cada conexão nova que seja necessário de estabelecer, será criada em uma Thread nova. 

**Fluxo:**
Será necessário que o client envie primeiro um pedido de execução [20], onde o server irá responder com um entendido [2]. De seguida, será necessário que o cliente envie os dados necessários para a execução da tarefa automática, estes serão enviados com codigo [21] se os dados forem mais pequenos 255 bytes, se não, os dados serão divididos e enviados com codigo [255] e [254], sendo o ultimo pacote enviado com o codigo [254]. Se a execução se der com sucesso é enviada ao cliente por parte do servidor uma mensagem com o codigo [22], se esta der erro na execução será enviada uma mensagem com o codigo [253]. Por fim é enviada uma mensagem ao server com codigo [1], este depois manda ao cliente uma mensagem com codigo [2] e a ligação chega ao fim.
