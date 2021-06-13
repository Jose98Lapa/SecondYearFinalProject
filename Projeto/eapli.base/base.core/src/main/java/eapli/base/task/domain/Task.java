package eapli.base.task.domain;

import eapli.base.utils.GenerateRandomStringID;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Task implements DomainEntity<Long>, AggregateRoot<Long>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long taskID;
    @OneToOne(cascade = CascadeType.ALL)
    private Task beforeTask;
    @OneToOne(cascade = CascadeType.ALL)
    private Task afterTask;
    private long maxTimeOfExecution;


    public Task() {

    }


    public void editBeforeTask(Task beforeTask) {
        this.beforeTask = beforeTask;
    }

    public void editAfterTask(Task afterTask) {
        if (this.getClass() == ApprovalTask.class) {
            if (afterTask.getClass() == ApprovalTask.class) {
                throw new IllegalArgumentException("You can't have an approval task after an approval task");
            } else {
                this.afterTask = afterTask;
            }
        }else{
            this.afterTask = afterTask;
        }

    }

    public boolean hasAfterTask() {
        return this.afterTask != null;
    }

    public Task afterTask() {
        return this.afterTask;
    }

    public boolean hasPreviousTask() {
        return this.beforeTask != null;
    }

    public Task previousTask() {
        return this.beforeTask;
    }

    public void addMaxTimeOfExecution(long maxTimeOfExecution){
        this.maxTimeOfExecution = maxTimeOfExecution;
    }

    public long maxTimeOfExecution(){
        return this.maxTimeOfExecution;
    }


}
