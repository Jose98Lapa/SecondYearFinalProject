package eapli.base.colour.Builder;

import eapli.base.colour.Domain.Colour;
import eapli.base.colour.Domain.Hexadecimal;

public class ColourBuilder {
    private Hexadecimal valorHexadecimal;
    private String nome;

    public ColourBuilder() {
    }

    public ColourBuilder valorHexadecimal(String valorHexadecimal){
        this.valorHexadecimal = Hexadecimal.valueOf(valorHexadecimal);
        return this;
    }

    public ColourBuilder nome(String nome){
        this.nome = nome;
        return this;
    }

    public Colour builder(){
        return new Colour(nome,this.valorHexadecimal);
    }
}
