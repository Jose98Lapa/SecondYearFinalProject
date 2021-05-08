package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class NomeCompleto implements ValueObject {

    private String name;

    public NomeCompleto(final String name) {
        if (name == null || name.isEmpty() || !name.matches("^([A-Z]{1}[A-zÀ-ú\\- ]{1,15}){3,5}$"))
            throw new IllegalArgumentException("Nome completo nao cumpre os critérios");
        this.name = name;
    }

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
