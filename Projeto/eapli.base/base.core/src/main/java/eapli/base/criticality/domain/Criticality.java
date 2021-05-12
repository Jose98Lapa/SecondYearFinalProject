package eapli.base.criticality.domain;

import eapli.base.criticality.dto.CriticalityDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Criticality implements AggregateRoot<CriticalityValue>, DTOable<CriticalityDTO> {

    @EmbeddedId
    private CriticalityValue criticalityValue;
    private Label label;
    @Column @JoinColumn
    private ResolutionObjective objetivoRes;
    @Column @JoinColumn
    private ApprovalObjective objetivoAprov;

    public Criticality(Label label, CriticalityValue valor, ApprovalObjective objetivoAprov, ResolutionObjective objetivoRes) {
        this.label = label;
        this.criticalityValue = valor;
        this.objetivoRes = objetivoRes;
        this.objetivoAprov = objetivoAprov;
    }

    protected Criticality() {}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public CriticalityValue identity() {
        return this.criticalityValue;
    }

    @Override
    public boolean hasIdentity(CriticalityValue criticalityValue) {return AggregateRoot.super.hasIdentity(criticalityValue);}

    @Override
    public CriticalityDTO toDTO() {
        return new CriticalityDTO(label.toString(), criticalityValue.toString(),objetivoAprov.tempoMaximo(),objetivoAprov.tempoMedio(),objetivoRes.tempoMaximo(),objetivoRes.tempoMedio());
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
}
