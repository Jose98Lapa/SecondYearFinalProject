package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.repository.TicketTaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;

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
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketApprovalTask e WHERE e.approvedBy=:approvedBy and e.dateStarted is null", TicketTask.class);
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
	public List<TicketTask> getTaskByCollaborator(Collaborator collab) {
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketApprovalTask e WHERE e.approvedBy=:approvedBy", TicketTask.class);
		q.setParameter("approvedBy", collab);

		List<TicketTask> ticketTaskList = new ArrayList<>();
		for (Iterator<TicketTask> it = q.getResultStream().iterator(); it.hasNext(); ) {
			TicketTask ticketTask = it.next();
			ticketTaskList.add(ticketTask);
		}

		final TypedQuery<TicketTask> p = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketExecutionTask e WHERE e.executedBy=:executedBy", TicketTask.class);
		p.setParameter("executedBy", collab);

		for (Iterator<TicketTask> it = p.getResultStream().iterator(); it.hasNext(); ) {
			TicketTask ticketTask = it.next();
			ticketTaskList.add(ticketTask);
		}

		return ticketTaskList;
	}

	@Override
	public List<TicketTask> getTaskCompletionTime() {
		List<TicketTask> ticketTaskList;
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketApprovalTask e WHERE  e.status = :status", TicketTask.class);
		q.setParameter("status","COMPLETE");
		ticketTaskList = q.getResultList();
		List<TicketTask> finalTicketTaskList = new ArrayList<>(ticketTaskList);

		final TypedQuery<TicketTask> p = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketExecutionTask e WHERE  e.status = :status", TicketTask.class);
		p.setParameter("status","COMPLETE");
		ticketTaskList = p.getResultList();
		finalTicketTaskList.addAll(ticketTaskList);

		final TypedQuery<TicketTask> r = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketExecutionTask e WHERE  e.status = :status", TicketTask.class);
		r.setParameter("status","COMPLETE");
		ticketTaskList = r.getResultList();
		finalTicketTaskList.addAll(ticketTaskList);

		return finalTicketTaskList;
	}

	@Override
	public List<TicketTask> getCompleteApprovedTicketsByCollaborator(Collaborator collab) {
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketTask e WHERE e.approvedBy=:approvedBy and e.status = :status", TicketTask.class);
		q.setParameter("approvedBy", collab);
		q.setParameter("status","COMPLETE");
		return q.getResultList();
	}

	@Override
	public List<TicketTask> getIncompleteUnassignedTickets() {
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketApprovalTask e WHERE e.approvedBy is null and e.dateStarted is null and e.status = :status", TicketTask.class);
		q.setParameter("status","INCOMPLETE");

		List<TicketTask> ticketTaskList = new ArrayList<>();
		for (Iterator<TicketTask> it = q.getResultStream().iterator(); it.hasNext(); ) {
			TicketTask ticketTask = it.next();
			ticketTaskList.add(ticketTask);
		}

		final TypedQuery<TicketTask> p = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketExecutionTask e WHERE e.executedBy is null and e.dateStarted is null and e.status = :status", TicketTask.class);
		p.setParameter("status","INCOMPLETE");

		for (Iterator<TicketTask> it = p.getResultStream().iterator(); it.hasNext(); ) {
			TicketTask ticketTask = it.next();
			ticketTaskList.add(ticketTask);
		}

		return ticketTaskList;
	}

	@Override
	public List< TicketApprovalTask > pendingApproval ( Collaborator collaborator ) {

		final TypedQuery< TicketTask > query = createQuery(
				"SELECT e FROM eapli.base.ticketTask.domain.TicketTask e Where e.approvedBy=:approvedBy",
				TicketTask.class )
				;
		query.setParameter( "approvedBy", collaborator );
		return query.getResultList( ).stream( ).map( ticketTask -> ( TicketApprovalTask) ticketTask ).collect( Collectors.toList( ) );
	}

	@Override
	public List< TicketExecutionTask > pendingExecution ( Collaborator collaborator ) {

		final TypedQuery< TicketTask > query = createQuery(
				"SELECT e FROM eapli.base.ticketTask.domain.TicketTask e Where e.executedBy=:executedBy",
				TicketTask.class
		);
		query.setParameter( "executedBy", collaborator );
		return query.getResultList( ).stream( ).map( ticketTask -> ( TicketExecutionTask ) ticketTask ).collect( Collectors.toList( ) );
	}

}