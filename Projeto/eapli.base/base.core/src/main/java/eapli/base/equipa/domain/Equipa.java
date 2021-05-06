package eapli.base.equipa.domain;

import javax.persistence.*;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Objects;

@Entity
public class Equipa implements AggregateRoot<EquipaID> {

    private Long id;

    private String designacao;

    @EmbeddedId
    private EquipaID equipaID;

    private Acronimo acronimo;

    public Equipa(String designacao, Acronimo acronimo) {
        this.designacao = designacao;
        this.acronimo = acronimo;
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
        return Objects.equals(id, equipa.id) && Objects.equals(designacao, equipa.designacao) && Objects.equals(acronimo, equipa.acronimo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designacao, acronimo);
    }
}
