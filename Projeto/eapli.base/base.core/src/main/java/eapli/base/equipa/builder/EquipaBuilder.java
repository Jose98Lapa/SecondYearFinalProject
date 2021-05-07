package eapli.base.equipa.builder;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.domain.EquipaID;

public class EquipaBuilder {
    private String designacao;
    private EquipaID equipaID;

    private Acronimo acronimo;

    private Colaborador colaborador;


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
    public EquipaBuilder colaborador(Colaborador colaborador){
        this.colaborador = colaborador;
        return this;
    }


    public Equipa build(){
        return new Equipa(designacao,acronimo,equipaID,colaborador);
    }
}
