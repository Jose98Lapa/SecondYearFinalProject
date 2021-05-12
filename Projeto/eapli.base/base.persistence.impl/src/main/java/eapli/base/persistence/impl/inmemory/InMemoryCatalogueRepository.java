package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCatalogueRepository
        extends InMemoryDomainRepository<Catalogue, Long>
        implements CatalogueRepository {

    static {
        InMemoryInitializer.init();
    }

}
