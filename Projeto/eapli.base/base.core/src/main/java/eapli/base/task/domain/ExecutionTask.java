package eapli.base.task.domain;

import eapli.base.form.domain.Form;
import eapli.base.task.DTO.ExecutionTaskDTO;
import eapli.base.team.domain.Team;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ExecutionTask extends ManualTask implements DTOable<ExecutionTaskDTO> , Serializable {

    @ManyToMany
    @JoinTable(name="EXECUTION_TASK_TEAM", joinColumns = @JoinColumn(name="TASK_ID"))
    private List<Team> executingTeams;

    public ExecutionTask( Form form, List< Team > necessaryTeamsForExecution) {
        super(form);
        this.executingTeams = new ArrayList<>( necessaryTeamsForExecution );
    }

    public List<Team> executingTeams() {
        return executingTeams;
    }

    protected ExecutionTask() {
        //For ORM
    }

    @Override
    public ExecutionTaskDTO toDTO() {
        return new ExecutionTaskDTO(this.taskID.toString(),this.form().toDTO());
    }
}
