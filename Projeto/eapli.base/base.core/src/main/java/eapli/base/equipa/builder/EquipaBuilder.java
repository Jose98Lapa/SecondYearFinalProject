package eapli.base.equipa.builder;

import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.domain.EquipaID;

import java.util.*;

public class EquipaBuilder {
    private String designacao;
    private EquipaID equipaID;

    private Acronimo acronimo;



    private TipoEquipa tipoEquipa;

    private Set<Colaborador> colaboradores = new HashSet<>();
    private List<Colaborador> responsaveis = new ArrayList<>();


    public EquipaBuilder() {
            //vazio
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


    public EquipaBuilder colaboradores(List<Colaborador> colaborador){
        this.colaboradores.addAll(colaborador);
        return this;
    }

    public EquipaBuilder responsaveis(List<Colaborador> responsaveis){
        this.responsaveis.addAll(responsaveis);
        return this;
    }

    public EquipaBuilder tipoDeEquipa(TipoEquipa tipoEquipa){
        this.tipoEquipa = tipoEquipa;
        return this;
    }


    public Equipa build(){
        Equipa e = new Equipa(designacao,acronimo,equipaID,responsaveis.remove(0),tipoEquipa);
        for (Colaborador colaborador:colaboradores){
            e.addTeamMembers(colaborador);
        }
        for (Colaborador colaborador:responsaveis){
            e.addColaboradorResponsible(colaborador);
        }
        return e;
    }

}
