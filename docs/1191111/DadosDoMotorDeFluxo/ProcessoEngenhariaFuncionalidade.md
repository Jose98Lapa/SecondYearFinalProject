# RCOMP - SPRINT D - 1191111 - Tomás Floress
 
## Protocolo de Comunicação - v0
<br>

### - Bytes por pacote 

<br>

[ Byte 0 ] : versão do protocolo ( atualmente 0 )

[ Byte 1 ] : código

[ Byte 2 ] : número de dados

[ Byte 3 - 255 ] : dados

<br>

---
<br>

### - Códigos
<br>
[ 0 ] : Teste -> Pedido de teste com devolução de resposta com código 2. Não transporta dados.

[ 1 ] : Fim -> Pedido de fim de ligação. Servidor devolve resposta com código 2.

[ 2 ] : Entendido. Resposta sem dados. Acusa receção de pedido.

[ 3 ] : Pedido para obter Lista de Tarefas do colaborador a fazer o pedido com devolução de resposta com código 2.

[ 253 ] : Erro -> Resposta de erro por parte do servidor, caso surja um erro ou uma inconsistencia na comunicação com a base de dados.

[ 254 ] : Término segmento -> Representa o conjunto de dados final de um segmento.

[ 255 ] : Segmento -> Identifica os dados transportados como sendo parte de um conjunto de dados mais extenso.

---
<br>


## Executado

### - 119111

Cliente TCP e Servidor TCP presententes no <b>Motor de Fluxos de Atividades</b> que comunicam entre eles.
Cada conexão nova que seja necessário de estabelecer, será criada em uma Thread nova.