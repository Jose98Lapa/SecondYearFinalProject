package eapli.base.task.DTO;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.form.DTO.FormDTO;
import eapli.framework.representations.dto.DTO;

import java.util.Set;

@DTO
public class ExecutionTaskDTO {
    String taskID;
    FormDTO formDTO;


    public ExecutionTaskDTO(String taskID) {
        this.taskID = taskID;


    }

    public ExecutionTaskDTO(String taskID, FormDTO formDTO) {
        this.taskID = taskID;
        this.formDTO = formDTO;

    }
}
