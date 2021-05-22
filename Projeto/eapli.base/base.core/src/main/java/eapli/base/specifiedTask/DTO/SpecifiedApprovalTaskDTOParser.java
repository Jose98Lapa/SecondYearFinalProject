package eapli.base.specifiedTask.DTO;

import eapli.base.form.DTO.FormDTOParser;
import eapli.base.specifiedTask.domain.SpecifiedApprovalTask;
import eapli.base.specifiedTask.domain.TaskID;
import eapli.framework.representations.dto.DTOParser;

public class SpecifiedApprovalTaskDTOParser implements DTOParser<SpecifiedApprovalTaskDTO, SpecifiedApprovalTask> {
    @Override
    public SpecifiedApprovalTask valueOf(SpecifiedApprovalTaskDTO dto) {
        return new SpecifiedApprovalTask(TaskID.valueOf(dto.taskID),new FormDTOParser().valueOf(dto.formDTO));
    }
}
