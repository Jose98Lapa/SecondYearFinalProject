package eapli.base.persistence.impl.jpa;

import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.FormularioID;
import eapli.base.formulario.repository.FormularioRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaFormularioRepository extends JpaAutoTxRepository<Formulario, FormularioID,FormularioID> implements FormularioRepository {
    public JpaFormularioRepository(TransactionalContext tx) {
        super(tx,"FormularioID");
    }

    public JpaFormularioRepository(String persistenceUnitName) {
        super(persistenceUnitName, "FormularioID");
    }
}