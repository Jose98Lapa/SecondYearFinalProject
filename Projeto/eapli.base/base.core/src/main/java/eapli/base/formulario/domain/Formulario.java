package eapli.base.formulario.domain;

import eapli.base.atributo.domain.Atributo;
import eapli.framework.domain.model.AggregateRoot;

import java.util.Objects;
import java.util.Set;

public class Formulario implements AggregateRoot<FormularioID> {
    private FormularioScript script;
    private FormularioID id;
    private FormularioNome nome ;
    private Set<Atributo> atr;

    public Formulario(FormularioScript script, FormularioID id, FormularioNome nome) {
        this.script = script;
        this.id = id;
        this.nome = nome;
    }

    public void add(Atributo a){
        atr.add(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formulario that = (Formulario) o;
        return Objects.equals(script, that.script) && Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(script, id, nome);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(FormularioID other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "script=" + script +
                ", id=" + id +
                ", nome=" + nome +
                '}';
    }

    @Override
    public FormularioID identity() {
        return id;
    }

    @Override
    public boolean hasIdentity(FormularioID otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }
}
