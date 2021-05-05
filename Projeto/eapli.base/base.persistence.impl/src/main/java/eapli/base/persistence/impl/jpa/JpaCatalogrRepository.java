package eapli.base.persistence.impl.jpa;

import eapli.base.catalog.domain.Catalog;
import eapli.base.catalog.domain.CatalogID;
import eapli.base.catalog.repositories.CatalogRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCatalogrRepository extends JpaAutoTxRepository<Catalog, CatalogID,CatalogID> implements CatalogRepository {

    public JpaCatalogrRepository(TransactionalContext tx) {
        super(tx,"CatalogID");
    }

    public JpaCatalogrRepository(String persistenceUnitName) {
        super(persistenceUnitName, "CatalogID");
    }
}
