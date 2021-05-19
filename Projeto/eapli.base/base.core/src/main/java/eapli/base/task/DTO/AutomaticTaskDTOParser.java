package eapli.base.task.DTO;

import eapli.base.task.domain.AutomaticTask;
import eapli.base.task.domain.ScriptPath;
import eapli.base.task.domain.TaskID;
import eapli.base.task.domain.TaskStatus;
import eapli.framework.representations.dto.DTOParser;

public class AutomaticTaskDTOParser implements DTOParser<AutomaticTaskDTO, AutomaticTask> {
    @Override
    public AutomaticTask valueOf(AutomaticTaskDTO dto) {
        return new AutomaticTask(TaskID.valueOf(dto.taskID), TaskStatus.valueOf(dto.taskStatus), ScriptPath.valueOf(dto.script));
    }
}
