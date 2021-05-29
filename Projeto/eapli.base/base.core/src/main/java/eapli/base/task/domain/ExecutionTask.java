package eapli.base.task.domain;

import eapli.base.form.domain.Form;
import eapli.base.task.DTO.ExecutionTaskDTO;
import eapli.base.team.domain.Team;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class ExecutionTask extends ManualTask implements DTOable<ExecutionTaskDTO> , Serializable {

    @OneToOne
    private Team necessaryTeamForExecution;

    public ExecutionTask(TaskID taskID, Form form,Team necessaryTeamForExecution) {
        super(taskID,form);
        this.necessaryTeamForExecution = necessaryTeamForExecution;
    }

    protected ExecutionTask() {
        //For ORM
    }

    @Override
    public ExecutionTaskDTO toDTO() {
        return new ExecutionTaskDTO(this.taskID.toString(),this.form().toDTO());
    }
}
