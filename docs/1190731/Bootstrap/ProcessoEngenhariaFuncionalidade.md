# UC 2013 - informação relativa à estrutura orgânica da organização (Bootstrap)
=======================================


# 1. Requisitos

Como Gestor de Projeto, eu pretendo que, para efeitos de demonstração, o sistema contemple a possibilidade de ser inicializado (bootstrap) com alguma informação relativa à estrutura orgânica da organização.


# 2. Implementação

Para facilitar a futura alteração do bootstrap optamos por concentrar toda a informação num ficheiro XML, o que poderá também simplificar futuras integraçoes.
```
<?xml version="1.0"?>
<class>
    <colaborador>
        <funcao>
            <designacao>Gestor</designacao>
            <idFunc>5</idFunc>
        </funcao>
        <morada>
            <rua>Rua das Formigas</rua>
            <numPorta>45</numPorta>
            <andar>1</andar>
            <localizacao>Porto</localizacao>
        </morada>
        <numeroMecanografico>119654</numeroMecanografico>
        <datanascimento>05/06/1998</datanascimento>
        <contacto>913586789</contacto>
        <nomeCompleto>Rodrigo Alberto Figueira</nomeCompleto>
        <emailInstitucional>raf@isep.ipp.pt</emailInstitucional>
        <alcunha>RAF</alcunha>
        <codPostal>4523-885</codPostal>
        <SUPERVISOR>
            <funcao>
                <Superdesignacao>Administrador</Superdesignacao>
                <SuperidFunc>6</SuperidFunc>
            </funcao>
            <morada>
                <srua>Rua das Formigas</srua>
                <snumPorta>45</snumPorta>
                <sandar>1</sandar>
                <slocalizacao>Porto</slocalizacao>
            </morada>
            <snumeroMecanografico>119643</snumeroMecanografico>
            <sdataDeNascimento>05/06/1998</sdataDeNascimento>
            <scontacto>913586789</scontacto>
            <snomeCompleto>Joao Alberto Santos</snomeCompleto>
            <semailInstitucional>raf@isep.ipp.pt</semailInstitucional>
            <salcunha>RAF</salcunha>
            <scodPostal>4523-885</scodPostal>
        </SUPERVISOR>
    </colaborador>

    <equipa>
        <tipoEquipa>
            <descricao>Forte</descricao>
            <tipoEquipaID>123</tipoEquipaID>
        </tipoEquipa>
        <equipaId>123</equipaId>
        <acronimo>EF</acronimo>
        <TEdesignacao>So os mais fortes</TEdesignacao>
        <cor>
        <hexadecimal>0000FF</hexadecimal>
        <nome>Azul</nome>
        </cor>
    </equipa>

    <criticidade>
            <labelCriti>medio</labelCriti>
            <valorCriticidade>4</valorCriticidade>
        <tempoMaximoA>30</tempoMaximoA>
        <tempoMedioA>20</tempoMedioA>
        <tempoMaximoR>240</tempoMaximoR>
        <tempoMedioR>150</tempoMedioR>
    </criticidade>
</class>
```

# 3. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 4. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



