package eapli.base.formulario.domain;

import java.util.Objects;

public class Formulario {
    private FormularioScript script;
    private FormularioID id;
    private FormularioNome nome ;

    public Formulario(FormularioScript script, FormularioID id, FormularioNome nome) {
        this.script = script;
        this.id = id;
        this.nome = nome;
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
    public String toString() {
        return "Formulario{" +
                "script=" + script +
                ", id=" + id +
                ", nome=" + nome +
                '}';
    }
}
