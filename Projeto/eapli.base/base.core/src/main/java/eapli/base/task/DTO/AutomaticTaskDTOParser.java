package eapli.base.task.DTO;

import eapli.base.task.domain.AutomaticTask;
import eapli.base.task.domain.ScriptPath;
import eapli.base.task.domain.TaskID;


import eapli.framework.representations.dto.DTOParser;

public class AutomaticTaskDTOParser implements DTOParser<AutomaticTaskDTO, AutomaticTask> {
    @Override
    public AutomaticTask valueOf(AutomaticTaskDTO dto) {
        return new AutomaticTask(ScriptPath.valueOf(dto.script));
    }
}
