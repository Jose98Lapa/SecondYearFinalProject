package eapli.base.equipa.builder;

import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.domain.EquipaID;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EquipaBuilder {
    private String designacao;
    private EquipaID equipaID;

    private Acronimo acronimo;

    private Colaborador colaborador;

    private TipoEquipa tipoEquipa;

    private Set<Colaborador> colaboradores;
    private Set<Colaborador> responsaveis;


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
    public EquipaBuilder colaborador(Colaborador colaborador){
        this.colaborador = colaborador;
        return this;
    }

    public EquipaBuilder colaboradores(List<Colaborador> colaborador){
        this.colaboradores = new HashSet<>();
        this.colaboradores.addAll(colaborador);
        return this;
    }

    public EquipaBuilder responsaveis(List<Colaborador> responsaveis){
        this.responsaveis = new HashSet<>();
        this.responsaveis.addAll(responsaveis);
        return this;
    }

    public EquipaBuilder tipoDeEquipa(TipoEquipa tipoEquipa){
        this.tipoEquipa = tipoEquipa;
        return this;
    }


    public Equipa build(){
        return new Equipa(designacao,acronimo,equipaID,colaborador,tipoEquipa);
    }

}
