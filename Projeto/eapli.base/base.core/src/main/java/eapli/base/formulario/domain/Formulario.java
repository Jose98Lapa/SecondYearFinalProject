package eapli.base.formulario.domain;

import eapli.base.formulario.DTO.atributo.AtributoDTO;
import eapli.base.formulario.domain.atributo.Atributo;
import eapli.base.formulario.DTO.FormularioDTO;
import eapli.base.servico.domain.KeyWords;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Formulario implements AggregateRoot<FormularioID>, DTOable<FormularioDTO> {

    @Version
    Long version ;

    private FormularioScript script;
    @EmbeddedId
    private FormularioID FormularioID;
    private FormularioNome nome;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Atributo> atr;

    public Formulario(FormularioScript script, FormularioID id, FormularioNome nome,Set<Atributo> atr) {
        this.script = script;
        this.FormularioID = id;
        this.nome = nome;
        this.atr = atr;
        Preconditions.noneNull();
    }

    protected Formulario() {
    }

    public void add(Atributo a) {
        atr.add(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formulario that = (Formulario) o;
        return Objects.equals(script, that.script) && Objects.equals(FormularioID, that.FormularioID) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(script, FormularioID, nome);
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
                ", id=" + FormularioID +
                ", nome=" + nome +
                '}';
    }

    @Override
    public FormularioID identity() {
        return FormularioID;
    }

    @Override
    public boolean hasIdentity(FormularioID otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }

    @Override
    public FormularioDTO toDTO() {
        Set<AtributoDTO> key2 = new HashSet<>();
        for (Atributo key:atr) {
            key2.add(key.toDTO());
        }
        return new FormularioDTO(script.toString(),FormularioID.toString(),nome.toString(),key2);
    }
}
