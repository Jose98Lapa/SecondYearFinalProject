# Technical details

## 1 Virtual Servers ( DEI Containers)
<br>

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
<br>
<br>
Utilizaçao de servidores:

server0 -» 192.168.1.92  -» Maquina linux - responsável por armazenar os ficheiros (sftp) e ser host dos restantes servers.

server workflow -» 172.17.0.2 -» docker container - responsável pelo servidor do Motor de Fluxos

server executor -» 172.17.0.3 -» docker container - responsável pelo servidor do Executor de Tarefas Automáticas

Base de Dados - » cloud isep 

Nota: os servidores, excepto o da base de dados, foram implementados pelo grupo e por isso nao utilizam a rede do isep. A equipa utilizou um servidor OpenVpn para trabalhar remotamente.

***


Portas Utilizadas:



***
Codigos para transação de dados segundo o SDP 2021




