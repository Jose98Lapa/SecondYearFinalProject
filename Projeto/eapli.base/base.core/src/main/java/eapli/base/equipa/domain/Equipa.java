package eapli.base.equipa.domain;

import javax.persistence.*;

import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import java.util.*;

@Entity
public class Equipa implements AggregateRoot<EquipaID>, DTOable<EquipaDTO> {



    @EmbeddedId
    private EquipaID equipaID;
    private String designacao;
    private Acronimo acronimo;
    @OneToOne
    private TipoEquipa tipoEquipa;

    @OneToMany
    @JoinTable
            (name="EQUIPA_RESPONSAVEIS",
                    joinColumns = @JoinColumn(name="EQUIPA_ID")
            )
    private final Set<Colaborador> colaboradorResponsaveisSet = new HashSet<>();

    @OneToMany
    @JoinTable
            (name="EQUIPA_TEAM_MEMBERS",
                    joinColumns = @JoinColumn(name="EQUIPA_ID")
            )
    private final Set<Colaborador> teamMembers = new HashSet<>();

    public Equipa(String designacao, Acronimo acronimo,EquipaID equipaID,Colaborador colaborador,TipoEquipa tipoEquipa) {
        this.designacao = designacao;
        this.acronimo = acronimo;
        this.equipaID = equipaID;
        this.colaboradorResponsaveisSet.add(colaborador);
        this.tipoEquipa = tipoEquipa;
    }

    public Equipa(String designacao, Acronimo acronimo,EquipaID equipaID,Set<Colaborador> colaboradores,TipoEquipa tipoEquipa,List<Colaborador> responsaveis) {
        this.designacao = designacao;
        this.acronimo = acronimo;
        this.equipaID = equipaID;
        this.teamMembers.addAll(colaboradores);
        this.colaboradorResponsaveisSet.addAll(responsaveis);
        this.tipoEquipa = tipoEquipa;
    }

    protected Equipa(){

    }

    public void addColaboradorResponsible(Colaborador colaborador){
        colaboradorResponsaveisSet.add(colaborador);
    }

    public void addTeamMembers(Colaborador colaborador){
        teamMembers.add(colaborador);
    }

    public boolean containsResponsavel(Colaborador colaborador){
        for (Colaborador colaborador1 : colaboradorResponsaveisSet){
            if (colaborador1.identity().toString().equals(colaborador.identity().toString()))
                return true;
        }
        return false;
    }

    public boolean containsTeamMember(Colaborador colaborador){
        for (Colaborador colaborador1 : teamMembers){
            if (colaborador1.identity().toString().equals(colaborador.identity().toString()))
                return true;
        }
        return false;
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
        List<ColaboradorDTO> responsaveis = new ArrayList<>();
        colaboradorResponsaveisSet.forEach(collab -> responsaveis.add(collab.toDTO()));
        List<ColaboradorDTO> membros = new ArrayList<>();
        teamMembers.forEach(collab -> membros.add(collab.toDTO()));
        return new EquipaDTO(designacao,acronimo.toString(),equipaID.toString(), responsaveis,tipoEquipa.toDTO(),membros);
    }

    public void removeColaborador(Colaborador colaborador){
        teamMembers.removeIf(col -> col.identity().equals(colaborador.identity()));
    }
}
