package eapli.base.funcao.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class IdFuncao implements ValueObject, Comparable<IdFuncao> {

    private String idFuncao;

    public IdFuncao(final String idFuncao){
        if (idFuncao==null ||idFuncao.isEmpty()||!idFuncao.matches("^[0-9]{0,6}$"))
            throw new IllegalArgumentException("The function ID does not fit the criteria");
        this.idFuncao = idFuncao;
    }

    protected IdFuncao() {}

    public String getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(String idFuncao) {
        this.idFuncao = idFuncao;
    }

    @Override
    public String toString() {
        return this.idFuncao;
    }

    @Override
    public int compareTo(final IdFuncao arg0) {
        return idFuncao.compareTo(arg0.idFuncao);
    }
}
