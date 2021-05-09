package eapli.base.criticidade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ObjetivoDeResolucao extends ObjetivoSLA implements ValueObject {
    public ObjetivoDeResolucao(String tempMaxA, String tempMedA) {
        super(tempMaxA,tempMedA);
    }

    protected ObjetivoDeResolucao() {}
}
