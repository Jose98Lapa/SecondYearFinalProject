package eapli.base.catalogue.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Icon implements ValueObject, Serializable {
    String iconPath;

    public Icon(String icon) {
        Preconditions.nonEmpty(icon, "Path não pode ser vazio.");
        this.iconPath = icon;
    }

    public Icon() {
        //vazio
    }

    @Override
    public String toString() {
        return iconPath;
    }
}
