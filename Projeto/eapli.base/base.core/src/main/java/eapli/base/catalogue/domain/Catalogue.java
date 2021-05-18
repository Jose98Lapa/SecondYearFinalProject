package eapli.base.catalogue.domain;

import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.criticality.domain.Criticality;
import eapli.base.team.domain.Team;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Catalogue implements AggregateRoot<Long>, DTOable<CatalogueDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long identity;

    private Title title;
    private Icon icon;
    private BriefDescription briefDesc;
    private CompleteDescription completeDesc;

    @OneToOne
    private Criticality nivelCriticality;

    @ManyToMany
    @JoinTable(name="CATALOGO_RESPONSAVEIS", joinColumns = @JoinColumn(name="CATALOGO_ID"))
    private final Set<Collaborator> responsableCollabs = new HashSet<>();

    @ManyToMany
    @JoinTable(name="CATALOGO_ACESSO", joinColumns = @JoinColumn(name="CATALOGO_ID"))
    private final Set<Team> accessCriteria = new HashSet<>();

    private boolean status;


    public Catalogue(Title title, Icon icon, BriefDescription briefDesc,
                     CompleteDescription completeDesc, final Set<Collaborator> responsableCollabs,
                     final Set<Team> accessCriteria, Criticality nivelCriticality) {
        Preconditions.nonNull(accessCriteria);
        Preconditions.nonNull(responsableCollabs);
        Preconditions.nonNull(nivelCriticality);
        Preconditions.nonEmpty(accessCriteria);
        Preconditions.nonEmpty(responsableCollabs);
        this.title = title;
        this.icon = icon;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        addResponsableCollabs(responsableCollabs);
        addAccessCriteria(accessCriteria);
        this.nivelCriticality = nivelCriticality;
        this.status = true;
    }

    protected Catalogue() {
    }

    public Catalogue(Long identity, Title title, Icon icon, BriefDescription briefDesc,
                     CompleteDescription completeDesc, final Set<Collaborator> responsableCollabs,
                     final Set<Team> accessCriteria, Criticality nivelCriticality) {
        this.identity = identity;
        this.title = title;
        this.icon = icon;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        addResponsableCollabs(responsableCollabs);
        addAccessCriteria(accessCriteria);
        this.nivelCriticality = nivelCriticality;
        this.status = true;
    }


    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Catalogue)) {
            return false;
        }

        final Catalogue that = (Catalogue) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && title.equals(that.title)
                && icon.equals(that.icon) && briefDesc.equals(that.briefDesc)
                && completeDesc == that.completeDesc && status == that.status;
    }

    private void addAccessCriteria(final Set<Team> accessCriteria) {
        this.accessCriteria.addAll(accessCriteria);
    }

    private void addResponsableCollabs(final Set<Collaborator> responsableCollabs) {
        this.responsableCollabs.addAll(responsableCollabs);
    }

    public boolean isTeamValid(Set<Team> validTeams){
       for (Team team:accessCriteria){
           if (validTeams.contains(team)){
               return true;
           }
       }
       return false;

    }

    public void changeCriticalityLevelTo(final Criticality newCriticality){
        this.nivelCriticality = newCriticality;
    }

    public Long identity() {
        return identity;
    }

    public Title title() {
        return title;
    }

    public Icon icon() {
        return icon;
    }

    public BriefDescription briefDesc() {
        return briefDesc;
    }

    public CompleteDescription completeDesc() {
        return completeDesc;
    }


    public Criticality nivelCriticidade() {
        return nivelCriticality;
    }


    public Set<Collaborator> responsableCollabs() {
        return responsableCollabs;
    }

    public Set<Team> accessCriteria() {
        return accessCriteria;
    }

    public boolean isActive() {
        return status;
    }

    public boolean toogleState() {
        this.status = !this.status;
        return isActive();
    }

    @Override
    public CatalogueDTO toDTO() {
        return new CatalogueDTO(identity,
                title.toString(),
                icon.toString(),
                briefDesc.toString(),
                completeDesc.toString(),responsableCollabs,accessCriteria, nivelCriticality);
    }
}
