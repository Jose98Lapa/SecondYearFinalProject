package eapli.base.specifiedTask.DTO;

import eapli.base.form.DTO.FormDTO;

public class SpecifiedApprovalTaskDTO {
    String taskID;
    FormDTO formDTO;

    public SpecifiedApprovalTaskDTO(String taskID) {
        this.taskID = taskID;

    }

    public SpecifiedApprovalTaskDTO(String taskID, FormDTO formDTO) {
        this.taskID = taskID;

        this.formDTO = formDTO;
    }
}
