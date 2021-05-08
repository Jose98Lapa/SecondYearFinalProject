package eapli.base.persistence.impl.jpa;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.CatalogoID;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.base.cor.Domain.Cor;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaCatalogRepository extends JpaAutoTxRepository<Catalogo, CatalogoID, CatalogoID> implements CatalogRepository {

    public JpaCatalogRepository(TransactionalContext tx) {
        super(tx,"CatalogID");
    }

    public JpaCatalogRepository(String persistenceUnitName) {
        super(persistenceUnitName, "CatalogID");
    }

    @Override
    public Optional<Catalogo> ofIdentity(CatalogoID id) {
        final TypedQuery<Catalogo> q = createQuery("Select e From eapli.base.catalogo.domain.Catalogo e where e.identificadorUnico =:id ",Catalogo.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }
}
