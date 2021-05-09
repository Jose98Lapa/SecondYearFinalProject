# UC 2001 - Criar catálogo de serviços
=======================================


# 1. Requisitos

**UC 2001:**  Como Gestor de Serviços de Help desk (GSH), eu pretendo criar um novo catálogo de serviços.

Critérios de Aceitação / Observações :

- Inclui indicar o colaborador responsável.

- Inclui indicar os colaboradores a quem o serviço fica disponível: uma ou mais equipas.

Informação adicional que obtive do cliente:

- [Identificador sequencial e gerado automaticamente.](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7400)

- [Definir um ou mais colaboradores responsaveis pelo serviço.](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7019)
  - [Com atribuição através de uma pesquisa](https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=7623)


# 2. Análise

Para análise o modelo de domínio dá resposta ao requisito, não sendo assim necessário estender o mesmo. [Verificar modelo de domínio]([mdURL](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Modelo%20de%20Dominio.svg))

# 3. Design

*Nesta secção a equipa deve descrever o design adotado para satisfazer a funcionalidade. Entre outros, a equipa deve apresentar diagrama(s) de realização da funcionalidade, diagrama(s) de classes, identificação de padrões aplicados e quais foram os principais testes especificados para validar a funcionalidade.*


*Para além das secções sugeridas, podem ser incluídas outras.*

## 3.1. Realização da Funcionalidade

### Criar Catalogo
![UC_2001_SD](UC_2001_EspecificarCatálogoServiço_SD.svg)

#### ListEquipaService_SD
![ListEquipaService_SD](ListEquipaService_SD.svg)

#### ListColaboradorService_SD
![ListColaboradorService_SD](ListColaboradorService_SD.svg)

#### ListCriticidadeService_SD
![ListCriticidadeService_SD](ListCriticidadeService_SD.svg)

## 3.2. Diagrama de Classes

*Nesta secção deve apresentar e descrever as principais classes envolvidas na realização da funcionalidade.*

## 3.3. Padrões Aplicados

* Pardrão Builder - Para evitar diferentes construtores para diferentes situações e para possibilitar a criação do catalogo por etapas foi usado o padrão Builder.
* Pardrão Factory - e modo a simplificar a a manipulação de diferentes repositorios foi utilizado o padrão Factory.
* Pardrão DTO - de modo a passar informação da camada de dominio para a camada de apresentação foi utilizado o padrão DTO, isolando assim o modelo de dominio da apresentação.

## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

### TituloTest
**Teste 1:** Verificar que um titulo pode conter pontuação.

	@Test
    public void ensureTitleCanHavePontuation() {
        System.out.println("Title can have pontuation");
        Titulo result = new Titulo("É um bom titulo!");
        String expected = "É um bom titulo!";
        assertEquals(result.toString(),expected);
    }

**Teste 2:** Verificar que um titulo pode conter acentos.

    @Test
    public void ensureTitleCanHaveAccent() {
        System.out.println("Title can have accents");
        Titulo result = new Titulo("É um bom titulo");
        String expected = "É um bom titulo";
        assertEquals(result.toString(),expected);
    }

**Teste 3:** Verificar que um titulo não pode ser muito extenso.

    @Test
    public void ensureTitleCannotBeToLong() {
        System.out.println("Title can not be too long");
        assertThrows(IllegalArgumentException.class,() -> new Titulo("Este titulo é demasiado grande"));
    }	

**Teste 4:** Verificar que um titulo pode ser vazio.

    @Test
    public void ensureTitleCannotBeEmpty() {
        System.out.println("Title can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new Titulo(" "));
    }

**Teste 5:** Verificar que um titulo não pode ser nulo.

    @Test
    public void ensureTitleCannotBeNull() {
        System.out.println("Title can not be null");
        assertThrows(IllegalArgumentException.class,() -> new Titulo(null));
    }

### DescricaoBreveTest
**Teste 1:** Verificar que  uma descrição breve não pode ser muito extensa.

    @Test
    public void ensureDescriptionCannotBeToLong() {
        System.out.println("Brief description can not be too long");
        assertThrows(IllegalArgumentException.class,() -> new DescricaoBreve("Esta descrição breve é um bocado longa demais, pois se alguem se alongar demasiado numa descrição" +
                "breve, ela deixa de ser breve"));
    }

**Teste 2:** Verificar que  uma descrição breve não pode ser vazia.

    @Test
    public void ensureDescriptionCannotBeEmpty() {
        System.out.println("Brief bescription can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new DescricaoBreve(" "));
    }

**Teste 3:** Verificar que  uma descrição breve não pode ser nula.

    @Test
    public void ensureDescriptionCannotBeNull() {
        System.out.println("Brief description can not be null");
        assertThrows(IllegalArgumentException.class,() -> new DescricaoBreve(null));
    }	

### DescricaoCompletaTest
**Teste 1:** Verificar que  uma descrição completa não pode ser vazia.

    @Test
    public void ensureDescriptionCannotBeEmpty() {
        System.out.println("Complete description can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new DescricaoCompleta(" "));
    }


**Teste 1:** Verificar que  uma descrição completa não pode ser nula.

    @Test
    public void ensureDescriptionCannotBeNull() {
        System.out.println("Complete description can not be null");
        assertThrows(IllegalArgumentException.class,() -> new DescricaoCompleta(null));
    }

### IconTest
**Teste 1:** Verificar que o path de um icon não pode ser vazia.

    @Test
    public void ensureIconCannotBeEmpty() {
        System.out.println("Icon can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new Icon(" "));
    }


**Teste 2:** Verificar que o path de um icon não pode ser nula.

    @Test
    public void ensureIconCannotBeNull() {
        System.out.println("Icon can not be null");
        assertThrows(IllegalArgumentException.class,() -> new Icon(null));
    }	

### CatalogoTest
**Teste 1:** Verificar que a lista de criterios de acesso não pode ser vazia, e consequentemente a lista de colaboradores responsaveis.

    @Test
    public void ensureCatalogCriteriaAccessIsNotNull() {
        final Set<Colaborador> responsableCollabs = new HashSet<>();
        responsableCollabs.add(null); //add colaborador
        assertThrows(IllegalArgumentException.class,() -> new Catalogo(new Titulo("Titulo"), new Icon("C:/icon.png"),new DescricaoBreve("descição")
        , new DescricaoCompleta("descição completa"), responsableCollabs ,null, null));
    }


**Teste 2:** Verificar que a lista de criterios de acesso não pode ser nula, e consequentemente a lista de colaboradores responsaveis.

    @Test
    public void ensureCatalogCriteriaAccessIsNotEmpty() {
        final Set<Colaborador> responsableCollabs = new HashSet<>();
        responsableCollabs.add(null); //add colaborador
        final Set<Equipa> accessCriteria = new HashSet<>();
        assertThrows(IllegalArgumentException.class,() -> new Catalogo(new Titulo("Titulo"), new Icon("C:/icon.png"),new DescricaoBreve("descição")
                , new DescricaoCompleta("descição completa"), responsableCollabs ,accessCriteria, null));
    }

# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



