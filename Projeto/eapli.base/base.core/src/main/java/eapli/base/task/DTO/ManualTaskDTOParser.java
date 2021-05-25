package eapli.base.task.DTO;


import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.collaborator.dto.CollaboratorDTOParser;
import eapli.base.form.DTO.FormDTOParser;
import eapli.base.task.domain.ManualTask;
import eapli.base.task.domain.TaskID;

import eapli.base.task.domain.TaskStatus;
import eapli.framework.representations.dto.DTOParser;

public class ManualTaskDTOParser implements DTOParser<ManualTaskDTO, ManualTask> {
    @Override
    public ManualTask valueOf(ManualTaskDTO dto) {
        ManualTask manualTask = new ManualTask(TaskID.valueOf(dto.taskID), TaskStatus.valueOf(dto.taskStatus), new FormDTOParser().valueOf(dto.formDTO));
        for (CollaboratorDTO collaboratorDTO : dto.interveningCollaboratorDTO){
            manualTask.addAnInterveningCollaborator(new CollaboratorDTOParser().valueOf(collaboratorDTO));
        }
        return manualTask;
    }
}