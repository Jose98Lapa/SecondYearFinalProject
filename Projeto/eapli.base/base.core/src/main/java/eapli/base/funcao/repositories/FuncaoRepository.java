package eapli.base.funcao.repositories;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.CatalogoID;
import eapli.base.funcao.domain.Funcao;
import eapli.base.funcao.domain.IdFuncao;
import eapli.framework.domain.repositories.DomainRepository;

public interface FuncaoRepository extends DomainRepository<IdFuncao, Funcao> {
}
