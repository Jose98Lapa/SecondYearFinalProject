package eapli.base.persistence.impl.inmemory;

import eapli.base.atributo.domain.Atributo;
import eapli.base.atributo.domain.AtributoNome;
import eapli.base.atributo.repository.AtributoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAtributoRepository
        extends InMemoryDomainRepository<Atributo, AtributoNome>
        implements AtributoRepository {

    static {
        InMemoryInitializer.init();
    }
}
