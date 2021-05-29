package eapli.base.task.application;

import eapli.base.task.DTO.ExecutionTaskDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Collections;

public class CheckPendingAssignedTasksController {

    public Iterable<ExecutionTaskDTO> getPendingTasksByCollaborator(String email){
        return Collections.emptyList(); //TODO:
    }
}
