package eapli.base.persistence.impl.inmemory;

import eapli.base.cor.Domain.Cor;
import eapli.base.cor.Domain.Hexadecimal;
import eapli.base.cor.reposotories.CorRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCorRepository extends InMemoryDomainRepository<Cor, Hexadecimal> implements CorRepository {

    static {
        InMemoryInitializer.init();
    }

}
