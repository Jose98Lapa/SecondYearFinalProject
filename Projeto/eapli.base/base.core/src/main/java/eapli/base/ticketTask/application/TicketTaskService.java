package eapli.base.ticketTask.application;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketID;
import eapli.base.ticket.domain.TicketStatus;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.repository.TicketTaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketTaskService {
    private final TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();

    public Optional<Collaborator> getCollaborator(String email){
        return collaboratorRepository.getColaboradorByEmail(InstituionalEmail.valueOf(email));
    }

    public List<TicketDTO> getPendingTasks(){
        List<Ticket> ticketList = ticketRepository.getPendingTicket();
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (Ticket ticket: ticketList)
            ticketDTOList.add(ticket.toDTO());
        return ticketDTOList;
    }

    public boolean redeemTask(TicketDTO ticketDTO, Collaborator collaborator){
        Optional<Ticket> Oticket = ticketRepository.ofIdentity(TicketID.valueOf(ticketDTO.id));
        Ticket ticket;

        if (Oticket.isPresent()) {
            ticket = Oticket.get();
            if (ticketDTO.status.equals("PENDING")) {
                ticket.setStatus(TicketStatus.valueOf("WAITING_APPROVAL"));
                TicketApprovalTask ticketTask = (TicketApprovalTask) ticket.workflow().starterTask();
                ticketTask.setApprovedBy(collaborator);
            }else {
                ticket.setStatus(TicketStatus.valueOf("EXECUTING"));
                TicketTask ticketTask = ticket.workflow().starterTask();
                TicketExecutionTask ticketExecutionTask;
                if (ticketTask.getClass().equals(TicketApprovalTask.class))
                    ticketExecutionTask= (TicketExecutionTask) ticketTask.transition().nextTask();
                else
                    ticketExecutionTask=(TicketExecutionTask) ticketTask;
                ticketExecutionTask.setExecutedBy(collaborator);
            }
            ticketRepository.save(ticket);
            }

        return true;
    }
}
