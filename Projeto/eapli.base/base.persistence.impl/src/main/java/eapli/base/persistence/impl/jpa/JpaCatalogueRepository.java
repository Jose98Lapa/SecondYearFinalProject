package eapli.base.persistence.impl.jpa;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaCatalogueRepository extends JpaAutoTxRepository<Catalogue, Long, Long> implements CatalogueRepository {

    public JpaCatalogueRepository(TransactionalContext tx) {
        super(tx,"CatalogID");
    }

    public JpaCatalogueRepository(String persistenceUnitName) {
        super(persistenceUnitName, "CatalogID");
    }

    @Override
    public Optional<Catalogue> ofIdentity(Long id) {
        final TypedQuery<Catalogue> q = createQuery("Select e From eapli.base.catalogue.domain.Catalogue e where e.identity =:id ", Catalogue.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }
}
