package eapli.base.persistence.impl.jpa;

import eapli.base.form.DTO.FormDTO;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.repository.FormRepository;
import eapli.base.service.domain.Service;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.base.Application;

import javax.persistence.TypedQuery;
import java.util.Optional;

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

    @Override
    public Optional<Form> ofIdentity(FormID id) {
        final TypedQuery< Form > query =
                createQuery("Select e From eapli.base.form.domain.Form e where e.id =: id ",
                        Form.class);
        query.setParameter(  "id", id );
        return query.getResultStream().findFirst();
    }

    @Override
    public Optional< FormDTO > findByFormID ( FormID formID ) {

        Optional< FormDTO > formDTO;

        final TypedQuery< Form > query =
                createQuery("Select e From eapli.base.form.domain.Form e where e.id =: id ",
                        Form.class);
        query.setParameter(  "id", formID );
        formDTO = Optional.of( query.getSingleResult().toDTO() );

        return formDTO;
    }

}