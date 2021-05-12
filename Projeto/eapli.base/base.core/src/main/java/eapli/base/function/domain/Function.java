package eapli.base.function.domain;

import eapli.base.function.DTO.FunctionDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Function implements AggregateRoot<IdFunction>, DTOable<FunctionDTO> {

    @EmbeddedId
    private IdFunction idFunction;
    private Designation designation;

    public Function(IdFunction idFunction, Designation designation){
        this.idFunction = idFunction;
        this.designation = designation;
    }

    protected Function(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(IdFunction other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public IdFunction identity() {
        return idFunction;
    }

    @Override
    public boolean hasIdentity(IdFunction otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }

    @Override
    public FunctionDTO toDTO() {
        return new FunctionDTO(idFunction, designation);
    }

    @Override
    public String toString() {
        return "Designacao: "+ designation;
    }
}
