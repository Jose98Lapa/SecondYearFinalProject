# US 1005 e 1006 Desenvolver a componente representativa de uma tarefa manual e automática
=======================================


# 1. Requisitos

**US 1005 e 1006:**  Como Gestor de Projeto, eu pretendo que seja desenvolvida a componente representativa de uma tarefa manual dedicada à apresentação e recolha de informação a/de um utilizador no âmbito de um pedido e que a mesma seja adicionada à biblioteca de atividades típicas do sistema para, dessa forma, poder ser usada na definição de fluxos de atividades e de uma tarefa automática dedicada à execução de um script no âmbito de um pedido e que a mesma seja adicionada à biblioteca de atividades típicas do sistema para, dessa forma, poder ser usada na definição de fluxos de atividades.


# 2. Análise

Para análise o modelo de domínio dá resposta ao requisito, não sendo assim necessário estender o mesmo. [Verificar modelo de domínio](https://bitbucket.org/1190731/lei20_21_s4_2dl_1/src/master/Modelo%20de%20Dominio.svg)

# 3. Design

## 3.1. Realização da Funcionalidade

Devido a estas USs serem bastante parecidas e apenas ser necessário desenvolver a componente representativa não foi necessário adicionar diagramas de sequência.

## 3.2. Diagrama de Classes



## 3.3. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

### idTest
**Teste 1:** 
    TaskID taskIDtest = new TaskID("123");
    @Test
    public void test() {
        assertEquals(taskIDtest, new TaskID("123"));
        assertEquals(taskIDtest,TaskID.valueOf("123"));
        assertNotEquals(taskIDtest, new TeamID("12"));
        assertThrows(IllegalArgumentException.class,() -> new TeamID("a"));
        assertThrows(IllegalArgumentException.class,() -> new TeamID(""));
        assertThrows(IllegalArgumentException.class,() -> new TeamID(null));
    }



# 4. Implementação

Como estas classes iam ser utilizadas na workflow e a workflow pode ter uma classe automática ou manual então ambas classes herdam de uma superclasse task para alcançar o polimorfismo.
```super classe task ```

public abstract class Task implements DomainEntity<TaskID>, AggregateRoot<TaskID> , Serializable {
    @EmbeddedId
    protected TaskID taskID;
    @OneToOne(cascade = CascadeType.ALL)
    private Task beforeTask;
    @OneToOne(cascade = CascadeType.ALL)
    private Task afterTask;



    public Task(TaskID taskID){
        this.taskID = taskID;
    }

    protected Task() {
        // For ORM
    }

    public void editBeforeTask(Task beforeTask){
        if (this.getClass()==AutomaticTask.class||this.getClass()==ExecutionTask.class){
            if (beforeTask.getClass()!=ApprovalTask.class){
                throw new IllegalArgumentException("You can't have an execution task before an execution task");
            }else{
                this.beforeTask= beforeTask;
            }
        }



    }

    public void editAfterTask(Task afterTask){
        if (this.getClass()==ApprovalTask.class){
            if (afterTask.getClass()==ApprovalTask.class){
                throw new IllegalArgumentException("You can't have an approval task after an approval task");
            }else{
                this.afterTask= afterTask;
            }
        }

    }

    public boolean hasAfterTask () {
        return this.afterTask != null;
    }
    public Task afterTask () {
        return this.afterTask;
    }

    public boolean hasPreviousTask () {
        return this.beforeTask != null;
    }

    public Task previousTask () {
        return this.beforeTask;
    }


}



# 5. Integração/Demonstração

Como foi apenas necessário desenvolver as componentes representativas estas só são utilizadas no workflow
