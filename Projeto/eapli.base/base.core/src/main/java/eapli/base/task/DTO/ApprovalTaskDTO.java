package eapli.base.task.DTO;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.form.DTO.FormDTO;

import java.util.Date;

public class ApprovalTaskDTO {
    String taskID;

    FormDTO formDTO;


    public ApprovalTaskDTO(String taskID) {
        this.taskID = taskID;


    }

    public ApprovalTaskDTO(String taskID, FormDTO formDTO) {
        this.taskID = taskID;
        this.formDTO = formDTO;
    }


}
