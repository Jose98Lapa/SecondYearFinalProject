package eapli.base.catalogue.builder;

import eapli.base.catalogue.domain.*;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.criticality.domain.Criticality;
import eapli.base.team.domain.Team;
import eapli.framework.domain.model.DomainFactory;

import java.util.*;

public class CatalogueBuilder implements DomainFactory<Catalogue> {
    private Long identity;
    private Title title;
    private Icon icon;
    private BriefDescription briefDesc;
    private CompleteDescription completeDesc;
    private final Set<Collaborator> responsableCollabs = new HashSet<>();
    private final Set<Team> accessCriteria = new HashSet<>();
    private Criticality nivelCriticality;

    public CatalogueBuilder withIdentity(final Long identity) {
        this.identity = identity;
        return this;
    }


    public CatalogueBuilder withTitle(final Title title) {
        this.title = title;
        return this;
    }

    public CatalogueBuilder withTitle(final String title) {
        this.title = new Title(title);
        return this;
    }

    public CatalogueBuilder withIcon(final String icon) {
        this.icon = new Icon(icon);
        return this;
    }

    public CatalogueBuilder withIcon(final Icon icon) {
        this.icon = icon;
        return this;
    }

    public CatalogueBuilder withCompleteDesc(final String completeDesc) {
        this.completeDesc = new CompleteDescription(completeDesc);
        return this;
    }

    public CatalogueBuilder withCompleteDesc(final CompleteDescription completeDesc) {
        this.completeDesc = completeDesc;
        return this;
    }

    public CatalogueBuilder withBriefDesc(final String briefDesc) {
        this.briefDesc = new BriefDescription(briefDesc);
        return this;
    }

    public CatalogueBuilder withBriefDesc(final BriefDescription briefDesc) {
        this.briefDesc = briefDesc;
        return this;
    }

    public CatalogueBuilder withAccessCriteria(Set<Team> accessCriteria) {
        this.accessCriteria.addAll(accessCriteria);
        return this;
    }

    public CatalogueBuilder withResponsableCollabs(Set<Collaborator> responsableCollabs) {
        this.responsableCollabs.addAll(responsableCollabs);
        return this;
    }

    public CatalogueBuilder withNivelCriticidade(final Criticality nivelCriticality) {
        this.nivelCriticality = nivelCriticality;
        return this;
    }

    @Override
    public Catalogue build() {
        if(identity == null)
            return new Catalogue(title,icon,briefDesc,completeDesc,responsableCollabs,accessCriteria, nivelCriticality);
        return new Catalogue(identity, title,icon,briefDesc,completeDesc,responsableCollabs,accessCriteria, nivelCriticality);
    }
}
