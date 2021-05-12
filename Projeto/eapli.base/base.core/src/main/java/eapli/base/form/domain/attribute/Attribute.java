package eapli.base.form.domain.attribute;

import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Attribute implements DomainEntity<AttributeID>, DTOable<AttributeDTO> {
    private AtributteName nome;
    private AttributeLabel label;
    private AttributeDescription desc;
    private AttributeRegex regex;
    private AttributeType tipo;
    @EmbeddedId
    private AttributeID AttributeID;

    @Version
    Long version ;

    public Attribute(AtributteName nome, AttributeLabel label, AttributeDescription desc, AttributeRegex regex, AttributeType tipo, AttributeID id) {
        this.nome = nome;
        this.label = label;
        this.desc = desc;
        this.regex = regex;
        this.tipo = tipo;
        this.AttributeID = id;
        //Preconditions.noneNull();
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
        return new AttributeDTO(nome.toString(), label.toString(), desc.toString(), regex.toString(), tipo.toString(), AttributeID.toString());
    }

    @Override
    public AttributeID identity() {
        return AttributeID;
    }
}
