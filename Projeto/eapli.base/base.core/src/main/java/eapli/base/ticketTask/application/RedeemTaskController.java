package eapli.base.ticketTask.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class RedeemTaskController {
    private final TicketRepository ticketRepository =PersistenceContext.repositories().tickets();

    public List<TicketDTO> getPendingTasks(){
        List<Ticket> ticketList = (List<Ticket>) ticketRepository.getPendingTicket();
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (Ticket ticket: ticketList)
            ticketDTOList.add(ticket.toDTO());
        return ticketDTOList;
    }

    public boolean redeemTask(TicketDTO ticketDTO){
        return true;
    }
}
