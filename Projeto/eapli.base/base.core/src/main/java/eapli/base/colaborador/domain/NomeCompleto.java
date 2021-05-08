package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class NomeCompleto implements ValueObject {

    private String name;

    public NomeCompleto(final String name) {
        if (name == null || name.isEmpty() || !name.matches("^[A-zÀ-ú]{4,}(?: [a-zA-Z]+){0,2}$"))
            throw new IllegalArgumentException("Nome completo nao cumpre os critérios");
        this.name = name;
    }

    protected NomeCompleto() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NomeCompleto nomeCompleto1 = (NomeCompleto) o;
        return name.equals(nomeCompleto1.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
