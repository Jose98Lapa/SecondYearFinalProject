package eapli.base.criticidade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ObjetivoDeResolucao extends ObjetivoSLA implements ValueObject {
    private String tempoMaximoR;
    private String tempoMedioR;

    public ObjetivoDeResolucao(String tempMaxR, String tempMedR) {
        if (tempMaxR.isEmpty()  || tempMedR.isEmpty() )
            throw new IllegalArgumentException("Tempo Maximo/Medio nao pode(m) estar vazio");
        this.tempoMaximoR=tempMaxR;
        this.tempoMedioR=tempMedR;
    }

    protected ObjetivoDeResolucao() {}

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
        ObjetivoDeResolucao that = (ObjetivoDeResolucao) o;
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
