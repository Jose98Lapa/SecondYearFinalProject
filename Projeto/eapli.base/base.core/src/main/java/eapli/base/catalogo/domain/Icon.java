package eapli.base.catalogo.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Icon implements ValueObject {
    String iconPath;

    public Icon(String icon) {
        this.iconPath = icon;
    }

    public Icon() {
        //vazio
    }
}
