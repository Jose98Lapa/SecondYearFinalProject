package eapli.base.persistence.impl.jpa;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.cor.Domain.Cor;
import eapli.base.cor.Domain.Hexadecimal;
import eapli.base.cor.reposotories.CorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaCorRepository extends JpaAutoTxRepository<Cor, Hexadecimal,Hexadecimal> implements CorRepository {
    public JpaCorRepository(TransactionalContext tx) {
        super(tx,"CorID");
    }

    public JpaCorRepository(String persistenceUnitName) {
        super(persistenceUnitName, "CorID");
    }


    @Override
    public Optional<Cor> ofIdentity(Hexadecimal id) {
        final TypedQuery<Cor> q = createQuery("Select e From eapli.base.cor.Domain.Cor e where e.hexadecimalValue =:id ",Cor.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }
}
