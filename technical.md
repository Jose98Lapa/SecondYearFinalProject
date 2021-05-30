# Technical details

## 1 Virtual Servers ( DEI Containers)

***
### H2 Database
***
Docker container running H2.

 - IPv4: 10.9.20.221
 - Port: 10221
 - IPv6: fd1e:2bae:c6fd:1009:14dd
 - DNS domain: dei.isep.ipp.pt
***
Public database URL:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; jdbc:h2:tcp://vsgate-s2.dei.isep.ipp.pt:10221/dados 
***
Utilizaçao de servidores:

server0 -» 192.168.1.92  -» Maquina linux - responsável por armazenar os ficheiros (sftp) e ser host dos restantes servers.

server workflow -» 172.17.0.2 -» docker container - responsável pelo servidor do Motor de Fluxos

server executor -» 172.17.0.3 -» docker container - responsável pelo servidor do Executor de Tarefas Automáticas

Base de Dados - » cloud isep 

Nota: os servidores, excepto o da base de dados, foram implementados pelo grupo e por isso nao utilizam a rede do isep. A equipa utilizou um servidor OpenVpn para trabalhar remotamente.

***

Portas Utilizadas:
server0 -» 55128
server workflow -» 10020
server executor -» 10030


***
Codigos para transação de dados segundo o SDP 2021
[ 0 ] : Teste -> Pedido de teste, sem qualquer efeito, com devolução de resposta com código 2. Não transporta dados.

[ 1 ] : Fim -> Pedido de fim de ligação. Servidor devolve resposta com código 2, devendo ambas as aplicações fechar a ligação TCP.

[ 2 ] : Entendido -> Não tansporta dados. Acusa receção de pedido. É
enviada em resposta a pedidos com código 0 e código 1.

[ 3 ] : Pedido para obter Lista de Tarefas do colaborador a fazer o pedido com devolução de resposta com código 2.

[ 20 ] : Pedido de execução -> Pedido de execução de um script de uma atividade automática.

[ 21 ] : Envio dos dados (script) -> Transporte dos dados do script quando este não tem um tamanho superior a 255.

[ 22 ] : Execução concluida ->  Feedback ao cliente para que este saiba que o script foi executado com sucesso. Não tansporta dados. 

[ 253 ] : Erro -> Servidor devolve quando se dá um erro no pedido. Não tansporta dados.

[ 254 ] : Término segmento -> Representa o conjunto de dados final de um segmento.

[ 255 ] : Segmento -> Identifica os dados transportados como sendo parte de um conjunto de dados mais extenso.



