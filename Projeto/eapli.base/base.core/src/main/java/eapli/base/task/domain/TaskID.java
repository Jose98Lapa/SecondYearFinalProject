package eapli.base.task.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TaskID implements ValueObject, Comparable<TaskID>, Serializable {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String taskID;

    public TaskID (String taskID){
        if (StringPredicates.isNullOrEmpty(taskID)){
            throw new IllegalArgumentException("O ID não pode ser null ou vazio");
        }
        if (taskID.matches("[tT]\\d{1,6}")){
            throw new IllegalArgumentException("Este ID não é válido");
        }
        this.taskID = taskID;


    }

    protected TaskID() {
// For ORM
    }

    public static TaskID valueOf(String taskID){
        return new TaskID(taskID);
    }


    @Override
    public int compareTo(TaskID o) {
        return taskID.compareTo(o.taskID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskID taskID1 = (TaskID) o;
        return Objects.equals(taskID, taskID1.taskID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskID);
    }

    @Override
    public String toString() {
        return taskID;
    }
}
