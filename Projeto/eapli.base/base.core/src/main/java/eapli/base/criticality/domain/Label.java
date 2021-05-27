package eapli.base.criticality.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Label implements ValueObject, Serializable {
    private String label;

    public Label(String label) {
        if (label==null ||label.isEmpty()||!label.matches("^[ A-zÀ-ú]{1,50}$"))
            throw new IllegalArgumentException("Label nao cumpre os critérios");
        this.label = label;
    }

    protected Label(){}

    public static Label valueOf(String label) {
        return new Label(label);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label1 = (Label) o;
        return label.equals(label1.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return this.label;
    }

}
