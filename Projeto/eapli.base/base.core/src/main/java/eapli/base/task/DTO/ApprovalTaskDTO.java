package eapli.base.task.DTO;

import eapli.base.form.DTO.FormDTO;

public class ApprovalTaskDTO {
    String taskID;
    String taskStatus;
    FormDTO formDTO;

    public ApprovalTaskDTO(String taskID,String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;

    }

    public ApprovalTaskDTO(String taskID,String taskStatus, FormDTO formDTO) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.formDTO = formDTO;
    }
}
