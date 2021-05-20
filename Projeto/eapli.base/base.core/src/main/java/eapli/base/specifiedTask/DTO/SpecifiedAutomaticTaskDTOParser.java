package eapli.base.specifiedTask.DTO;

import eapli.base.specifiedTask.domain.SpecifiedAutomaticSpecifiedTask;
import eapli.base.specifiedTask.domain.ScriptPath;
import eapli.base.specifiedTask.domain.TaskID;
import eapli.base.specifiedTask.domain.TaskStatus;
import eapli.framework.representations.dto.DTOParser;

public class SpecifiedAutomaticTaskDTOParser implements DTOParser<SpecifiedAutomaticTaskDTO, SpecifiedAutomaticSpecifiedTask> {
    @Override
    public SpecifiedAutomaticSpecifiedTask valueOf(SpecifiedAutomaticTaskDTO dto) {
        return new SpecifiedAutomaticSpecifiedTask(TaskID.valueOf(dto.taskID), TaskStatus.valueOf(dto.taskStatus), ScriptPath.valueOf(dto.script));
    }
}
