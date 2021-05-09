package eapli.base.criticidade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ObjetivoSLA implements ValueObject {
    private String tempoMax;
    private String tempoMedio;

    public ObjetivoSLA(final String tempoMax,final String tempoMedio){
        this.tempoMax=tempoMax;
        this.tempoMedio=tempoMedio;
    }

    protected ObjetivoSLA(){}

    public String tempoMax(){return tempoMax;}

    public String tempoMedio(){return tempoMax;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjetivoSLA that = (ObjetivoSLA) o;
        return tempoMax.equals(that.tempoMax) && tempoMedio.equals(that.tempoMedio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempoMax, tempoMedio);
    }

    @Override
    public String toString() {
        return "Tempo Maximo: " + tempoMax + "\nTempo Médio: " +tempoMedio;
    }
}
