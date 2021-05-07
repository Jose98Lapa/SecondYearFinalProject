package eapli.base.funcao.domain;

import eapli.base.colaborador.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;

public class Function implements AggregateRoot<IdFunction> {

    private IdFunction idFunction;
    private Designation designation;

    public Function(IdFunction idFunction, Designation designation){
        this.idFunction=idFunction;
        this.designation=designation;
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
}
