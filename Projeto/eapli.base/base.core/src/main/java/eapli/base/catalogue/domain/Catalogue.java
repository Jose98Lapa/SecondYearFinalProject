package eapli.base.catalogue.domain;

import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.criticality.domain.Criticality;
import eapli.base.team.domain.Team;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Catalogue implements AggregateRoot<Long>, DTOable<CatalogueDTO>, Serializable {

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
    private Criticality criticalityLevel;

    @ManyToMany
    @JoinTable(name="CATALOGUE_RESPONSABLES", joinColumns = @JoinColumn(name="CATALOGO_ID"))
    private final Set<Collaborator> responsableCollabs = new HashSet<>();

    @ManyToMany
    @JoinTable(name="CATALOGUE_ACCESS", joinColumns = @JoinColumn(name="CATALOGO_ID"))
    private final Set<Team> accessCriteria = new HashSet<>();

    private boolean status;


    public Catalogue(Title title, Icon icon, BriefDescription briefDesc,
                     CompleteDescription completeDesc, final Set<Collaborator> responsableCollabs,
                     final Set<Team> accessCriteria, Criticality criticalityLevel) {
        Preconditions.nonNull(accessCriteria);
        Preconditions.nonNull(responsableCollabs);
        Preconditions.nonNull(criticalityLevel);
        Preconditions.nonEmpty(accessCriteria);
        Preconditions.nonEmpty(responsableCollabs);
        this.title = title;
        this.icon = icon;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        addResponsableCollabs(responsableCollabs);
        addAccessCriteria(accessCriteria);
        this.criticalityLevel = criticalityLevel;
        this.status = true;
    }

    protected Catalogue() {
    }

    public Catalogue(Long identity, Title title, Icon icon, BriefDescription briefDesc,
                     CompleteDescription completeDesc, final Set<Collaborator> responsableCollabs,
                     final Set<Team> accessCriteria, Criticality criticalityLevel) {
        this.identity = identity;
        this.title = title;
        this.icon = icon;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        addResponsableCollabs(responsableCollabs);
        addAccessCriteria(accessCriteria);
        this.criticalityLevel = criticalityLevel;
        this.status = true;
    }


    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
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

    public boolean accessibleBy ( Team team ) {
        return accessCriteria.contains( team );
    }

    public void changeCriticalityLevelTo(final Criticality newCriticality){
        this.criticalityLevel = newCriticality;
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


    public Criticality criticalityLevel() {
        return criticalityLevel;
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
                completeDesc.toString(),responsableCollabs,accessCriteria, criticalityLevel);
    }
}
