# UC 3022 - Reivindicar Tarefa
=======================================


# 1. Requisitos

**UC 3022:**  Como utilizador, eu pretendo consultar as tarefas pendentes que eu posso reivindicar para mim e, caso o deseje, concretize essa reivindicação.


# 2. Análise

Para análise o modelo de domínio dá resposta ao requisito, não sendo assim necessário estender o mesmo. [Verificar modelo de domínio](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Modelo%20de%20Dominio.svg)

# 3. Design

## 3.1. Realização da Funcionalidade

### Especificar Colaborador

## 3.2. Diagrama de Classes
![UC_3022_SD](UC_3022_ReivindicarTarefa_SD.svg)

## 3.3. Padrões Aplicados

* Pardrão DTO - de modo a passar informação da camada de dominio para a camada de apresentação foi utilizado o padrão DTO, isolando assim o modelo de dominio da apresentação.


# 4. Implementação

### Colaborador DTO

	@DTO
	public class TicketDTO {

	public String solicitedOn;
	public String deadLine;
	public String id;
	public String status;
	public String file;
	public String urgency;

	public TicketDTO ( String solicitedOn, String deadLine, String id, String status, String file, String urgency ) {
		this.solicitedOn = solicitedOn;
		this.deadLine = deadLine;
		this.id = id;
		this.status = status;
		this.file = file;
		this.urgency = urgency;
	}

# 5. Integração/Demonstração

Esta implementação decorreu-se sem grandes problemas, devido a experiencia do sprint passado, bem como a boa estrutura ja existente do projeto

# 6. Observações

Esta funcionaliade encotra-se de acordo com os requesitos.


