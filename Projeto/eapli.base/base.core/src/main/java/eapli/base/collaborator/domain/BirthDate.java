package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BirthDate implements ValueObject, Serializable {

    private String dataDeNascimento;

    public BirthDate(String dataDeNascimento){
        if (dataDeNascimento==null ||dataDeNascimento.isEmpty()||!dataDeNascimento.matches("^(0?[1-9]|1[0-9]|2[0-9]|30|31)/(0?[1-9]|1[0-2])/(1[0-9]{3}|2[0-9]{3})$"))
            throw new IllegalArgumentException("Data de nascimento nao cumpre os critérios");
        this.dataDeNascimento = dataDeNascimento;
    }

    protected BirthDate() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate that = (BirthDate) o;
        return dataDeNascimento.equals(that.dataDeNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataDeNascimento);
    }

    @Override
    public String toString() {
        return this.dataDeNascimento;
    }
}
