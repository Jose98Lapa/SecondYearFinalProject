package eapli.base.task.DTO;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.form.DTO.FormDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.framework.representations.dto.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@DTO
public class ExecutionTaskDTO {
    public String taskID;
    public FormDTO formDTO;
    public String formID;
    public List< TeamDTO > teamListDTO;

    public ExecutionTaskDTO(String taskID) {
        this.taskID = taskID;


    }

    public ExecutionTaskDTO(String taskID, FormDTO formDTO) {
        this.taskID = taskID;
        this.formDTO = formDTO;

    }

    public ExecutionTaskDTO( FormDTO formDTO) {
        this.formDTO = formDTO;

    }

    public ExecutionTaskDTO(String formID, List< TeamDTO > teamDTO) {

        this.formID = formID;
        this.teamListDTO = new ArrayList<>( teamDTO );
    }
}
