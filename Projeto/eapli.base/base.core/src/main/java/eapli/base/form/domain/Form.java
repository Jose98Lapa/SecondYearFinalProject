package eapli.base.form.domain;

import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.base.form.domain.attribute.Attribute;
import eapli.base.form.DTO.FormDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Form implements AggregateRoot<FormID>, DTOable<FormDTO> , Serializable {

    @Version
    Long version ;

    private FormScript script;
    @EmbeddedId
    private FormID FormID;
    private FormName nome;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Attribute> atr;

    public Form(FormScript script, FormID id, FormName nome, Set<Attribute> atr) {
        this.script = script;
        this.FormID = id;
        this.nome = nome;
        this.atr = atr;
        Preconditions.noneNull();
    }

    protected Form() {
    }

    public void add(Attribute a) {
        atr.add(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Form that = (Form) o;
        return Objects.equals(script, that.script) && Objects.equals(FormID, that.FormID) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(script, FormID, nome);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(FormID other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "script=" + script +
                ", id=" + FormID +
                ", nome=" + nome +
                '}';
    }

    @Override
    public FormID identity() {
        return FormID;
    }

    @Override
    public boolean hasIdentity(FormID otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }

    @Override
    public FormDTO toDTO() {
        Set<AttributeDTO> key2 = new HashSet<>();
        for (Attribute key:atr) {
            key2.add(key.toDTO());
        }
        return new FormDTO(script.toString(), FormID.toString(),nome.toString(),key2);
    }

    public FormScript script(){
        return this.script;
    }
}
