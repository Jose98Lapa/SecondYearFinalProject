package eapli.base.persistence.impl.jpa;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.CatalogoID;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCatalogRepository extends JpaAutoTxRepository<Catalogo, Long, Long> implements CatalogRepository {

    public JpaCatalogRepository(TransactionalContext tx) {
        super(tx,"CatalogID");
    }

    public JpaCatalogRepository(String persistenceUnitName) {
        super(persistenceUnitName, "CatalogID");
    }
}
