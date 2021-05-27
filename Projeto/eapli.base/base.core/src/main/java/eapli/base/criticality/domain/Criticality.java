package eapli.base.criticality.domain;

import eapli.base.criticality.dto.CriticalityDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Criticality implements AggregateRoot<Long>, DTOable<CriticalityDTO> , Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column @JoinColumn
    private CriticalityValue criticalityValue;
    private Label label;

    @OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
    private ResolutionObjective objetivoRes;

    @OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
    private ApprovalObjective objetivoAprov;

    private boolean isGlobal;

    public Criticality(Label label, CriticalityValue valor, ApprovalObjective objetivoAprov, ResolutionObjective objetivoRes, boolean isGlobal) {
        this.label = label;
        this.criticalityValue = valor;
        this.objetivoRes = objetivoRes;
        this.objetivoAprov = objetivoAprov;
        this.isGlobal = isGlobal;
    }

    public Criticality(Long identity,Label label, CriticalityValue valor, ApprovalObjective objetivoAprov, ResolutionObjective objetivoRes, boolean isGlobal) {
        this.id = identity;
        this.label = label;
        this.criticalityValue = valor;
        this.objetivoRes = objetivoRes;
        this.objetivoAprov = objetivoAprov;
        this.isGlobal = isGlobal;
    }

    protected Criticality() {}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public boolean hasIdentity(Long id) {return AggregateRoot.super.hasIdentity(id);}

    @Override
    public CriticalityDTO toDTO() {
        return new CriticalityDTO(id ,label.toString(), criticalityValue.toString(),objetivoAprov.tempoMaximo(),objetivoAprov.tempoMedio(),objetivoRes.tempoMaximo(),objetivoRes.tempoMedio(),isGlobal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criticality that = (Criticality) o;
        return criticalityValue.equals(that.criticalityValue) && label.equals(that.label) && objetivoRes.equals(that.objetivoRes) && objetivoAprov.equals(that.objetivoAprov);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criticalityValue, label, objetivoRes, objetivoAprov);
    }

    @Override
    public String toString() {
        return "Valor da Criticidade: "+ criticalityValue +"\nLabel: "+label + "\nTempo Maximo de Aprovação: " + objetivoAprov.tempoMaximo() +
                " Tempo Medio de Aprovação: " + objetivoAprov.tempoMedio() + "\nTempo Maximo de Resolução: " + objetivoAprov.tempoMaximo() + " Tempo Medio de Resolução: " + objetivoAprov.tempoMedio() +"\n";
    }

    public void changeApprovalObjectiveTo(final ApprovalObjective newObjective){
        this.objetivoAprov = newObjective;
    }

    public void changeResolutionObjectiveTo(final ResolutionObjective newObjective){
        this.objetivoRes = newObjective;
    }
}
