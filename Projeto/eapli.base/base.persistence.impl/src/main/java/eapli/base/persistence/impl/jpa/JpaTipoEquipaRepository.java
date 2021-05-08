package eapli.base.persistence.impl.jpa;

import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.TipoEquipa.Domain.TipoEquipaID;
import eapli.base.TipoEquipa.repository.TipoEquipaRepository;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaTipoEquipaRepository extends JpaAutoTxRepository<TipoEquipa, TipoEquipaID,TipoEquipaID> implements TipoEquipaRepository {
    public JpaTipoEquipaRepository(TransactionalContext tx) {
        super(tx,"TipoEquipaID");
    }

    public JpaTipoEquipaRepository(String persistenceUnitName) {
        super(persistenceUnitName, "TipoEquipaID");
    }

    @Override
    public Optional<TipoEquipa> ofIdentity(TipoEquipaID id) {
        final TypedQuery<TipoEquipa> q = createQuery("SELECT e FROM eapli.base.TipoEquipa.Domain.TipoEquipa e WHERE e.tipoEquipaID = :id",TipoEquipa.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }
}
