package eapli.base.funcao.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdFuncao idFuncao1 = (IdFuncao) o;
        return Objects.equals(idFuncao, idFuncao1.idFuncao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFuncao);
    }
}
