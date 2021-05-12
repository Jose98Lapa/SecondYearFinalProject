package eapli.base.persistence.impl.jpa;

import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.repository.FormRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.base.Application;

public class JpaFormRepository extends JpaAutoTxRepository<Form, FormID, FormID> implements FormRepository {
/*    public JpaFormularioRepository(TransactionalContext tx) {
        super(tx,"FormularioID");
    }

    public JpaFormularioRepository(String persistenceUnitName) {
        super(persistenceUnitName, "FormularioID");
    }*/

    public JpaFormRepository(TransactionalContext autoTx) {
        super(autoTx, "FormularioID");
    }

    public JpaFormRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "FormularioID");
    }

}