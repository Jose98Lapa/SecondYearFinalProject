package eapli.base.ticket.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;
import eapli.base.ticket.repository.TicketRepository;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketListService {
    TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
    public List<Service> getServicesWithPendingTickets(){
        List<Service> serviceList = new ArrayList<>();
        //ticketRepository.getPendingTicket().forEach(ticket -> serviceList.add(ticket.service()))

        return Collections.emptyList() ;
    }

}
