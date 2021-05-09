package eapli.base.criticidade.domain;

import javax.persistence.Embeddable;

@Embeddable
public class ObjetivoDeAprovacao extends ObjetivoSLA{
    public ObjetivoDeAprovacao(String tempMaxA, String tempMedA) {
        super(tempMaxA,tempMedA);
    }

    protected ObjetivoDeAprovacao() {}
}
