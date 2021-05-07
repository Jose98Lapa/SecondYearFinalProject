package eapli.base.funcao.domain;

public class FuncaoBuilder  {
    private Designacao designacao;
    private IdFuncao idFuncao;

    public FuncaoBuilder withDesignacao(final Designacao designacao){
        this.designacao=designacao;
        return this;
    }

    public FuncaoBuilder withDesignacao(final String designacao){
        this.designacao=new Designacao(designacao);
        return this;
    }

    public FuncaoBuilder withIdFuncao(final IdFuncao idFuncao){
        this.idFuncao=idFuncao;
        return this;
    }

    public FuncaoBuilder withIdFuncao(final String idFuncao){
        this.idFuncao=new IdFuncao(idFuncao);
        return this;
    }

    public Funcao build(){
        return new Funcao(idFuncao,designacao);
    }

}
