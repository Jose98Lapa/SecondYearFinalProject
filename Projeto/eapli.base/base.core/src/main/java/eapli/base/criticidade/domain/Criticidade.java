package eapli.base.criticidade.domain;

import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;


public class Criticidade implements AggregateRoot<Label>, DTOable<CriticidadeDTO> {

    private Label label;
    private ValorCriticidade valor;
    private ObjetivoDeResolucao objetivoRes;
    private ObjetivoDeAprovacao objetivoAprov;

    public Criticidade(Label label, ValorCriticidade valor, ObjetivoDeResolucao objetivoRes, ObjetivoDeAprovacao objetivoAprov) {
        this.label = label;
        this.valor = valor;
        this.objetivoRes = objetivoRes;
        this.objetivoAprov = objetivoAprov;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Label identity() {
        return this.label;
    }

    /**
     * Showcase the {@link DTOable} interface. In this case it is the Dish class that dictates the
     * DTO structure.
     *
     */
    @Override
    public CriticidadeDTO toDTO() {
        return new CriticidadeDTO(label.toString(),valor.valor(),objetivoRes,objetivoAprov);
    }
}
