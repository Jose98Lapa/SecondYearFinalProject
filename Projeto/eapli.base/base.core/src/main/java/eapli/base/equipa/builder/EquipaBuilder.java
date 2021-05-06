package eapli.base.equipa.builder;

import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.domain.EquipaID;

public class EquipaBuilder {
    private String designacao;
    private EquipaID equipaID;

    private Acronimo acronimo;


    public EquipaBuilder() {

    }

    public EquipaBuilder designacao(String designacao){
        this.designacao = designacao;
        return this;
    }

    public EquipaBuilder equipaID(String ID){
        this.equipaID = EquipaID.valueOf(ID);
        return this;
    }
    public EquipaBuilder acronimo(String acronimo){
        this.acronimo = Acronimo.valueOf(acronimo);
        return this;
    }

    public Equipa build(){
        return new Equipa(designacao,acronimo,equipaID);
    }
}
