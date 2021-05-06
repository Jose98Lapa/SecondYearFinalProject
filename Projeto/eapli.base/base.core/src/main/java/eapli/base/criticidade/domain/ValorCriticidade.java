package eapli.base.criticidade.domain;


public class ValorCriticidade implements Comparable<ValorCriticidade> {
    private final int valor;

    public ValorCriticidade(int valor){
        if(valor<1 || valor>5)
            this.valor=valor;
        else
            throw new IllegalArgumentException("O valor da criticidade corresponde a um intervalo de 1 a 5");
    }

    public int valor(){
        return  this.valor;
    }

    @Override
    public int compareTo(ValorCriticidade o) {
        return valor-o.valor;
    }
}
