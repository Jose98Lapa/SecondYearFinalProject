package eapli.base.funcao.domain;

import eapli.base.funcao.DTO.FuncaoDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Funcao implements AggregateRoot<IdFuncao>, DTOable<FuncaoDTO> {

    @EmbeddedId
    private IdFuncao idFuncao;
    @Column(name = "DESIGNACAO", columnDefinition = "VARCHAR(255)")
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

    @Override
    public FuncaoDTO toDTO() {
        return new FuncaoDTO(idFuncao,designacao);
    }
}
