package eapli.base.persistence.impl.jpa;

import eapli.base.function.domain.Function;
import eapli.base.function.domain.IdFunction;
import eapli.base.function.repositories.FunctionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaFunctionReposiory extends JpaAutoTxRepository<Function, IdFunction, IdFunction> implements FunctionRepository {

    public JpaFunctionReposiory(TransactionalContext tx) {
        super(tx,"IdFuncao");
    }

    public JpaFunctionReposiory(String persistenceUnitName) {
        super(persistenceUnitName, "IdFuncao");
    }
}
