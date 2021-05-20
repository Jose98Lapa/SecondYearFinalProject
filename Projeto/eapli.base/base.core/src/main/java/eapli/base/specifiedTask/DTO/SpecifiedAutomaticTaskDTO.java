package eapli.base.specifiedTask.DTO;

import eapli.framework.representations.dto.DTO;

@DTO
public class SpecifiedAutomaticTaskDTO {
    String taskID;
    String taskStatus;
    String script;

    public SpecifiedAutomaticTaskDTO(String taskID, String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public SpecifiedAutomaticTaskDTO(String taskID, String taskStatus, String script) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.script = script;
    }
}
