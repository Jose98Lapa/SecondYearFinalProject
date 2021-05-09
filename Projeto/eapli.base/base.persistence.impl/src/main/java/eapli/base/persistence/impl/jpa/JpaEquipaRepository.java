package eapli.base.persistence.impl.jpa;


import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.domain.EquipaID;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.Optional;

public class JpaEquipaRepository extends JpaAutoTxRepository<Equipa, EquipaID,EquipaID> implements EquipaRepository {
    public JpaEquipaRepository(TransactionalContext tx) {
        super(tx,"EquipaID");
    }

    public JpaEquipaRepository(String persistenceUnitName) {
        super(persistenceUnitName, "EquipaID");
    }

    @Override
    public Optional<Equipa> ofIdentity(EquipaID id) {
        final TypedQuery<Equipa> q = createQuery("SELECT e FROM eapli.base.equipa.domain.Equipa e WHERE e.equipaID=:id",Equipa.class);
        q.setParameter("id",id);
        return q.getResultStream().findFirst();
    }

    @Override
    public boolean isAcronimoValid(Acronimo acronimo) {
        final TypedQuery<Long> q = createQuery("SELECT COUNT(*)  FROM eapli.base.equipa.domain.Equipa e WHERE e.acronimo = :id",Long.class);
        q.setParameter("id", acronimo);
        Long count=q.getResultStream().findFirst().get();
        return count==0;
    }

    @Override
    public boolean canIAddTheColaborador(Colaborador colaborador, TipoEquipa tipoEquipa) {
        final TypedQuery<Equipa> q = createQuery("SELECT e FROM eapli.base.equipa.domain.Equipa e WHERE e.tipoEquipa=:id",Equipa.class);
        q.setParameter("id",tipoEquipa);
        for (Iterator<Equipa> it = q.getResultStream().iterator(); it.hasNext(); ) {
            Equipa equipa = it.next();
            if (equipa.containsResponsavel(colaborador)){
                return false;
            }
        }
        return true;
    }
}
