package eapli.base.persistence.impl.jpa;

import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityValue;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCriticalityRepository extends JpaAutoTxRepository<Criticality, CriticalityValue, CriticalityValue> implements CriticalityRepository {

    public JpaCriticalityRepository(TransactionalContext tx) {
        super(tx,"ValorCriticidade");
    }

    public JpaCriticalityRepository(String persistenceUnitName) {
        super(persistenceUnitName, "ValorCriticidade");
    }
}
