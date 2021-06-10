package eapli.base.ticketTask.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticketTask.domain.*;
import eapli.base.ticketTask.repository.TicketTaskRepository;

public class CreateTaskController {

	private final TicketTaskRepository ticketTaskRepository = PersistenceContext.repositories().ticketTasks();

	public void registerApprovalTask( TicketApprovalTask ticketApprovalTask ){
		this.ticketTaskRepository.save( ticketApprovalTask );
	}

	public void registerExecutionTask( TicketExecutionTask ticketExecutionTask ){
		this.ticketTaskRepository.save( ticketExecutionTask );
	}

	public void registerAutomaticTask( TicketAutomaticTask ticketAutomaticTask) {
		this.ticketTaskRepository.save( ticketAutomaticTask );
	}

	public TicketTask registerTicketTask(TicketTask ticketTask){
		return this.ticketTaskRepository.save(ticketTask);
	}

}
