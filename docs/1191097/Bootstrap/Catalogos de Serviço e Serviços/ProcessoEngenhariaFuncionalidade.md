# UC 2101 - Informação relativa ao catálogo de serviços e serviços (Bootstrap)
=======================================


# 1. Requisitos

Como Gestor de Projeto, eu pretendo que, para efeitos de demonstração, o sistema contemple a possibilidade de ser inicializado (bootstrap) com alguma informação relativa ao catálogo de serviços e serviços.

# 2. Análise

Para o bootstrap dos catalogos e dos serviços foi necessário trabalhar em sincronismo com o bootraper da estrutura organica da organização. Isto porque para a criação de um catalogo é necessário que haja equipas, colaboradores e criticidades em sistema. Para este bootstrap o catalogo é criado antes do serviço, pois um serviço referencia um catalogo a que está inserido.

#### Tabela Catalogo
![tabelaCatalogo](tabelaCatalogo.png)

#### Tabela Serviço
![tabelaServico](tabelaServico.png)

# 3. Implementação

Para facilitar a futura alteração do bootstrap optamos por concentrar toda a informação num ficheiro XML, o que poderá também simplificar futuras integraçoes. Foram utilizados os controllers de outras user stories

```xml
<?xml version="1.0"?>
<class>
    <!--
    Servico 1
-->
    <class1>
        <catalogue>
            <criteriosdeAcesso>1</criteriosdeAcesso>
            <responsaveis>1</responsaveis>
            <iconCatalogo>https://192.168.1.92/bootstrap.jpg</iconCatalogo>
            <tituloCatalogoC>Pedidos Recursos Humanos</tituloCatalogoC>
            <descricaoBreveC>Aqui encontra todos os pedidos relativos a RH</descricaoBreveC>
            <descricaoCompletaC>Aqui encontra todos os pedidos relativos a Recursos Humanos</descricaoCompletaC>
            <criticality>2</criticality>
        </catalogue>

        <Servico>
            <Formulario>
                <fId>1</fId>
                <fnome>Formulario Servico de pedir ausencia</fnome>
                <fscript>https://192.168.1.92/bootstrapForm.txt</fscript>
                <atributes>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Data de Inicio</Adescricao>
                        <Atipo>Date</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>dataInicio</Anome>
                        <aID>1</aID>
                        <aNumber>1</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Data de FIm</Adescricao>
                        <Atipo>Date</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>dataFim</Anome>
                        <aID>2</aID>
                        <aNumber>2</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Qual o tipo de Ausencia</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>tipoAusencia</Anome>
                        <aID>3</aID>
                        <aNumber>3</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Qual a Justificacao</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>justificacao</Anome>
                        <aID>4</aID>
                        <aNumber>4</aNumber>
                    </SAtributo>
                </atributes>
            </Formulario>
            <descricaoBreve>Pedido de Ausencia Futura</descricaoBreve>
            <descricaoCompleta>Pedido de Ausencia Futura para todos os colaboradores</descricaoCompleta>
            <ServicoID>1</ServicoID>
            <keyWords>ausencia</keyWords>
            <statusServico>ATIVO</statusServico>
            <iconServico>https://192.168.1.92/bootstrap.jpg</iconServico>
            <tituloServico>Pedido de Ausencia Futura</tituloServico>
            <catalogoS>1</catalogoS>
        </Servico>

        <Workflow>
            <Wtipo>M</Wtipo>
            <Waprov>S</Waprov>
            <Wservice>1</Wservice>
            <Wscript>1</Wscript>  <!--script atv automatica-->
            <Wfunc>1</Wfunc>

            <WAfId>200</WAfId> <!--aprovacao-->
            <WAfnome>Formulario Aprovacao</WAfnome>
            <WAfscript>https://192.168.1.92/bootstrapFormAprov1.txt</WAfscript>

            <WMfId>201</WMfId> <!--atividade manual-->
            <WMfnome>Formulario Resolucao</WMfnome>
            <WMfscript>https://192.168.1.92/bootstrapAtManual.txt</WMfscript>

            <atributes>
                <WAtributo>
                    <WAtributeForm>Aprov</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Texto de fundamentacao</WAdescricao>
                    <WAtipo>String</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>fundamentacao</WAnome>
                    <WaID>5</WaID>
                    <WaNumber>1</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Dias de ferias ja gozados no ano</WAdescricao>
                    <WAtipo>int</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>feriasGozadasAno</WAnome>
                    <WaID>6</WaID>
                    <WaNumber>2</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Dias de ferias gozados do periodo solicitado</WAdescricao>
                    <WAtipo>int</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>feriasGozadasPeriodo</WAnome>
                    <WaID>7</WaID>
                    <WaNumber>3</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Dias de ferias totais</WAdescricao>
                    <WAtipo>int</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>feriasTotais</WAnome>
                    <WaID>8</WaID>
                    <WaNumber>4</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Dias de falta justificadas ja ocorridas no ano</WAdescricao>
                    <WAtipo>int</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>faltasJustAno</WAnome>
                    <WaID>9</WaID>
                    <WaNumber>5</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Dias de faltas justificadas do periodo solicitado</WAdescricao>
                    <WAtipo>int</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>faltasJustPeriodo</WAnome>
                    <WaID>10</WaID>
                    <WaNumber>6</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Dias de faltas justificadas totais</WAdescricao>
                    <WAtipo>int</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>faltasJustTotal</WAnome>
                    <WaID>11</WaID>
                    <WaNumber>7</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Dias de falta nao justificadas ja ocorridas no ano</WAdescricao>
                    <WAtipo>int</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>faltasAno</WAnome>
                    <WaID>12</WaID>
                    <WaNumber>8</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Dias de faltas nao justificadas do periodo solicitado</WAdescricao>
                    <WAtipo>int</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>faltasNJustPeriodo</WAnome>
                    <WaID>13</WaID>
                    <WaNumber>9</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Dias de faltas nao justificadas totais</WAdescricao>
                    <WAtipo>int</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>faltasNJustTotal</WAnome>
                    <WaID>14</WaID>
                    <WaNumber>10</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Comentario</WAdescricao>
                    <WAtipo>String</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>comentario</WAnome>
                    <WaID>15</WaID>
                    <WaNumber>11</WaNumber>
                </WAtributo>
            </atributes>
        </Workflow>
    </class1>

    <!--
        Servico 2
    -->
    <class1>
<!--
        <catalogue>
            <criteriosdeAcesso>1</criteriosdeAcesso>
            <responsaveis>1</responsaveis>
            <iconCatalogo>https://192.168.1.92/bootstrap.jpg</iconCatalogo>
            <tituloCatalogoC>Pedidos Recursos Humanos</tituloCatalogoC>
            <descricaoBreveC>Aqui encontra todos os pedidos relativos a RH</descricaoBreveC>
            <descricaoCompletaC>Aqui encontra todos os pedidos relativos a Recursos Humanos</descricaoCompletaC>
            <criticality>2</criticality>
        </catalogue>
-->

        <Servico>
            <Formulario>
                <fId>2</fId>
                <fnome>Autorizacao para Aplicacao de Desconto</fnome>
                <fscript>https://192.168.1.92/bootstrapForm2.txt</fscript>
                <atributes>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Codigo de Cliente</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>codCliente</Anome>
                        <aID>16</aID>
                        <aNumber>1</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Nome</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>nomeCliente</Anome>
                        <aID>17</aID>
                        <aNumber>2</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Tipo de Desconto</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>tipoDesconto</Anome>
                        <aID>18</aID>
                        <aNumber>3</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Recorrencia</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>recorrencia</Anome>
                        <aID>19</aID>
                        <aNumber>4</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Percentagem de Desconto</Adescricao>
                        <Atipo>double</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>percentagemDesconto</Anome>
                        <aID>20</aID>
                        <aNumber>5</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Valor de Desconto</Adescricao>
                        <Atipo>double</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>valorDesconto</Anome>
                        <aID>21</aID>
                        <aNumber>6</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Identificacao da Fatura</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>codFatura</Anome>
                        <aID>22</aID>
                        <aNumber>7</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Data Limite</Adescricao>
                        <Atipo>Date</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>dataLimite</Anome>
                        <aID>23</aID>
                        <aNumber>8</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Fundamentacao Do Pedido</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>fundamentacao</Anome>
                        <aID>24</aID>
                        <aNumber>9</aNumber>
                    </SAtributo>
                </atributes>
            </Formulario>
            <descricaoBreve>Autorizacao para Aplicacao de Desconto</descricaoBreve>
            <descricaoCompleta>Autorizacao para Aplicacao de Desconto</descricaoCompleta>
            <ServicoID>2</ServicoID>
            <keyWords>desconto</keyWords>
            <statusServico>ATIVO</statusServico>
            <iconServico>https://192.168.1.92/bootstrap.jpg</iconServico>
            <tituloServico>Autorizacao para Aplicacao de Desconto</tituloServico>
            <catalogoS>1</catalogoS>
        </Servico>

        <Workflow>
            <Wtipo>A</Wtipo>
            <Waprov>S</Waprov>
            <Wservice>2</Wservice>
            <Wscript>https://192.168.1.92/bootstrapFormAut1.txt</Wscript>
            <Wfunc>1</Wfunc>

            <WAfId>202</WAfId>
            <WAfnome>Formulario Aprovacao</WAfnome>
            <WAfscript>https://192.168.1.92/bootstrapFormAprov2.txt</WAfscript>

            <WMfId>203</WMfId>
            <WMfnome>Formulario Resolucao</WMfnome>
            <WMfscript>https://192.168.1.92/bootstrapAtManual.txt</WMfscript>

            <atributes>
                <WAtributo>
                    <WAtributeForm>Aprov</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Decisao</WAdescricao>
                    <WAtipo>String</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>decisao</WAnome>
                    <WaID>25</WaID>
                    <WaNumber>1</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Aprov</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>texto fundamentando a decisao</WAdescricao>
                    <WAtipo>String</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>fundamentacao</WAnome>
                    <WaID>26</WaID>
                    <WaNumber>2</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Aprov</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Percentagem</WAdescricao>
                    <WAtipo>double</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>percentagem</WAnome>
                    <WaID>27</WaID>
                    <WaNumber>3</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Aprov</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Valor</WAdescricao>
                    <WAtipo>String</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>valor</WAnome>
                    <WaID>28</WaID>
                    <WaNumber>4</WaNumber>
                </WAtributo>
                <WAtributo>
                    <WAtributeForm>Aprov</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Data Limite</WAdescricao>
                    <WAtipo>Date</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>dataLimite</WAnome>
                    <WaID>29</WaID>
                    <WaNumber>5</WaNumber>
                </WAtributo>
            </atributes>
        </Workflow>
    </class1>

    <!--
       Servico 3
   -->

    <class1>
        <!--<catalogue>
            <criteriosdeAcesso>1</criteriosdeAcesso>
            <responsaveis>1</responsaveis>
            <iconCatalogo>https://192.168.1.92/bootstrap.jpg</iconCatalogo>
            <tituloCatalogoC>Pedidos Recursos Humanos</tituloCatalogoC>
            <descricaoBreveC>Aqui encontra todos os pedidos relativos a RH</descricaoBreveC>
            <descricaoCompletaC>Aqui encontra todos os pedidos relativos a Recursos Humanos</descricaoCompletaC>
            <criticality>2</criticality>
        </catalogue>
-->
        <Servico>
            <Formulario>
                <fId>4</fId>
                <fnome>Alteracao de residencia</fnome>
                <fscript>https://192.168.1.92/bootstrapForm3.txt</fscript>
                <atributes>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Codigo posta (xxxx-xxx)</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>codigopostal</Anome>
                        <aID>30</aID>
                        <aNumber>1</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Rua</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>rua</Anome>
                        <aID>31</aID>
                        <aNumber>2</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Cidade</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>cidade</Anome>
                        <aID>32</aID>
                        <aNumber>3</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Distrito</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>distrito</Anome>
                        <aID>33</aID>
                        <aNumber>4</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Numero da Porta</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>porta</Anome>
                        <aID>34</aID>
                        <aNumber>5</aNumber>
                    </SAtributo>
                </atributes>
            </Formulario>
            <descricaoBreve>Comunicacao para alteracao de residencia</descricaoBreve>
            <descricaoCompleta>Comunicacao para alteracao de residencia</descricaoCompleta>
            <ServicoID>3</ServicoID>
            <keyWords>residencia</keyWords>
            <statusServico>ATIVO</statusServico>
            <iconServico>https://192.168.1.92/bootstrap.jpg</iconServico>
            <tituloServico>Comunicacao para alteracao de residencia</tituloServico>
            <catalogoS>1</catalogoS>
        </Servico>

        <Workflow>
            <Wtipo>M</Wtipo>
            <Waprov>N</Waprov>
            <Wservice>3</Wservice>
            <Wscript>https://192.168.1.92/bootstrapFormAut2.txt</Wscript>
            <Wfunc>1</Wfunc>

            <WAfId>207</WAfId>
            <WAfnome>Formulario Aprovacao</WAfnome>
            <WAfscript>https://192.168.1.92/bootstrapFormAprov2.txt</WAfscript>

            <WMfId>207</WMfId>
            <WMfnome>Formulario Resolucao</WMfnome>
            <WMfscript>https://192.168.1.92/bootstrapAtManual3.txt</WMfscript>

            <atributes>
                <WAtributo>
                    <WAtributeForm>Exec</WAtributeForm>
                    <WAlabel>ignored</WAlabel>
                    <WAdescricao>Observacoes</WAdescricao>
                    <WAtipo>String</WAtipo>
                    <WAregex>ignored</WAregex>
                    <WAnome>observacoes</WAnome>
                    <WaID>35</WaID>
                    <WaNumber>1</WaNumber>
                </WAtributo>
            </atributes>
        </Workflow>
    </class1>

    <!--
       Servico 4
   -->

    <class1>
        <!--<catalogue>
            <criteriosdeAcesso>1</criteriosdeAcesso>
            <responsaveis>1</responsaveis>
            <iconCatalogo>https://192.168.1.92/bootstrap.jpg</iconCatalogo>
            <tituloCatalogoC>Pedidos Recursos Humanos</tituloCatalogoC>
            <descricaoBreveC>Aqui encontra todos os pedidos relativos a RH</descricaoBreveC>
            <descricaoCompletaC>Aqui encontra todos os pedidos relativos a Recursos Humanos</descricaoCompletaC>
            <criticality>2</criticality>
        </catalogue>
-->
        <Servico>
            <Formulario>
                <fId>3</fId>
                <fnome>Cotacao para venda</fnome>
                <fscript>https://192.168.1.92/bootstrapForm4.txt</fscript>
                <atributes>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Codigo do produto</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>codProd</Anome>
                        <aID>36</aID>
                        <aNumber>1</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Quantidade pretendida</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>quantidade</Anome>
                        <aID>37</aID>
                        <aNumber>2</aNumber>
                    </SAtributo>
                    <SAtributo>
                        <Alabel>Opcao</Alabel>
                        <Adescricao>Tipo de Cliente</Adescricao>
                        <Atipo>String</Atipo>
                        <Aregex>ignored</Aregex>
                        <Anome>codProd</Anome>
                        <aID>38</aID>
                        <aNumber>3</aNumber>
                    </SAtributo>
                </atributes>
            </Formulario>
            <descricaoBreve>Cotacao para venda</descricaoBreve>
            <descricaoCompleta>Cotacao para venda</descricaoCompleta>
            <ServicoID>4</ServicoID>
            <keyWords>cotacao</keyWords>
            <statusServico>ATIVO</statusServico>
            <iconServico>https://192.168.1.92/bootstrap.jpg</iconServico>
            <tituloServico>Cotacao para venda</tituloServico>
            <catalogoS>1</catalogoS>
        </Servico>

        <Workflow>
            <Wtipo>A</Wtipo>
            <Waprov>N</Waprov>
            <Wservice>3</Wservice>
            <Wscript>https://192.168.1.92/bootstrapFormAut4.txt</Wscript>
            <Wfunc>1</Wfunc>

            <WAfId>206</WAfId>
            <WAfnome>Formulario Aprovacao</WAfnome>
            <WAfscript>https://192.168.1.92/bootstrapFormAprov2.txt</WAfscript>

            <WMfId>206</WMfId>
            <WMfnome>Formulario Resolucao</WMfnome>
            <WMfscript>https://192.168.1.92/bootstrapAtManual3.txt</WMfscript>
        </Workflow>
    </class1>
</class>


```

# 3. Integração/Demonstração

Para esta use case precisei de esperar pela equipa até que todos os seviços e catalogos fossem devidamente implementados, e consequentemente, as equipas, criticidades e colaboradores. Porem, com o auxilio do xml, que demonstrou-se bastante flexivel, a funcionalidade foi sendo implementada á medida que as outras use cases iam sendo finalizadas.

# 4. Observações

Para esta funcionalidade foi necessário trabalhar em sincronização com o meu colega que estava a desenvolver o bootstrap relativo à estrutura orgânica da organização. Isto porque na criação de um calaogo, por exemplo, são necessárias equipas e colaboradores já em sistema. Infelizmente, não foi possivel criar mais catalogos e serviços pois, de vez em quando, na criação dos varios, a base de dados ficava sobrecarregada:  ```HibernateException : The internal connection pool has reached its maximum size and no connection is currently available```

No Sprint D, conseguimos aumentar a connection pool conseguindo assim criar 4 serviços e 3 catalogos de serviço.



