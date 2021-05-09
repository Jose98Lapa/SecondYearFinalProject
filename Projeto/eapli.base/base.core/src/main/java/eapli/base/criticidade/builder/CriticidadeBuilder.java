package eapli.base.criticidade.builder;

import eapli.base.criticidade.domain.*;
import eapli.framework.domain.model.DomainFactory;

public class CriticidadeBuilder implements DomainFactory<Criticidade> {
    private ValorCriticidade valorCriticidade;
    private Label label;
    private ObjetivoDeResolucao objetivoDeResolucao;
    private ObjetivoDeAprovacao objetivoDeAprovacao;

    public CriticidadeBuilder withValorCriticidade(final ValorCriticidade valorCriticidade) {
        this.valorCriticidade = valorCriticidade;
        return this;
    }

    public CriticidadeBuilder withValorCriticidade(final String valorCriticidade) {
        this.valorCriticidade = new ValorCriticidade(valorCriticidade);
        return this;
    }

    public CriticidadeBuilder withLabel(final Label label) {
        this.label = label;
        return this;
    }

    public CriticidadeBuilder withLabel(final String label) {
        this.label = new Label(label);
        return this;
    }

    public CriticidadeBuilder withObjetivoDeAprovacao(final ObjetivoDeAprovacao objetivoDeAprovacao) {
        this.objetivoDeAprovacao = objetivoDeAprovacao;
        return this;
    }

    public CriticidadeBuilder withObjetivoDeAprovacao(final String tempMaxA, final String tempMedA) {
        this.objetivoDeAprovacao = new ObjetivoDeAprovacao(tempMaxA,tempMedA);
        return this;
    }

    public CriticidadeBuilder withObjetivoDeResolucao(final ObjetivoDeResolucao objetivoDeResolucao) {
        this.objetivoDeResolucao = objetivoDeResolucao;
        return this;
    }

    public CriticidadeBuilder withObjetivoDeResolucao(final String tempMaxR, final String tempMedR) {
        this.objetivoDeResolucao = new ObjetivoDeResolucao(tempMaxR,tempMedR);
        return this;
    }

    @Override
    public Criticidade build() {
        return new Criticidade(label,valorCriticidade,objetivoDeAprovacao,objetivoDeResolucao);
    }
}
