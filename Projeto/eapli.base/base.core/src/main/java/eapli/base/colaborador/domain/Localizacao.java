package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Localizacao implements ValueObject {
    private String localizacao;

    public Localizacao(String localizacao) {
        if (localizacao==null ||localizacao.isEmpty()||!localizacao.matches("^[a-zA-Z]+(?:[\\s-][A-zÀ-ú]+)*$"))
            throw new IllegalArgumentException("Localizacao nao cumpre os critérios");
        this.localizacao = localizacao;
    }

    protected Localizacao(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
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
