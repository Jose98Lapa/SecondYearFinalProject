package eapli.base.persistence.impl.jpa;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaCollaboratorRepository extends JpaAutoTxRepository<Collaborator, MecanographicNumber, MecanographicNumber> implements CollaboratorRepository {

    public JpaCollaboratorRepository(TransactionalContext tx) {
        super(tx,"MecanographicNumber");
    }

    public JpaCollaboratorRepository(String persistenceUnitName) {
        super(persistenceUnitName, "MecanographicNumber");
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
}
