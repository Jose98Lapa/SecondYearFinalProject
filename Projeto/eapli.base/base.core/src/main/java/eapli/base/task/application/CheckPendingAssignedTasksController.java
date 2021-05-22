package eapli.base.task.application;

import eapli.base.task.DTO.ManualTaskDTO;
import eapli.base.ticket.repository.TicketRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Collections;

public class CheckPendingAssignedTasksController {

    public Iterable<ManualTaskDTO> getPendingTasksByCollaborator(){
        AuthorizationService authz = AuthzRegistry.authorizationService();
        String email = authz.session().get().authenticatedUser().email().toString();
        return Collections.emptyList();
    }
}
