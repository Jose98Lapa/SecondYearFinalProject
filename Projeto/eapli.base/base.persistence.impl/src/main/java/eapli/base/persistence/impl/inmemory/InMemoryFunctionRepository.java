package eapli.base.persistence.impl.inmemory;

import eapli.base.funcao.domain.Funcao;
import eapli.base.funcao.domain.IdFuncao;
import eapli.base.funcao.repositories.FuncaoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryFunctionRepository
        extends InMemoryDomainRepository<Funcao, IdFuncao>
        implements FuncaoRepository {

    static {
        InMemoryInitializer.init();
    }
}
