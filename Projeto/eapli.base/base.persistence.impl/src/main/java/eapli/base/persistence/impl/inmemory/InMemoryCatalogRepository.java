package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.CatalogID;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCatalogRepository
        extends InMemoryDomainRepository<Catalogo, CatalogID>
        implements CatalogRepository {

    static {
        InMemoryInitializer.init();
    }

}
