package eapli.base.colaborador.domain;

import eapli.base.funcao.domain.Funcao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Colaborador implements AggregateRoot<NumeroMecanografico>{

    private Morada morada;
    private Contacto contacto;
    private NomeCompleto nomeCompleto;
    private EmailInstitucional email;
    @Id
    private NumeroMecanografico mNumber;
    private Alcunha alcunha;
    private DataDeNascimento dataDeNascimento;

    private Funcao funcao;
    //private MecanographicNumber supervisorNumber;

    public Colaborador(Morada morada, Contacto contacto, NomeCompleto nomeCompleto, EmailInstitucional email, NumeroMecanografico mNumber, Alcunha alcunha, Funcao funcao, DataDeNascimento dataDeNascimento) {
        this.morada = morada;
        this.contacto = contacto;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.mNumber = mNumber;
        this.alcunha = alcunha;
        this.dataDeNascimento = dataDeNascimento;
        this.funcao = funcao;
        //this.supervisorNumber = supervisorNumber;
    }

    protected Colaborador(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(NumeroMecanografico other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public NumeroMecanografico identity() {
        return mNumber;
    }

    @Override
    public boolean hasIdentity(NumeroMecanografico otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }

}
