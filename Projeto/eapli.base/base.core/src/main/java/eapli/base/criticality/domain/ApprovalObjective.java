package eapli.base.criticality.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ApprovalObjective extends SLAObjective implements ValueObject, Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String tempoMaximoA;
    private String tempoMedioA;

    public ApprovalObjective(String tempMaxA, String tempMedA) {
        if (tempMaxA==null ||tempMaxA.isEmpty()||!tempMedA.matches("^([0-1]{1}[0-9]{1}|2{1}[0-4]{1}|[0-9]{1})\\:([0-5]{1}[0-9]{1}|60)$"))
            throw new IllegalArgumentException("Tempo Máximo de aprovação nao cumpre os critérios");
        this.tempoMaximoA=tempMaxA;
        if (tempMedA==null ||tempMedA.isEmpty()||!tempMedA.matches("^([0-1]{1}[0-9]{1}|2{1}[0-4]{1}|[0-9]{1})\\:([0-5]{1}[0-9]{1}|60)$"))
            throw new IllegalArgumentException("Tempo Médio de aprovação cumpre os critérios");
        this.tempoMedioA=tempMedA;
    }


    protected ApprovalObjective() {}

    public String tempoMaximo() {
        return tempoMaximoA;
    }

    public String tempoMedio() {
        return tempoMedioA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApprovalObjective that = (ApprovalObjective) o;
        return tempoMaximoA.equals(that.tempoMaximoA) && tempoMedioA.equals(that.tempoMedioA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempoMaximoA, tempoMedioA);
    }

    @Override
    public String toString() {
        return "TempoMaximo: "+tempoMaximoA+"TempoMedio: "+tempoMedioA;
    }
}
