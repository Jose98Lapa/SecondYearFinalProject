package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class IconServico implements ValueObject {
    private String  temp;

    public IconServico(String temp) {
        this.temp = temp;
    }

    protected IconServico() {

    }

    public static IconServico valueof(String icon) {
        return null;
    }

    @Override
    public String toString() {
        return temp;
    }
}
