package eapli.base.ticket.application;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.feedback.domain.Feedback;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketStatus;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.application.TicketTaskService;
import eapli.base.ticketTask.domain.TicketTask;


import java.time.LocalDate;
import java.util.*;

public class TicketListService {
    TicketRepository ticketRepository = PersistenceContext.repositories().tickets();


    public Ticket getTicketByID(String ID) {
        Optional<Ticket> optionalTicket = ticketRepository.ofIdentity(ID);
        if (optionalTicket.isEmpty())
            throw new IllegalArgumentException(ID + " is a invalid TicketID");
        return optionalTicket.get();
    }

    public List<TicketDTO> getPendingTicketsToReview(String email) {

        List<Ticket> feedbackBetweenDatesFromAClient = ticketRepository.getFeedbackBetweenDatesFromAClient(email, LocalDate.now().minusDays(7), LocalDate.now());
        List<TicketDTO> toReturn = new ArrayList<>(feedbackBetweenDatesFromAClient.size());
        feedbackBetweenDatesFromAClient.forEach(ticket -> toReturn.add(ticket.toDTO()));
        return toReturn;
    }

    public void reviewTicket(String ID, Feedback feedback) {
        Ticket ticket = getTicketByID(ID);
        ticket.reviewed(feedback);
        this.ticketRepository.save(ticket);
    }

    public float getCollaboratorPerformanceInApprovalTasks(Ticket ticket,Collaborator collaborator){
        return getCollaboratorPerformanceForThisTicket(ticket,new TicketTaskService().getCompletedApprovalTasksByCollaborator(collaborator));
    }

    public float getCollaboratorPerformanceForThisTicket(Ticket ticket,List<TicketTask> ticketTaskList) {
        Set<Ticket> ticketList = new HashSet<>();
        float averagePercentageOfExecution = 0;
        int numberOfTicketTasks = 0;
        int feedbackTotal = 0;


        for (Ticket ticket1 : ticketRepository.findAll()) {
            if (ticket.service().catalogue().sameAs(ticket1.service().catalogue())) {
                for (TicketTask ticketTask : ticketTaskList) {
                    if (ticket1.checkIfTicketTaskBelongsToTicket(ticketTask)) {
                        ticketTaskList.remove(ticketTask);
                        averagePercentageOfExecution += (float) ticketTask.getTimeInMinutesOfExecution() / (float) ticketTask.mainReference().maxTimeOfExecution() * 100.0f;
                        numberOfTicketTasks++;
                        if (ticket1.status().equals(TicketStatus.valueOf("REVIEWED")))
                            ticketList.add(ticket1);
                    }
                    if (ticketTaskList.isEmpty())
                        break;
                }
            }
        }
        averagePercentageOfExecution = averagePercentageOfExecution / numberOfTicketTasks;
        averagePercentageOfExecution = 100 - averagePercentageOfExecution;

        if (ticketList.isEmpty())
            return averagePercentageOfExecution;

        for (Ticket ticket1 : ticketList) {
            feedbackTotal += ticket1.feedback().value().value();
        }

        float averageFeedback = (float) feedbackTotal / ticketList.size();
        averageFeedback = averageFeedback/5f *100.0f;

        return (float) (averagePercentageOfExecution*0.60 + averageFeedback*0.4);

    }


}
