package eapli.base.atributo.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import java.util.Objects;

public class Atributo implements ValueObject {
    private AtributoNome nome;
    private AtributoLabel label;
    private AtributoDescricao desc;
    private AtributoRegex regex;
    private AtributoTipo tipo;

    public Atributo(AtributoNome nome, AtributoLabel label, AtributoDescricao desc, AtributoRegex regex, AtributoTipo tipo) {
        this.nome = nome;
        this.label = label;
        this.desc = desc;
        this.regex = regex;
        this.tipo = tipo;
        Preconditions.noneNull();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atributo atributo = (Atributo) o;
        return Objects.equals(nome, atributo.nome) && Objects.equals(label, atributo.label) && Objects.equals(desc, atributo.desc) && Objects.equals(regex, atributo.regex) && Objects.equals(tipo, atributo.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, label, desc, regex, tipo);
    }

    @Override
    public String toString() {
        return "Atributo{" +
                "nome=" + nome +
                ", label=" + label +
                ", desc=" + desc +
                ", regex=" + regex +
                ", tipo=" + tipo +
                '}';
    }
}
