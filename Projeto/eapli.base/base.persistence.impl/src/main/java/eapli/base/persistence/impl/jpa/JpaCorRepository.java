package eapli.base.persistence.impl.jpa;

import eapli.base.cor.Domain.Cor;
import eapli.base.cor.Domain.Hexadecimal;
import eapli.base.cor.reposotories.CorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCorRepository extends JpaAutoTxRepository<Cor, Hexadecimal,Hexadecimal> implements CorRepository {
    public JpaCorRepository(TransactionalContext tx) {
        super(tx,"CorID");
    }

    public JpaCorRepository(String persistenceUnitName) {
        super(persistenceUnitName, "CorID");
    }
}
