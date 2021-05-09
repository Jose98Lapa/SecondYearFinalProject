package eapli.base.criticidade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ObjetivoDeAprovacao  extends ObjetivoSLA implements ValueObject{
    public ObjetivoDeAprovacao(String tempMaxA, String tempMedA) {
        super(tempMaxA,tempMedA);
    }

    protected ObjetivoDeAprovacao() {}
}
