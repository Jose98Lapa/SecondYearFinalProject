package eapli.base.persistence.impl.jpa;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.NumeroMecanografico;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaCollaboratorRepository extends JpaAutoTxRepository<Colaborador, NumeroMecanografico, NumeroMecanografico> implements CollaboratorRepository {

    public JpaCollaboratorRepository(TransactionalContext tx) {
        super(tx,"MecanographicNumber");
    }

    public JpaCollaboratorRepository(String persistenceUnitName) {
        super(persistenceUnitName, "MecanographicNumber");
    }

    /**
     * returns the client user (utente) with the given mecanographic number
     *
     * @return
     */
    @Override
    public Iterable<Colaborador> findAll() {
        final TypedQuery<Colaborador> q = createQuery("SELECT e FROM Collaborator e",
                Colaborador.class);
        return q.getResultList();
    }
}
