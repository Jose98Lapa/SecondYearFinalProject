package eapli.base.colour.Domain;

import eapli.base.colour.DTO.ColourDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Colour implements AggregateRoot<Hexadecimal>, DTOable<ColourDTO>,Serializable {
    private String nome;
    @EmbeddedId
    private Hexadecimal hexadecimalValue;

    public Colour(String nome, Hexadecimal hexadecimalValue) {
        this.nome = nome;
        this.hexadecimalValue = hexadecimalValue;
    }

    protected Colour(){

    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public Hexadecimal identity() {
        return this.hexadecimalValue;
    }

    @Override
    public ColourDTO toDTO() {
        return new ColourDTO(hexadecimalValue.toString(),nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour = (Colour) o;
        return Objects.equals(nome, colour.nome) && Objects.equals(hexadecimalValue, colour.hexadecimalValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, hexadecimalValue);
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
