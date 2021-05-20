package eapli.base.specifiedTask.DTO;

import eapli.base.form.DTO.FormDTO;
import eapli.framework.representations.dto.DTO;

@DTO
public class SpecifiedManualTaskDTO {
    String taskID;
    String taskStatus;
    FormDTO formDTO;

    public SpecifiedManualTaskDTO(String taskID, String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public SpecifiedManualTaskDTO(String taskID, String taskStatus, FormDTO formDTO) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.formDTO = formDTO;
    }
}
