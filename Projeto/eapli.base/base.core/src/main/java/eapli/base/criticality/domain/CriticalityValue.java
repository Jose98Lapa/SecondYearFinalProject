package eapli.base.criticality.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CriticalityValue implements ValueObject, Comparable<CriticalityValue>, Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    private String valor;

    public CriticalityValue(String valor){
        if (valor == null || valor.isEmpty() || !valor.matches("^\\d+$"))
            throw new IllegalArgumentException("Valor da criticidade nao cumpre os critérios");
        this.valor = valor;
    }

    protected CriticalityValue(){}

    public String valor(){
        return  this.valor;
    }

    @Override
    public int compareTo(CriticalityValue o) {
       if (valor.equals(o.valor))
           return 1;
       return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriticalityValue that = (CriticalityValue) o;
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
