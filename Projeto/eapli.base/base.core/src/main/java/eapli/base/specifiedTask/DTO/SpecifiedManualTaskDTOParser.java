package eapli.base.specifiedTask.DTO;

import eapli.base.form.DTO.FormDTOParser;
import eapli.base.specifiedTask.domain.SpecifiedManualSpecifiedTask;
import eapli.base.specifiedTask.domain.TaskID;

import eapli.framework.representations.dto.DTOParser;

public class SpecifiedManualTaskDTOParser implements DTOParser<SpecifiedManualTaskDTO, SpecifiedManualSpecifiedTask> {
    @Override
    public SpecifiedManualSpecifiedTask valueOf(SpecifiedManualTaskDTO dto) {
        return new SpecifiedManualSpecifiedTask(TaskID.valueOf(dto.taskID), new FormDTOParser().valueOf(dto.formDTO));
    }
}
