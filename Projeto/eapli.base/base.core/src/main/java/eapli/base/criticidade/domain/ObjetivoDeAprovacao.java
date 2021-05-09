package eapli.base.criticidade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ObjetivoDeAprovacao  extends ObjetivoSLA implements ValueObject{
    private String tempoMaximoA;
    private String tempoMedioA;
    public ObjetivoDeAprovacao(String tempMaxA, String tempMedA) {
        this.tempoMaximoA=tempMaxA;
        this.tempoMedioA=tempMedA;
    }

    protected ObjetivoDeAprovacao() {}

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
        ObjetivoDeAprovacao that = (ObjetivoDeAprovacao) o;
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
