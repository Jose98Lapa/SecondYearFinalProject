package eapli.base.ticketTask.application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;
import java.util.Optional;

public class RedeemTaskController {
    private final TicketTaskService ticketTaskService = new TicketTaskService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public List<TicketDTO> getPendingTasks(){
        return ticketTaskService.getPendingTasks();
    }

    public boolean redeemTask(TicketDTO ticketDTO){
        String email = authz.session().get().authenticatedUser().email().toString();
        Optional<Collaborator> Ocollaborator = ticketTaskService.getCollaborator(email);
        return Ocollaborator.filter(collaborator -> ticketTaskService.redeemTask(ticketDTO, collaborator)).isPresent();
    }
}
