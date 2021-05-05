package eapli.base.catalog.repositories;

import eapli.base.catalog.domain.Catalog;
import eapli.base.catalog.domain.CatalogID;
import eapli.framework.domain.repositories.DomainRepository;

public interface CatalogRepository extends DomainRepository<CatalogID, Catalog> {
}
