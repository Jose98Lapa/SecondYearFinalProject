package eapli.base.service.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class IconServico implements ValueObject {
    private String  icon;

    public IconServico(String temp) {
        this.icon = temp;
    }

    protected IconServico() {

    }

    public static IconServico valueof(String icon) {
        return new IconServico(icon);
    }

    @Override
    public String toString() {
        return icon;
    }
}
