package eapli.base.criticidade.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ValorCriticidade implements ValueObject, Comparable<ValorCriticidade> {
    private String valor;

    public ValorCriticidade(String valor){
        if (valor == null || valor.isEmpty() || !valor.matches("^\\d+$"))
            throw new IllegalArgumentException("Valor da criticidade nao cumpre os critérios");
        this.valor = valor;
    }

    protected ValorCriticidade(){}

    public String valor(){
        return  this.valor;
    }

    @Override
    public int compareTo(ValorCriticidade o) {
       if (valor.equals(o.valor))
           return 1;
       return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValorCriticidade that = (ValorCriticidade) o;
        return valor.equals(that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return this.valor;
    }
}
