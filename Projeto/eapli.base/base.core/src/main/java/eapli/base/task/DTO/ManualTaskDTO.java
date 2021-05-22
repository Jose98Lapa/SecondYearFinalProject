package eapli.base.task.DTO;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.form.DTO.FormDTO;
import eapli.framework.representations.dto.DTO;

import java.util.Set;

@DTO
public class ManualTaskDTO {
    String taskID;
    String taskStatus;
    FormDTO formDTO;
    Set<CollaboratorDTO> interveningCollaboratorDTO;

    public ManualTaskDTO(String taskID,String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;

    }

    public ManualTaskDTO(String taskID,String taskStatus, FormDTO formDTO,Set<CollaboratorDTO> interveningCollaboratorDTO) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.formDTO = formDTO;
        this.interveningCollaboratorDTO.addAll(interveningCollaboratorDTO);
    }
}
