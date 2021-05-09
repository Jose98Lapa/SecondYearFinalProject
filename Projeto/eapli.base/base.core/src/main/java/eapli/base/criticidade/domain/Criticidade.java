package eapli.base.criticidade.domain;

import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Criticidade implements AggregateRoot<ValorCriticidade>, DTOable<CriticidadeDTO> {

    @EmbeddedId
    private ValorCriticidade valorCriticidade;
    private Label label;
    @Column @JoinColumn
    private ObjetivoDeResolucao objetivoRes;
    @Column @JoinColumn
    private ObjetivoDeAprovacao objetivoAprov;

    public Criticidade(Label label, ValorCriticidade valor, ObjetivoDeAprovacao objetivoAprov, ObjetivoDeResolucao objetivoRes) {
        this.label = label;
        this.valorCriticidade = valor;
        this.objetivoRes = objetivoRes;
        this.objetivoAprov = objetivoAprov;
    }

    protected Criticidade() {}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public ValorCriticidade identity() {
        return this.valorCriticidade;
    }

    @Override
    public boolean hasIdentity(ValorCriticidade valorCriticidade) {return AggregateRoot.super.hasIdentity(valorCriticidade);}

    @Override
    public CriticidadeDTO toDTO() {
        return new CriticidadeDTO(label.toString(),valorCriticidade.toString(),objetivoAprov.tempoMaximo(),objetivoAprov.tempoMedio(),objetivoRes.tempoMaximo(),objetivoRes.tempoMedio());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criticidade that = (Criticidade) o;
        return valorCriticidade.equals(that.valorCriticidade) && label.equals(that.label) && objetivoRes.equals(that.objetivoRes) && objetivoAprov.equals(that.objetivoAprov);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorCriticidade, label, objetivoRes, objetivoAprov);
    }

    @Override
    public String toString() {
        return "Valor da Criticidade: "+valorCriticidade +"\nLabel: "+label + "\nTempo Maximo de Aprovação: " + objetivoAprov.tempoMaximo() +
                " Tempo Medio de Aprovação: " + objetivoAprov.tempoMedio() + "\nTempo Maximo de Resolução: " + objetivoAprov.tempoMaximo() + " Tempo Medio de Resolução: " + objetivoAprov.tempoMedio() +"\n";
    }
}
