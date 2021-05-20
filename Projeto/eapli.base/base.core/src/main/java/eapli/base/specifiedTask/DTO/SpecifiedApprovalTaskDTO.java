package eapli.base.specifiedTask.DTO;

import eapli.base.form.DTO.FormDTO;

public class SpecifiedApprovalTaskDTO {
    String taskID;
    String taskStatus;
    FormDTO formDTO;

    public SpecifiedApprovalTaskDTO(String taskID, String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public SpecifiedApprovalTaskDTO(String taskID, String taskStatus, FormDTO formDTO) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.formDTO = formDTO;
    }
}
