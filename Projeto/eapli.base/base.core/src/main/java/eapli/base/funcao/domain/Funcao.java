package eapli.base.funcao.domain;

import eapli.framework.domain.model.AggregateRoot;

public class Funcao implements AggregateRoot<IdFuncao> {

    private IdFuncao idFuncao;
    private Designacao designacao;

    public Funcao(IdFuncao idFuncao, Designacao designacao){
        this.idFuncao = idFuncao;
        this.designacao = designacao;
    }

    protected Funcao(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(IdFuncao other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public IdFuncao identity() {
        return idFuncao;
    }

    @Override
    public boolean hasIdentity(IdFuncao otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }
}
