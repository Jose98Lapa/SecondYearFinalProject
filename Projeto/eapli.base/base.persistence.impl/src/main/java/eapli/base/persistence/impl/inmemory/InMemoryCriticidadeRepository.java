package eapli.base.persistence.impl.inmemory;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.domain.ValorCriticidade;
import eapli.base.criticidade.repository.CriticidadeRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCriticidadeRepository extends InMemoryDomainRepository<Criticidade, ValorCriticidade>
        implements CriticidadeRepository {

    static {
        InMemoryInitializer.init();
    }
}
