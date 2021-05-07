package eapli.base.cor.Domain;

import eapli.base.cor.DTO.CorDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;


@Entity
public class Cor implements AggregateRoot<Hexadecimal>, DTOable<CorDTO> {
    private String nome;
    @EmbeddedId
    private Hexadecimal hexadecimalValue;

    public Cor(String nome, Hexadecimal hexadecimalValue) {
        this.nome = nome;
        this.hexadecimalValue = hexadecimalValue;
    }

    protected Cor(){

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
    public CorDTO toDTO() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cor cor = (Cor) o;
        return Objects.equals(nome, cor.nome) && Objects.equals(hexadecimalValue, cor.hexadecimalValue);
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
