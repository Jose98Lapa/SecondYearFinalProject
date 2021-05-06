package eapli.base.catalogo.domain;

import eapli.framework.domain.model.ValueObject;

public class Icon implements ValueObject {
    String iconPath;

    public Icon(String icon) {
        this.iconPath = icon;
    }
}
