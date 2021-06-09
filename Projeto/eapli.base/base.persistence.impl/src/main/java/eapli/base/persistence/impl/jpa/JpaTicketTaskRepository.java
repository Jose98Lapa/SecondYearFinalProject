package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.domain.TicketTaskID;
import eapli.base.ticketTask.repository.TicketTaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class JpaTicketTaskRepository extends JpaAutoTxRepository< TicketTask, TicketTaskID, TicketTaskID > implements TicketTaskRepository {

	public JpaTicketTaskRepository(TransactionalContext autoTx) {
		super(autoTx, "TicketTaskID");
	}

	public JpaTicketTaskRepository(String puname) {
		super(puname, Application.settings().getExtendedPersistenceProperties(),
				"TicketTaskID");
	}

	@Override
	public Optional<TicketTask> ofIdentity(TicketTaskID ticketTaskID){
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketTask e WHERE e.ticketTaskID = :id", TicketTask.class);
		q.setParameter("id",ticketTaskID);
		return q.getResultStream().findFirst();
	}


	@Override
	public List<TicketTask> getTicketsByCollaborator(Collaborator collab) {
		final TypedQuery<TicketTask> q = createQuery("SELECT e FROM eapli.base.ticketTask.domain.TicketTask e WHERE e.approvedBy=:approvedBy", TicketTask.class);
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
}