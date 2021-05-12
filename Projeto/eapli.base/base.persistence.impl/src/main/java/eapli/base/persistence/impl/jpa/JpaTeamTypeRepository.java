package eapli.base.persistence.impl.jpa;

import eapli.base.teamType.Domain.TeamType;
import eapli.base.teamType.Domain.TeamTypeID;
import eapli.base.teamType.repository.TeamTypeRepository;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaTeamTypeRepository extends JpaAutoTxRepository<TeamType, TeamTypeID, TeamTypeID> implements TeamTypeRepository {
    public JpaTeamTypeRepository(TransactionalContext tx) {
        super(tx,"TipoEquipaID");
    }

    public JpaTeamTypeRepository(String persistenceUnitName) {
        super(persistenceUnitName, "TipoEquipaID");
    }

    @Override
    public Optional<TeamType> ofIdentity(TeamTypeID id) {
        final TypedQuery<TeamType> q = createQuery("SELECT e FROM eapli.base.TeamType.Domain.TeamType e WHERE e.teamTypeID = :id", TeamType.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }
}
