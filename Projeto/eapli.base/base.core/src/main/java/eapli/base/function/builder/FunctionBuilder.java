package eapli.base.function.builder;

import eapli.base.function.domain.Designation;
import eapli.base.function.domain.Function;
import eapli.base.function.domain.IdFunction;
import eapli.framework.domain.model.DomainFactory;

public class FunctionBuilder implements DomainFactory<Function> {
    private Designation designation;
    private IdFunction idFunction;

    public FunctionBuilder withDesignacao(final Designation designation){
        this.designation = designation;
        return this;
    }

    public FunctionBuilder withDesignacao(final String designacao){
        this.designation =new Designation(designacao);
        return this;
    }

    public FunctionBuilder withIdFuncao(final IdFunction idFunction){
        this.idFunction = idFunction;
        return this;
    }

    public FunctionBuilder withIdFuncao(final String idFuncao){
        this.idFunction =new IdFunction(idFuncao);
        return this;
    }

    @Override
    public Function build(){
        return new Function(idFunction, designation);
    }

}
