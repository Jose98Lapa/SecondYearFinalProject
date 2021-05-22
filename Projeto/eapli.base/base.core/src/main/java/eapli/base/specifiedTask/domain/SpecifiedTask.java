package eapli.base.specifiedTask.domain;

import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;

@Entity
public abstract class SpecifiedTask implements DomainEntity<TaskID> {
    @EmbeddedId
    protected TaskID taskID;

    @Embedded
    protected TaskStatus taskStatus;

    public SpecifiedTask(TaskID taskID){
        this.taskID = taskID;

    }

    protected SpecifiedTask() {
        // For ORM
    }
}
