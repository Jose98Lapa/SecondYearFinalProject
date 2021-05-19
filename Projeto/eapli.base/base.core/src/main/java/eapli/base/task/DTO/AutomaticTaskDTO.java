package eapli.base.task.DTO;

import eapli.framework.representations.dto.DTO;

@DTO
public class AutomaticTaskDTO {
    String taskID;
    String taskStatus;
    String script;

    public AutomaticTaskDTO(String taskID, String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public AutomaticTaskDTO(String taskID, String taskStatus, String script) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.script = script;
    }
}
