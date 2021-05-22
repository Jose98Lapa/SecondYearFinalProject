package eapli.base.specifiedTask.DTO;

import eapli.framework.representations.dto.DTO;

@DTO
public class SpecifiedAutomaticTaskDTO {
    String taskID;

    String script;

    public SpecifiedAutomaticTaskDTO(String taskID) {
        this.taskID = taskID;

    }

    public SpecifiedAutomaticTaskDTO(String taskID, String script) {
        this.taskID = taskID;
        this.script = script;
    }
}
