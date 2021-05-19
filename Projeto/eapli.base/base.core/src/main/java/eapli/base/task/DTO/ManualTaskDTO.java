package eapli.base.task.DTO;

import eapli.base.form.DTO.FormDTO;
import eapli.framework.representations.dto.DTO;

@DTO
public class ManualTaskDTO {
    String taskID;
    String taskStatus;
    FormDTO formDTO;

    public ManualTaskDTO(String taskID, String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public ManualTaskDTO(String taskID, String taskStatus, FormDTO formDTO) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.formDTO = formDTO;
    }
}
