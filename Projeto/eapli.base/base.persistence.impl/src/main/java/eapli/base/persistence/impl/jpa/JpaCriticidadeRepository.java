package eapli.base.persistence.impl.jpa;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.domain.ValorCriticidade;
import eapli.base.criticidade.repository.CriticidadeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCriticidadeRepository extends JpaAutoTxRepository<Criticidade, ValorCriticidade,ValorCriticidade> implements CriticidadeRepository {

    public JpaCriticidadeRepository(TransactionalContext tx) {
        super(tx,"ValorCriticidade");
    }

    public JpaCriticidadeRepository(String persistenceUnitName) {
        super(persistenceUnitName, "ValorCriticidade");
    }
}
