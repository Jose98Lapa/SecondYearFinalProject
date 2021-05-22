package eapli.base.specifiedTask.DTO;

import eapli.base.form.DTO.FormDTO;
import eapli.framework.representations.dto.DTO;

@DTO
public class SpecifiedManualTaskDTO {
    String taskID;

    FormDTO formDTO;

    public SpecifiedManualTaskDTO(String taskID) {
        this.taskID = taskID;

    }

    public SpecifiedManualTaskDTO(String taskID, FormDTO formDTO) {
        this.taskID = taskID;

        this.formDTO = formDTO;
    }
}
