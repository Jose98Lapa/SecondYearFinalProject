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

***
### Workflow engine
***
Docker container running the LAMP stack on Ubuntu 20.04LTS.

 - IPv4: 10.9.21.27
 - Port: 10283
 - IPv6: fd1e:2bae:c6fd:1009::151b
 - DNS domain: dei.isep.ipp.pt
***
SSH credentials
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
root@dei.isep.ipp.pt
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
123Tiago123
***
<br>
<br>

***
### Automatic Task Runner
***
Docker container running the LAMP stack on Ubuntu 20.04LTS.

 - IPv4: 10.9.21.17
 - Port: 10273
 - IPv6: fd1e:2bae:c6fd:1009:1511
 - DNS domain: dei.isep.ipp.pt
***
SSH credentials
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
root@dei.isep.ipp.pt 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
123Tiago123
***