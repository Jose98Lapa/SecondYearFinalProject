RCOMP 2019-2020 Project - Sprint 5 planning
===========================================
### Sprint master: 1191097 ###
# 1. Sprint's backlog #

|User Story |User story description|
|--------|--------|
|US5002| Proteger comunicações realizadas através do protocolo SDP2021 (Executor de atividades automaticas).|
|US3101| Proteger comunicações realizadas através do protocolo SDP2021 (Portal).| ![Documentação](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/docs/1190731/)
|US4051| Proteger comunicações realizadas como aplicação servidora através do protocolo SDP2021 (Fluxo de Atividades).|
|US2102| Proteger comunicações realizadas através do protocolo SDP2021 (Serviços HR).| ![Documentação] (https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/docs/1190641/US2102%20-%20Proteger%20comunica%C3%A7%C3%B5es%20realizadas%20atrav%C3%A9s%20do%20protocolo%20SDP2021/Dashboard.md)
|US4052| Proteger comunicações realizadas como aplicação cliente através do protocolo SDP2021 (Fluxo de Atividades).|

Para este sprint é necessário aplicar SSL/TLS com autenticação mútua baseada em certificados de chave pública.


# 2. Technical decisions and coordination #

Decidimos não usar os servidores do isep, pois possuia varias instabilidades. Optamos então por criar os nossos proprios servidores. [Mais informações](technical.md)

Usamos um certificado de chave pública SSL/TLS v1.3 com a cyphersuite TLS_AES_256_GCM_SHA384. É possivel encontrar tanto o ficheiro .cer como o .keystore na root do projeto.