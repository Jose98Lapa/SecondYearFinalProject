package eapli.base.task.application;

import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.task.DTO.ManualTaskDTO;

import java.util.Collections;
import java.util.List;

public class TaskListService {

    public List<ManualTaskDTO> getPendingTasksByCollaborator (String email){
        Collaborator collaborator = new ListCollaboratorService().getCollaboratorByEmail(email);
        return Collections.emptyList();
    }
}
