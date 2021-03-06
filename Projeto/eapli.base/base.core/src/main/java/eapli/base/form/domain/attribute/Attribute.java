package eapli.base.form.domain.attribute;

import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Attribute implements DomainEntity<AttributeID>, DTOable<AttributeDTO>, Serializable {

    @EmbeddedId
    private AttributeID AttributeID;
    private AtributteName nome;
    private AttributeLabel label;
    private AttributeDescription desc;
    private AttributeRegex regex;
    private AttributeType tipo;
    private int number;

    @Version
    Long version ;

    public Attribute(AtributteName nome, AttributeLabel label, AttributeDescription desc, AttributeRegex regex, AttributeType tipo, AttributeID id, int number ) {
        this.nome = nome;
        this.label = label;
        this.desc = desc;
        this.regex = regex;
        this.tipo = tipo;
        this.AttributeID = id;
        //Preconditions.noneNull();
        this.number = number;

    }

    protected Attribute() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(nome, attribute.nome) && Objects.equals(label, attribute.label) && Objects.equals(desc, attribute.desc) && Objects.equals(regex, attribute.regex) && Objects.equals(tipo, attribute.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, label, desc, regex, tipo);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
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

    @Override
    public AttributeDTO toDTO() {
        return new AttributeDTO( nome.nome(), label.label(), desc.descricao(), regex.regex(), tipo.tipo(), AttributeID.id(), number);
    }

    public int number() {
        return number;
    }

    public AttributeLabel label() {
        return label;
    }

    @Override
    public AttributeID identity() {
        return AttributeID;
    }
}
