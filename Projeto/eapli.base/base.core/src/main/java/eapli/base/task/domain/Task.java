package eapli.base.task.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public abstract class Task implements DomainEntity<TaskID>, AggregateRoot<TaskID> , Serializable {
    @EmbeddedId
    protected TaskID taskID;



    public Task(TaskID taskID){
        this.taskID = taskID;


    }

    protected Task() {
        // For ORM
    }
}
