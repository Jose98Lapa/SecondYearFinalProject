package eapli.base.task.DTO;


import eapli.base.form.DTO.FormDTOParser;
import eapli.base.task.domain.ExecutionTask;
import eapli.base.task.domain.TaskID;


import eapli.framework.representations.dto.DTOParser;

public class ExecutionTaskDTOParser implements DTOParser<ExecutionTaskDTO, ExecutionTask> {
    @Override
    public ExecutionTask valueOf(ExecutionTaskDTO dto) {
        return new ExecutionTask(TaskID.valueOf(dto.taskID), new FormDTOParser().valueOf(dto.formDTO));
    }
}