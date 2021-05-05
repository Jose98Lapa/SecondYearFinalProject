package eapli.base.catalog.domain;

import eapli.framework.domain.model.DomainFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CatalogBuilder implements DomainFactory<Catalog> {
    private CatalogID identity;
    private Title title;
    private Icon icon;
    private BriefDescription briefDesc;
    private CompleteDescription completeDesc;
    private List<AccessCriteria> accessCriteria = new ArrayList<>();
    private String responsableCollab;

    public CatalogBuilder withIdentity(final CatalogID identity) {
        this.identity = identity;
        return this;
    }

    public CatalogBuilder withIdentity(final String identity) {
        this.identity = new CatalogID(identity);
        return this;
    }

    public CatalogBuilder withTitle(final Title title) {
        this.title = title;
        return this;
    }

    public CatalogBuilder withTitle(final String title) {
        this.title = new Title(title);
        return this;
    }

    public CatalogBuilder withIcon(final String icon) {
        this.icon = new Icon(icon);
        return this;
    }

    public CatalogBuilder withIcon(final Icon icon) {
        this.icon = icon;
        return this;
    }

    public CatalogBuilder withCompleteDesc(final String completeDesc) {
        this.completeDesc = new CompleteDescription(completeDesc);
        return this;
    }

    public CatalogBuilder withCompleteDesc(final CompleteDescription completeDesc) {
        this.completeDesc = completeDesc;
        return this;
    }

    public CatalogBuilder withBriefDesc(final String briefDesc) {
        this.briefDesc = new BriefDescription(briefDesc);
        return this;
    }

    public CatalogBuilder withCompleteDesc(final BriefDescription briefDesc) {
        this.briefDesc = briefDesc;
        return this;
    }

    public CatalogBuilder withAccessCriteria(Map<Integer,AccessCriteriaFormat> accessCriteria) {

        accessCriteria.forEach( (id,format) -> {
            //final AccessCriteriaFactory accessCriteriaFactory = new AccessCriteriaFactory();
            //final DomainFactory<> exporter = factory.build(format);
        });
        return this;
    }

    @Override
    public Catalog build() {
        return new Catalog(identity,title,icon,briefDesc,completeDesc,accessCriteria,responsableCollab);
    }
}
