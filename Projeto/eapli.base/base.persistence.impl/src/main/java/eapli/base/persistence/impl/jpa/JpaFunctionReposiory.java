package eapli.base.persistence.impl.jpa;

import eapli.base.form.domain.Form;
import eapli.base.function.domain.Function;
import eapli.base.function.domain.IdFunction;
import eapli.base.function.repositories.FunctionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaFunctionReposiory extends JpaAutoTxRepository<Function, IdFunction, IdFunction> implements FunctionRepository {

    public JpaFunctionReposiory(TransactionalContext tx) {
        super(tx,"IdFuncao");
    }

    public JpaFunctionReposiory(String persistenceUnitName) {
        super(persistenceUnitName, "IdFuncao");
    }

    @Override
    public Optional<Function> ofIdentity(IdFunction id) {
        final TypedQuery<Function> query =
                createQuery("Select e From eapli.base.function.domain.Function e where e.idFunction =: id ",
                        Function.class);
        query.setParameter(  "id", id );
        return query.getResultStream().findFirst();
    }
}
