package eapli.base.task.DTO;

import eapli.base.form.DTO.FormDTOParser;
import eapli.base.task.domain.ManualTask;
import eapli.base.task.domain.TaskID;

import eapli.base.task.domain.TaskStatus;
import eapli.framework.representations.dto.DTOParser;

public class ManualTaskDTOParser implements DTOParser<ManualTaskDTO, ManualTask> {
    @Override
    public ManualTask valueOf(ManualTaskDTO dto) {
        return new ManualTask(TaskID.valueOf(dto.taskID), TaskStatus.valueOf(dto.taskStatus), new FormDTOParser().valueOf(dto.formDTO));
    }
}
