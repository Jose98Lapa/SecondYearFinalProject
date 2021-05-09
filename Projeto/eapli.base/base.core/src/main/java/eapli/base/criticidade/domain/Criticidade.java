package eapli.base.criticidade.domain;

import eapli.base.colaborador.domain.NumeroMecanografico;
import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Criticidade implements AggregateRoot<ValorCriticidade>, DTOable<CriticidadeDTO> {

    @EmbeddedId
    private ValorCriticidade valorCriticidade;
    private Label label;
    private ObjetivoDeResolucao objetivoRes;
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
        return new CriticidadeDTO(label.toString(),valorCriticidade.toString(),objetivoAprov.tempoMax(),objetivoAprov.tempoMedio(),objetivoRes.tempoMax(),objetivoRes.tempoMedio());
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
        return "Valor da Criticidade: "+valorCriticidade +" Label: "+label;
    }
}
