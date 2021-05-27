package eapli.base.task.domain;

import eapli.base.form.domain.Form;
import eapli.base.task.DTO.ExecutionTaskDTO;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ExecutionTask extends ManualTask implements DTOable<ExecutionTaskDTO> , Serializable {
    public ExecutionTask(TaskID taskID, Form form) {
        super(taskID,form);
    }

    protected ExecutionTask() {
        //For ORM
    }

    @Override
    public ExecutionTaskDTO toDTO() {
        return new ExecutionTaskDTO(this.taskID.toString(),this.form().toDTO());
    }
}
