package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class DataDeNascimento implements ValueObject {

    private String dataDeNascimento;

    public DataDeNascimento(String dataDeNascimento){
        if (dataDeNascimento==null ||dataDeNascimento.isEmpty()||!dataDeNascimento.matches("^([0-9]{1,2}/){2}[0-9]{4}$"))
            throw new IllegalArgumentException("Date of Birth does not fit the criteria");
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataDeNascimento that = (DataDeNascimento) o;
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
