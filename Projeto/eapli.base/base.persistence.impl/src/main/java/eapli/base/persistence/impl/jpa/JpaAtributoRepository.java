package eapli.base.persistence.impl.jpa;

import eapli.base.atributo.domain.Atributo;
import eapli.base.atributo.domain.AtributoNome;
import eapli.base.atributo.repository.AtributoRepository;
import eapli.base.formulario.repository.FormularioRepository;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.domain.TeamTypeID;
import eapli.base.teamtype.repositories.TeamTypeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaAtributoRepository extends JpaAutoTxRepository<Atributo, AtributoNome,AtributoNome> implements AtributoRepository {

    public JpaAtributoRepository(TransactionalContext tx) {
        super(tx,"CatalogID");
    }

    public JpaAtributoRepository(String persistenceUnitName) {
        super(persistenceUnitName, "CatalogID");
    }
}

