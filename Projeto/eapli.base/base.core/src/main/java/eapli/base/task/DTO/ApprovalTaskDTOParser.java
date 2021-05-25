package eapli.base.task.DTO;

import eapli.base.form.DTO.FormDTOParser;
import eapli.base.task.domain.ApprovalTask;
import eapli.base.task.domain.TaskID;
import eapli.base.task.domain.TaskStatus;
import eapli.framework.representations.dto.DTOParser;

public class ApprovalTaskDTOParser implements DTOParser<ApprovalTaskDTO, ApprovalTask> {
    @Override
    public ApprovalTask valueOf(ApprovalTaskDTO dto) {
        return new ApprovalTask(TaskID.valueOf(dto.taskID), TaskStatus.valueOf(dto.taskStatus),new FormDTOParser().valueOf(dto.formDTO));
    }
}