package eapli.base.persistence.impl.jpa;

import eapli.base.funcao.domain.Funcao;
import eapli.base.funcao.domain.IdFuncao;
import eapli.base.funcao.repositories.FuncaoRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaFuncaoReposiory extends JpaAutoTxRepository<Funcao, IdFuncao, IdFuncao> implements FuncaoRepository {

    public JpaFuncaoReposiory(TransactionalContext tx) {
        super(tx,"IdFuncao");
    }

    public JpaFuncaoReposiory(String persistenceUnitName) {
        super(persistenceUnitName, "IdFuncao");
    }
}
