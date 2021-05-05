package eapli.base.persistence.impl.jpa;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCollaboratorRepository extends JpaAutoTxRepository<Collaborator, MecanographicNumber,MecanographicNumber> implements CollaboratorRepository {

    public JpaCollaboratorRepository(TransactionalContext tx) {
        super(tx,"MecanographicNumber");
    }

    public JpaCollaboratorRepository(String persistenceUnitName) {
        super(persistenceUnitName, "MecanographicNumber");
    }
}
