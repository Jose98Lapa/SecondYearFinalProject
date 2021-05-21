package eapli.base.persistence.impl.inmemory;

import eapli.base.criticality.domain.ApprovalObjective;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityValue;
import eapli.base.criticality.domain.ResolutionObjective;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCriticalityRepository extends InMemoryDomainRepository<Criticality, Long>
        implements CriticalityRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Criticality> findAllGlobal() {
        return null;
    }

    @Override
    public Optional<ApprovalObjective> ofApprovalObjective(String tempoMaximoA, String tempoMedioA) {
        return Optional.empty();
    }

    @Override
    public Optional<ResolutionObjective> ofResolutionObjective(String tempoMaximoR, String tempoMedioR) {
        return Optional.empty();
    }
}
