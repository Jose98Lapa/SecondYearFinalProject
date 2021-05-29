package eapli.base.task.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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



}
