package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketAutomaticTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.repository.TicketTaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class JpaTicketTaskRepository extends JpaAutoTxRepository< TicketTask, Long, Long > implements TicketTaskRepository {

	public JpaTicketTaskRepository(TransactionalContext autoTx) {
		super(autoTx, "TicketTaskID");
	}

	public JpaTicketTaskRepository(String puname) {
		super(puname, Application.settings().getExtendedPersistenceProperties(),
				"TicketTaskID");
	}

	@Override
	public Optional<TicketTask> ofIdentity(Long ticketTaskID){
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketTask e WHERE e.ticketTaskID = :id", TicketTask.class);
		q.setParameter("id",ticketTaskID);
		return q.getResultStream().findFirst();
	}


	@Override
	public List<TicketTask> getIncompleteTicketsByCollaborator(Collaborator collab) {
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketTask e WHERE e.approvedBy=:approvedBy and e.dateStarted is null", TicketTask.class);
		q.setParameter("approvedBy", collab);

		List<TicketTask> ticketTaskList = new ArrayList<>();
		for (Iterator<TicketTask> it = q.getResultStream().iterator(); it.hasNext(); ) {
			TicketTask ticketTask = it.next();
			ticketTaskList.add(ticketTask);
		}

		final TypedQuery<TicketTask> p = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketExecutionTask e WHERE e.executedBy=:executedBy and e.dateStarted is null", TicketTask.class);
		p.setParameter("executedBy", collab);

		for (Iterator<TicketTask> it = p.getResultStream().iterator(); it.hasNext(); ) {
			TicketTask ticketTask = it.next();
			ticketTaskList.add(ticketTask);
		}

		return ticketTaskList;
	}

	@Override
	public List<TicketTask> getCompleteApprovedTicketsByCollaborator(Collaborator collab) {
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketTask e WHERE e.approvedBy=:approvedBy and e.status = :status", TicketTask.class);
		q.setParameter("approvedBy", collab);
		q.setParameter("status","COMPLETE");
		return q.getResultList();
	}


	@Override
	public List< TicketApprovalTask > pendingApproval ( String collaboratorEmail ) {

		final TypedQuery< TicketApprovalTask > query = createQuery(
				"SELECT e FROM eapli.base.ticketTask.domain.TicketTask e Where e.approvedBy:=approvedBy",
				TicketApprovalTask.class )
				;
		query.setParameter( "approvedBy", collaboratorEmail );
		return query.getResultList();
	}

	@Override
	public List< TicketExecutionTask > pendingExecution ( String collaboratorEmail ) {

		final TypedQuery< TicketExecutionTask > query = createQuery(
				"SELECT e FROM eapli.base.ticketTask.domain.TicketTask e Where e.executedBy:=executedBy",
				TicketExecutionTask.class
		);
		query.setParameter( "executedBy", collaboratorEmail );
		return query.getResultList();
	}

}