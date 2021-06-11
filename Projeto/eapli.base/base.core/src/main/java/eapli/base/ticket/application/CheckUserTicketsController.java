package eapli.base.ticket.application;
import eapli.base.infrastructure.persistence.PersistenceContext;

import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.LinkedList;

public class CheckUserTicketsController {
    private TicketRepository ticketRepository =  PersistenceContext.repositories().tickets();
    ManageTicketListsService manageService = new ManageTicketListsService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public  LinkedList<String> loadInformation() {
        String email = authz.session().get().authenticatedUser().email().toString();
        ArrayList<Ticket> list = (ArrayList<Ticket>) ticketRepository.getTicketsByClient(email);
        return manageService.prepareInformation(list);
    }
}
