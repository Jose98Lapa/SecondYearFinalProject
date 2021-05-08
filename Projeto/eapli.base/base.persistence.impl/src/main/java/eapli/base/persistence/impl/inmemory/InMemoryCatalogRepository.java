package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.CatalogoID;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCatalogRepository
        extends InMemoryDomainRepository<Catalogo, CatalogoID>
        implements CatalogRepository {

    static {
        InMemoryInitializer.init();
    }

}
