package eapli.base.task.DTO;

import eapli.framework.representations.dto.DTO;

import java.util.Date;

@DTO
public class AutomaticTaskDTO {
    String taskID;

    String script;


    public AutomaticTaskDTO(String taskID) {
        this.taskID = taskID;

    }

    public AutomaticTaskDTO(String taskID, String script) {
        this.taskID = taskID;
        this.script = script;
    }

}
