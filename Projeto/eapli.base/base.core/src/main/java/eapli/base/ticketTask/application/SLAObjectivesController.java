
package eapli.base.ticketTask.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SLAObjectivesController {
    public List<List<String>> SLAObjective(){
        TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
        List<Ticket> ticketList = ticketRepository.getCompletedTickets();
        List<List<String>> present = new ArrayList<>();

        for (Ticket ticket:ticketList){
            List<String> addPresent = new ArrayList<>();
            addPresent.add(ticket.displayInfo());
            //Approval Objective
            String[] ApprovalObjective= ticket.service().catalogue().criticalityLevel().approvalObjective().tempoMaximo().split(":");
            long ApprovalObjectiveM=Long.parseLong(ApprovalObjective[0])*60+Long.parseLong(ApprovalObjective[1]);
            long ApprovalTime=0;
            String completionStateA="Objetivos de aprovação SLA:COMPLETED | ";

            //Resolution Objective
            String[] ResolutionObjective= ticket.service().catalogue().criticalityLevel().approvalObjective().tempoMaximo().split(":");
            long ResolutionObjectiveM=Long.parseLong(ResolutionObjective[0])*60+Long.parseLong(ResolutionObjective[1]);
            long ResolutionTime=0;
            String completionStateR="Objetivos de resolução SLA:COMPLETED | ";

            //If there is an approval task
            if (ticket.workflow().approvalTask().isPresent()) {
                //Approval task completion time
                ApprovalTime=ticket.workflow().approvalTask().get().completionTime();
                if (ApprovalObjectiveM-ApprovalTime<0) {
                    if(!ticket.status().toString().equals("FAILED")) {
                        ticket.statusFailed();
                        ticketRepository.save(ticket);
                    }
                    completionStateA = "Objetivos de aprovação SLA:FAILED | ";
                }
            }

            //If there is an execution task
            if (ticket.workflow().executionTask().isPresent()) {
                //Execution task completion time
                ResolutionTime=ticket.workflow().executionTask().get().completionTime();
            }

            if (ticket.workflow().automaticTask().isPresent()) {
                //Execution task completion time
                ResolutionTime+=ticket.workflow().automaticTask().get().completionTime();
            }

            if (ResolutionObjectiveM-ResolutionTime<0) {
                if(!ticket.status().toString().equals("FAILED")) {
                    ticket.statusFailed();
                    ticketRepository.save(ticket);
                }
                completionStateR = "Objetivos de resolução SLA:FAILED | ";
            }
            addPresent.add(completionStateA);
            addPresent.add(completionStateR);
            present.add(addPresent);
        }
        return present;
    }
}
