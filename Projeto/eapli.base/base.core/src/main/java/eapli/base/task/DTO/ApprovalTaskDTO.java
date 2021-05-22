package eapli.base.task.DTO;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.form.DTO.FormDTO;

import java.util.Date;

public class ApprovalTaskDTO {
    String taskID;
    String taskStatus;
    FormDTO formDTO;
    Date approvalDate;
    CollaboratorDTO collaboratorDTO;

    public ApprovalTaskDTO(String taskID,String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;

    }

    public ApprovalTaskDTO(String taskID,String taskStatus, FormDTO formDTO) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.formDTO = formDTO;
    }

    public ApprovalTaskDTO(String taskID, String taskStatus, FormDTO formDTO, Date approvalDate, CollaboratorDTO collaboratorDTO) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.formDTO = formDTO;
        this.approvalDate = approvalDate;
        this.collaboratorDTO = collaboratorDTO;
    }
}
