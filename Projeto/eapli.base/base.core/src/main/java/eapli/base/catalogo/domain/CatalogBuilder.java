package eapli.base.catalogo.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.domain.model.DomainFactory;

import java.util.*;

public class CatalogBuilder implements DomainFactory<Catalogo> {
    private Titulo titulo;
    private Icon icon;
    private DescricaoBreve briefDesc;
    private DescricaoCompleta completeDesc;
    private final Set<Colaborador> responsableCollabs = new HashSet<>();
    private final Set<Equipa> accessCriteria = new HashSet<>();
    private Criticidade nivelCriticidade;

    /*
    public CatalogBuilder withIdentity(final CatalogoID identity) {
        this.identity = identity;
        return this;
    }

    public CatalogBuilder withIdentity(final String identity) {
        this.identity = new CatalogoID(identity);
        return this;
    }
    */

    public CatalogBuilder withTitle(final Titulo titulo) {
        this.titulo = titulo;
        return this;
    }

    public CatalogBuilder withTitle(final String title) {
        this.titulo = new Titulo(title);
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
        this.completeDesc = new DescricaoCompleta(completeDesc);
        return this;
    }

    public CatalogBuilder withCompleteDesc(final DescricaoCompleta completeDesc) {
        this.completeDesc = completeDesc;
        return this;
    }

    public CatalogBuilder withBriefDesc(final String briefDesc) {
        this.briefDesc = new DescricaoBreve(briefDesc);
        return this;
    }

    public CatalogBuilder withBriefDesc(final DescricaoBreve briefDesc) {
        this.briefDesc = briefDesc;
        return this;
    }

    public CatalogBuilder withAccessCriteria(Set<Equipa> accessCriteria) {
        this.accessCriteria.addAll(accessCriteria);
        return this;
    }

    public CatalogBuilder withResponsableCollabs(Set<Colaborador> responsableCollabs) {
        this.responsableCollabs.addAll(responsableCollabs);
        return this;
    }

    public CatalogBuilder withNivelCriticidade(final Criticidade nivelCriticidade) {
        this.nivelCriticidade = nivelCriticidade;
        return this;
    }

    @Override
    public Catalogo build() {
        return new Catalogo(titulo,icon,briefDesc,completeDesc,responsableCollabs,accessCriteria,nivelCriticidade);
    }
}
