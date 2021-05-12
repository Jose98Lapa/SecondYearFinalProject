package eapli.base.persistence.impl.inmemory;

import eapli.base.function.domain.Function;
import eapli.base.function.domain.IdFunction;
import eapli.base.function.repositories.FunctionRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryFunctionRepository
        extends InMemoryDomainRepository<Function, IdFunction>
        implements FunctionRepository {

    static {
        InMemoryInitializer.init();
    }
}
