package eapli.base.persistence.impl.inmemory;

import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityValue;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCriticalityRepository extends InMemoryDomainRepository<Criticality, CriticalityValue>
        implements CriticalityRepository {

    static {
        InMemoryInitializer.init();
    }
}
