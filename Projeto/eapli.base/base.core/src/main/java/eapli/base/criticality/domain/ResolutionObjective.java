package eapli.base.criticality.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ResolutionObjective extends SLAObjective implements ValueObject , Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String tempoMaximoR;
    private String tempoMedioR;

    public ResolutionObjective(String tempMaxR, String tempMedR) {
        if (tempMaxR==null ||tempMaxR.isEmpty()||!tempMaxR.matches("^([0-1]{1}[0-9]{1}|2{1}[0-4]{1}|[0-9]{1})\\:([0-5]{1}[0-9]{1}|60)$"))
            throw new IllegalArgumentException("Tempo Máximo de resolução os critérios");
        this.tempoMaximoR=tempMaxR;
        if (tempMedR==null ||tempMedR.isEmpty()||!tempMedR.matches("^([0-1]{1}[0-9]{1}|2{1}[0-4]{1}|[0-9]{1})\\:([0-5]{1}[0-9]{1}|60)$"))
            throw new IllegalArgumentException("Tempo Médio de resolução cumpre os critérios");
        this.tempoMedioR=tempMedR;
    }

    protected ResolutionObjective() {}

    public String tempoMaximo() {
        return tempoMaximoR;
    }

    public String tempoMedio() {
        return tempoMedioR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResolutionObjective that = (ResolutionObjective) o;
        return tempoMaximoR.equals(that.tempoMaximoR) && tempoMedioR.equals(that.tempoMedioR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempoMaximoR, tempoMedioR);
    }

    @Override
    public String toString() {
        return "TempoMaximo: "+tempoMaximoR+"TempoMedio: "+tempoMedioR;
    }
}
