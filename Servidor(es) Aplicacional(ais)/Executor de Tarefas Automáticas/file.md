# RCOMP - SPRINT D - 1191097 - Tiago Machado
 
## Protocolo de comunicação de controlo (TCP2021) - v0
<br>

### - Bytes por pacote 

<br>

[ Byte 0 ] : versão do protocolo ( atualmente 0 )

[ Byte 1 ] : código

[ Byte 2 ] : número de bytes transposrtados no campo dados

[ Byte 3 ] : dados

<br>

---
<br>

### - Códigos
<br>
[ 0 ] : Teste -> Pedido de teste com devolução de resposta com código 2. Não transporta dados.

[ 1 ] : Fim -> Pedido de fim de ligação. Servidor devolve resposta com código 2, devendo ambas as aplicações fechar a ligação TCP.

[ 2 ] : Entendido -> Não tansporta dados. Acusa receção de pedido. É
enviada em resposta a pedidos com código 0 e código 1

[ 20 ] : Pedido de execução -> Transporta Acusa receção de pedido.

[ 21 ] : Execução concluida -> Não tansporta dados. 

[ 253 ] : Erro -> Servidor devolve quando se dá um erro no pedido. Não tansporta dados.

[ 254 ] : Término segmento -> Representa o conjunto de dados final de um segmento.

[ 255 ] : Segmento -> Identifica os dados transportados como sendo parte de um conjunto de dados mais extenso.

---
<br>


## Executado

### - 1191097

Cliente TCP presente no <b>Motor de Fluxos de Atividades</b> que comunica com o Servidor TCP presente no <b>Executor de Tarefas Automáticas</b>.
Cada conexão nova que seja necessário de estabelecer, será criada em uma Thread nova.