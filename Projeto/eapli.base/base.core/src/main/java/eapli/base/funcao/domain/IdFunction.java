package eapli.base.funcao.domain;

import eapli.base.colaborador.domain.MecanographicNumber;
import eapli.framework.domain.model.ValueObject;

public class IdFunction implements ValueObject, Comparable<IdFunction> {

    private String idFuncao;

    public IdFunction(final String idFuncao){
        if (idFuncao==null ||idFuncao.isEmpty()||!idFuncao.matches("^[0-9]{0,6}$"))
            throw new IllegalArgumentException("The function ID does not fit the criteria");
        this.idFuncao = idFuncao;
    }

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
    public int compareTo(final IdFunction arg0) {
        return idFuncao.compareTo(arg0.idFuncao);
    }
}
