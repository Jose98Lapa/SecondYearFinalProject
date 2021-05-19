package eapli.base.task.domain;

import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;

@Entity
public abstract class Task implements DomainEntity<TaskID> {
    @EmbeddedId
    protected TaskID taskID;

    @Embedded
    protected TaskStatus taskStatus;

    public Task(TaskID taskID,TaskStatus taskStatus){
        this.taskID = taskID;

    }

    protected Task() {
        // For ORM
    }
}
