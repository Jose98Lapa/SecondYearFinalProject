package eapli.base.equipa.domain;

import javax.persistence.*;

import eapli.base.equipa.DTO.EquipaDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import java.util.Objects;

@Entity
public class Equipa implements AggregateRoot<EquipaID>, DTOable<EquipaDTO> {

    private Long id;

    private String designacao;

    @EmbeddedId
    private EquipaID equipaID;

    private Acronimo acronimo;

    public Equipa(String designacao, Acronimo acronimo,EquipaID equipaID) {
        this.designacao = designacao;
        this.acronimo = acronimo;
        this.equipaID = equipaID;
    }

    protected Equipa(){

    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public EquipaID identity() {
        return this.equipaID;
    }

    public Acronimo acronimo() {
        return this.acronimo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipa equipa = (Equipa) o;
        return Objects.equals(id, equipa.id) && Objects.equals(designacao, equipa.designacao) && Objects.equals(acronimo, equipa.acronimo) && Objects.equals(equipaID,equipa.equipaID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designacao, acronimo,equipaID);
    }

    @Override
    public EquipaDTO toDTO() {
        return new EquipaDTO(designacao,acronimo.toString(),equipaID.toString());
    }
}
