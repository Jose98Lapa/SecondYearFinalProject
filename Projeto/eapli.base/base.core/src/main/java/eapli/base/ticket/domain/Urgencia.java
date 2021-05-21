package eapli.base.ticket.domain;

import eapli.base.criticality.domain.CriticalityValue;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Transient;
import java.util.Objects;

public class Urgencia  implements ValueObject, Comparable<CriticalityValue> {
    @Transient
    private static final long serialVersionUID = 1L;

    private String urgency;

    public Urgencia(String urgency){
        if (urgency == null || urgency.isEmpty() || !urgency.matches("^\\d+$"))
            throw new IllegalArgumentException("Valor da urgencia nao cumpre os critérios");
        this.urgency = urgency;
    }

    protected Urgencia(){}

    public String urgency(){
        return  this.urgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urgencia urgencia = (Urgencia) o;
        return Objects.equals(urgency, urgencia.urgency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urgency);
    }

    @Override
    public String toString() {
        return this.urgency;
    }

    @Override
    public int compareTo(CriticalityValue o) {
        return 0;
    }
}
