package eapli.base.function.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IdFunction implements ValueObject, Comparable<IdFunction>, Serializable {

    private String idFuncao;

    public IdFunction(final String idFuncao){
        if (idFuncao==null ||idFuncao.isEmpty()||!idFuncao.matches("^[0-9]{0,6}$"))
            throw new IllegalArgumentException("The function ID does not fit the criteria");
        this.idFuncao = idFuncao;
    }

    protected IdFunction() {}

    public static IdFunction valueOf(String string) {
        return new IdFunction(string);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdFunction idFunction1 = (IdFunction) o;
        return Objects.equals(idFuncao, idFunction1.idFuncao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFuncao);
    }
}
