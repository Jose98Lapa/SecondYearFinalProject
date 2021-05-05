package eapli.base.persistence.impl.inmemory;

import eapli.base.catalog.domain.Catalog;
import eapli.base.catalog.domain.CatalogID;
import eapli.base.catalog.repositories.CatalogRepository;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.domain.TeamTypeID;
import eapli.base.teamtype.repositories.TeamTypeRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCatalogRepository
        extends InMemoryDomainRepository<Catalog, CatalogID>
        implements CatalogRepository {

    static {
        InMemoryInitializer.init();
    }

}
