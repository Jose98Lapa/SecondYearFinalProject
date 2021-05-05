package eapli.base.catalog.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Catalog implements AggregateRoot<CatalogID> {

    @Id
    @GeneratedValue
    private Long id;

    private CatalogID identity;
    private Title title;
    private Icon icon;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="ContratoID")
    //private List<AccessCriteria> accessCriteria= new ArrayList<AccessCriteria>();

    //private Status currStatus;

    public Catalog(CatalogID identity, Title title, Icon icon, BriefDescription briefDesc,
                   CompleteDescription completeDesc, List<AccessCriteria> accessCriteria,
                   String responsableCollab) {

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
}
