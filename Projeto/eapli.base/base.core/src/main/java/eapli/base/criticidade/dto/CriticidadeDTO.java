package eapli.base.criticidade.dto;

import eapli.base.criticidade.domain.Label;
import eapli.base.criticidade.domain.ObjetivoDeAprovacao;
import eapli.base.criticidade.domain.ObjetivoDeResolucao;
import eapli.base.criticidade.domain.ValorCriticidade;

public class CriticidadeDTO {
    public String label;
    public String valorCriticidade;
    public String tempoMaximoA;
    public String tempoMedioA;
    public String tempoMaximoR;
    public String tempoMedioR;

    public CriticidadeDTO(String label, String valorCriticidade, String tempoMaximoA, String tempoMedioA, String tempoMaximoR, String tempoMedioR) {
        this.label = label;
        this.valorCriticidade = valorCriticidade;
        this.tempoMaximoA = tempoMaximoA;
        this.tempoMedioA = tempoMedioA;
        this.tempoMaximoR = tempoMaximoR;
        this.tempoMedioR = tempoMedioR;
    }

    public CriticidadeDTO(Label label,ValorCriticidade valorCriticidade, ObjetivoDeAprovacao objAprovacao, ObjetivoDeResolucao objResolucao) {
        this.label = label.toString();
        this.valorCriticidade = valorCriticidade.toString();
        this.tempoMaximoA = objAprovacao.tempoMaximo();
        this.tempoMedioA = objAprovacao.tempoMedio();
        this.tempoMaximoR = objResolucao.tempoMaximo();
        this.tempoMedioR = objResolucao.tempoMedio();
    }
}
