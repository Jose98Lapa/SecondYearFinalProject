package eapli.base.criticality.repository;

import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityValue;
import eapli.framework.domain.repositories.DomainRepository;

public interface CriticalityRepository extends DomainRepository<CriticalityValue, Criticality> {

    Iterable<Criticality> findAll();

}
