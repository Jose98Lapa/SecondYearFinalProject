package eapli.base.cor.Builder;

import eapli.base.cor.Domain.Cor;
import eapli.base.cor.Domain.Hexadecimal;

public class CorBuilder {
    private Hexadecimal valorHexadecimal;
    private String nome;

    public CorBuilder() {
    }

    public CorBuilder valorHexadecimal(String valorHexadecimal){
        this.valorHexadecimal = Hexadecimal.valueOf(valorHexadecimal);
        return this;
    }

    public CorBuilder nome(String nome){
        this.nome = nome;
        return this;
    }

    public Cor builder(){
        return new Cor(nome,this.valorHexadecimal);
    }
}
