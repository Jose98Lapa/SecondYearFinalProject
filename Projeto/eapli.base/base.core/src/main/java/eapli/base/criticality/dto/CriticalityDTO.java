package eapli.base.criticality.dto;

import eapli.base.criticality.domain.CriticalityValue;
import eapli.base.criticality.domain.Label;
import eapli.base.criticality.domain.ApprovalObjective;
import eapli.base.criticality.domain.ResolutionObjective;
import eapli.framework.representations.dto.DTO;

@DTO
public class CriticalityDTO {
    public String label;
    public String valorCriticidade;
    public String tempoMaximoA;
    public String tempoMedioA;
    public String tempoMaximoR;
    public String tempoMedioR;

    public CriticalityDTO(String label, String valorCriticidade, String tempoMaximoA, String tempoMedioA, String tempoMaximoR, String tempoMedioR) {
        this.label = label;
        this.valorCriticidade = valorCriticidade;
        this.tempoMaximoA = tempoMaximoA;
        this.tempoMedioA = tempoMedioA;
        this.tempoMaximoR = tempoMaximoR;
        this.tempoMedioR = tempoMedioR;
    }

    public CriticalityDTO(Label label, CriticalityValue criticalityValue, ApprovalObjective objAprovacao, ResolutionObjective objResolucao) {
        this.label = label.toString();
        this.valorCriticidade = criticalityValue.toString();
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
