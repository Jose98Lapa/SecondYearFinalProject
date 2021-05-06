package eapli.base.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Catalogo implements AggregateRoot<CatalogID>, DTOable<CatalogoDTO> {

    @Id
    @GeneratedValue
    private Long id;

    private CatalogID identity;
    private Title title;
    private Icon icon;
    private BriefDescription briefDesc;
    private CompleteDescription completeDesc;

    //@OneToMany
    private final Set<Collaborator> responsableCollabs = new HashSet<>();

    private final Set<Equipa> accessCriteria = new HashSet<>();

    //private Status currStatus;

    public Catalogo(CatalogID identity, Title title, Icon icon, BriefDescription briefDesc,
                    CompleteDescription completeDesc, List<AccessCriteria> accessCriteria,
                    MecanographicNumber responsableCollab) {
        this.identity = identity;
        this.title = title;
        this.icon = icon;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        this.responsableCollabs = responsableCollab;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public CatalogID identity() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public CatalogoDTO toDTO() {
        return null;
    }
}
