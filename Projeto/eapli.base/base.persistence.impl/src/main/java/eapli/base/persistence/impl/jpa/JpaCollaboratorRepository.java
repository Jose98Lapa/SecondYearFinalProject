package eapli.base.persistence.impl.jpa;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.function.domain.Function;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketStatus;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaCollaboratorRepository extends JpaAutoTxRepository<Collaborator, MecanographicNumber, MecanographicNumber> implements CollaboratorRepository {

    public JpaCollaboratorRepository(TransactionalContext tx) {
        super(tx,"MecanographicNumber");
    }

    public JpaCollaboratorRepository(String persistenceUnitName) {
        super(persistenceUnitName, "MecanographicNumber");
    }


    @Override
    public Iterable<Collaborator> getCollaboratorsByRole(Function function) {
        final TypedQuery<Collaborator> q = createQuery("Select e From eapli.base.collaborator.domain.Collaborator e where e.function =:function ", Collaborator.class);
        q.setParameter("function", function);
        return q.getResultList();
    }

    @Override
    public Optional<Collaborator> ofIdentity(MecanographicNumber id){
        final TypedQuery<Collaborator> q = createQuery("Select e From eapli.base.collaborator.domain.Collaborator e where e.mNumber =:id ", Collaborator.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }

    @Override
    public Optional<Collaborator> getColaboradorByEmail(InstituionalEmail email) {
        final TypedQuery<Collaborator> q = createQuery("Select e From eapli.base.collaborator.domain.Collaborator e where e.email =:id ", Collaborator.class);
        q.setParameter("id", email);
        return q.getResultStream().findFirst();
    }

    @Override
    public List<Collaborator> getCollaboratorListByFunction(Function function) {
        final TypedQuery<Collaborator> q = createQuery("Select e From eapli.base.collaborator.domain.Collaborator e where e.function =:id ", Collaborator.class);
        q.setParameter("id", function);
        return q.getResultList();
    }
}
