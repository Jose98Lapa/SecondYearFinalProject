package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class DataDeNascimento implements ValueObject {

    private String dataDeNascimento;

    public DataDeNascimento(String dataDeNascimento){
        if (dataDeNascimento==null ||dataDeNascimento.isEmpty()||!dataDeNascimento.matches("^(0?[1-9]|1[0-9]|2[0-9]|30|31)/(0?[1-9]|1[0-2])/(1[0-9]{3}|2[0-9]{3})$"))
            throw new IllegalArgumentException("Data de nascimento nao cumpre os critérios");
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
