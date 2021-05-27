package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Localization implements ValueObject, Serializable {
    private String localizacao;

    public Localization(String localizacao) {
        if (localizacao==null ||localizacao.isEmpty()||!localizacao.matches("^[a-zA-Z]+(?:[\\s-][A-zÀ-ú]+)*$"))
            throw new IllegalArgumentException("Localizacao nao cumpre os critérios");
        this.localizacao = localizacao;
    }

    protected Localization(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localization that = (Localization) o;
        return localizacao.equals(that.localizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localizacao);
    }

    @Override
    public String toString() {
        return this.localizacao;
    }
}
