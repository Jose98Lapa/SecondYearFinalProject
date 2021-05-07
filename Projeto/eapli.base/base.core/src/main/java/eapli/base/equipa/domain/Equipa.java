package eapli.base.equipa.domain;

import javax.persistence.*;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Equipa implements AggregateRoot<EquipaID>, DTOable<EquipaDTO> {



    @EmbeddedId
    private EquipaID equipaID;
    private String designacao;
    private Acronimo acronimo;

    @OneToMany
    private final Set<Colaborador> colaboradorSet = new HashSet<>();

    public Equipa(String designacao, Acronimo acronimo,EquipaID equipaID,Colaborador colaborador) {
        this.designacao = designacao;
        this.acronimo = acronimo;
        this.equipaID = equipaID;
        this.colaboradorSet.add(colaborador);
    }

    protected Equipa(){

    }

    public void addColaborador(Colaborador colaborador){
        colaboradorSet.add(colaborador);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public EquipaID identity() {
        return this.equipaID;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipa equipa = (Equipa) o;
        return Objects.equals(designacao, equipa.designacao) && Objects.equals(acronimo, equipa.acronimo) && Objects.equals(equipaID,equipa.equipaID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designacao, acronimo,equipaID);
    }

    @Override
    public EquipaDTO toDTO() {
        return new EquipaDTO(designacao,acronimo.toString(),equipaID.toString(),colaboradorSet.stream().findFirst().get().identity().toString());
    }
}
