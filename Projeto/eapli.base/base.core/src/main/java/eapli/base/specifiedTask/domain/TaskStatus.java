package eapli.base.specifiedTask.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class TaskStatus implements ValueObject {
    private String taskStatus;

    public TaskStatus(String taskStatus) {
        if (StringPredicates.isNullOrEmpty(taskStatus)){
            throw new IllegalArgumentException("O estado não pode ser nulo ou vazio");
        }
        if (!taskStatus.matches("EXECUCAO|APROVADO|NEGADO")){
            throw new IllegalArgumentException("O valor do estado não está correto");
        }


        this.taskStatus = taskStatus;
    }

    protected TaskStatus(){

    }


    public static TaskStatus valueOf(String taskStatus){
        return new TaskStatus(taskStatus);
    }

    @Override
    public String toString() {
        return taskStatus;
    }
}
