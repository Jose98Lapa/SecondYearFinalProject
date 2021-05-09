package eapli.base.criticidade.domain;

import javax.persistence.Embeddable;

@Embeddable
public class ObjetivoDeResolucao extends ObjetivoSLA{
    public ObjetivoDeResolucao(String tempMaxA, String tempMedA) {
        super(tempMaxA,tempMedA);
    }

    protected ObjetivoDeResolucao() {}
}
