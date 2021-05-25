package eapli.base.task.domain;

import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;

@Entity
public abstract class Task implements DomainEntity<TaskID> {
    @EmbeddedId
    protected TaskID taskID;



    public Task(TaskID taskID){
        this.taskID = taskID;


    }

    protected Task() {
        // For ORM
    }
}
