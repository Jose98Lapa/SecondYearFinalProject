package eapli.base.task.DTO;

import eapli.framework.representations.dto.DTO;

import java.util.Date;

@DTO
public class AutomaticTaskDTO {
    String taskID;
    String taskStatus;
    String script;
    Date dateOfExecution;

    public AutomaticTaskDTO(String taskID,String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public AutomaticTaskDTO(String taskID,String taskStatus, String script) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.script = script;
    }

    public AutomaticTaskDTO(String taskID, String taskStatus, String script, Date dateOfExecution) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
        this.script = script;
        this.dateOfExecution = dateOfExecution;
    }
}
