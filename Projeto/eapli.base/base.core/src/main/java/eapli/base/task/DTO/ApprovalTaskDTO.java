package eapli.base.task.DTO;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.form.DTO.FormDTO;
import eapli.base.function.DTO.FunctionDTO;

import java.util.Date;

public class ApprovalTaskDTO {
    public String taskID;
    public FormDTO formDTO;
    public String formID;
    public FunctionDTO functionDTO;

    public ApprovalTaskDTO(String taskID) {
        this.taskID = taskID;


    }

    public ApprovalTaskDTO(String taskID, FormDTO formDTO) {
        this.taskID = taskID;
        this.formDTO = formDTO;
    }

    public ApprovalTaskDTO(String taskID, String formID, FunctionDTO functionDTO) {
        this.taskID = taskID;
        this.formID = formID;
        this.functionDTO = functionDTO;
    }
}
