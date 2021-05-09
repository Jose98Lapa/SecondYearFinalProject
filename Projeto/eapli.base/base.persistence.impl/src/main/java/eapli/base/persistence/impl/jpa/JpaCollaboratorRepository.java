package eapli.base.persistence.impl.jpa;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.EmailInstitucional;
import eapli.base.colaborador.domain.NumeroMecanografico;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaCollaboratorRepository extends JpaAutoTxRepository<Colaborador, NumeroMecanografico, NumeroMecanografico> implements CollaboratorRepository {

    public JpaCollaboratorRepository(TransactionalContext tx) {
        super(tx,"MecanographicNumber");
    }

    public JpaCollaboratorRepository(String persistenceUnitName) {
        super(persistenceUnitName, "MecanographicNumber");
    }


    @Override
    public Optional<Colaborador> ofIdentity(NumeroMecanografico id){
        final TypedQuery<Colaborador> q = createQuery("Select e From eapli.base.colaborador.domain.Colaborador e where e.mNumber =:id ",Colaborador.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }

    @Override
    public Optional<Colaborador> getColaboradorByEmail(EmailInstitucional email) {
        final TypedQuery<Colaborador> q = createQuery("Select e From eapli.base.colaborador.domain.Colaborador e where e.email =:id ",Colaborador.class);
        q.setParameter("id", email);
        return q.getResultStream().findFirst();
    }
}
