package eapli.base.task.application;

import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.task.DTO.ExecutionTaskDTO;

import java.util.Collections;
import java.util.List;

public class TaskListService {

    public List<ExecutionTaskDTO> getPendingTasksByCollaborator (String email){
        Collaborator collaborator = new ListCollaboratorService().getCollaboratorByEmail(email);
        return Collections.emptyList();
    }
}
