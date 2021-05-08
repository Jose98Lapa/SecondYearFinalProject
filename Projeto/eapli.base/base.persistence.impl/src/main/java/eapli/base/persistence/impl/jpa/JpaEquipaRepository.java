package eapli.base.persistence.impl.jpa;

import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.domain.EquipaID;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaEquipaRepository extends JpaAutoTxRepository<Equipa, EquipaID,EquipaID> implements EquipaRepository {
    public JpaEquipaRepository(TransactionalContext tx) {
        super(tx,"EquipaID");
    }

    public JpaEquipaRepository(String persistenceUnitName) {
        super(persistenceUnitName, "EquipaID");
    }
}
