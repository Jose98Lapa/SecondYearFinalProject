package eapli.base.criticidade.dto;

import eapli.base.criticidade.domain.Label;
import eapli.base.criticidade.domain.ObjetivoDeAprovacao;
import eapli.base.criticidade.domain.ObjetivoDeResolucao;
import eapli.base.criticidade.domain.ValorCriticidade;
import eapli.framework.representations.dto.DTO;

@DTO
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

    @Override
    public String toString() {
        return "Valor da Criticidade: "+valorCriticidade +"\nLabel: "+label + "\nTempo Maximo de Aprovação: " + tempoMaximoA +
                " Tempo Medio de Aprovação: " + tempoMedioA + "\nTempo Maximo de Resolução: " + tempoMaximoR + " Tempo Medio de Resolução: " + tempoMedioR +"\n";
    }


}
