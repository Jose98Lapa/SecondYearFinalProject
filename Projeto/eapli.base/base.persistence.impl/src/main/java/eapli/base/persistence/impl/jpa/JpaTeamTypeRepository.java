package eapli.base.persistence.impl.jpa;

import eapli.base.teamtype.repositories.TeamTypeRepository;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.domain.TeamTypeID;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaTeamTypeRepository extends JpaAutoTxRepository<TeamType,TeamTypeID,TeamTypeID> implements TeamTypeRepository {

    public JpaTeamTypeRepository(TransactionalContext tx) {
        super(tx,"TeamTypeID");
    }

    public JpaTeamTypeRepository(String persistenceUnitName) {
        super(persistenceUnitName, "TeamTypeID");
    }

    /**
     * returns the client user (utente) with the given mecanographic number
     *
     * @return
     */
    @Override
    public Iterable<TeamType> findAll() {
        final TypedQuery<TeamType> q = createQuery("SELECT e FROM TeamType e",
                TeamType.class);
        return q.getResultList();
    }
}
