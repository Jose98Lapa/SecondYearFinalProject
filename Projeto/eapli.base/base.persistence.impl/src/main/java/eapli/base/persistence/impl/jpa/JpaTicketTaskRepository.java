package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.domain.TicketTaskID;
import eapli.base.ticketTask.repository.TicketTaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

public class JpaTicketTaskRepository extends JpaAutoTxRepository< TicketTask, TicketTaskID, TicketTaskID > implements TicketTaskRepository {

	public JpaTicketTaskRepository( TransactionalContext autoTx) {
		super(autoTx, "TicketTaskID");
	}

	public JpaTicketTaskRepository ( String puname ) {
		super(puname, Application.settings().getExtendedPersistenceProperties(),
				"TicketTaskID");
	}

	@Override
	public List<TicketTask> getTicketsByCollaborator(Collaborator collab) {
		return null;
	}
}
