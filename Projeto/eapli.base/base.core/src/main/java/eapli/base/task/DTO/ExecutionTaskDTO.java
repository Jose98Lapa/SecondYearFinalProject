package eapli.base.task.DTO;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.form.DTO.FormDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.framework.representations.dto.DTO;

import java.util.Set;

@DTO
public class ExecutionTaskDTO {
    public String taskID;
    public FormDTO formDTO;
    public String formID;
    public TeamDTO teamDTO;

    public ExecutionTaskDTO(String taskID) {
        this.taskID = taskID;


    }

    public ExecutionTaskDTO(String taskID, FormDTO formDTO) {
        this.taskID = taskID;
        this.formDTO = formDTO;

    }

    public ExecutionTaskDTO(String taskID, String formID, TeamDTO teamDTO) {
        this.taskID = taskID;
        this.formID = formID;
        this.teamDTO = teamDTO;
    }
}
