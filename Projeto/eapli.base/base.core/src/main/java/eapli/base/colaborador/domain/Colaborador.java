package eapli.base.colaborador.domain;

import eapli.base.funcao.domain.Funcao;
import eapli.framework.domain.model.AggregateRoot;


public class Colaborador implements AggregateRoot<NumeroMecanografico>{

    private Morada morada;
    private Contacto contacto;
    private NomeCompleto nomeCompleto;
    private EmailInstitucional email;
    private NumeroMecanografico mNumber;
    private Alcunha alcunha;
    private Funcao funcao;
    //private MecanographicNumber supervisorNumber;

    public Colaborador(Morada morada, Contacto contacto, NomeCompleto nomeCompleto, EmailInstitucional email, NumeroMecanografico mNumber, Alcunha alcunha, Funcao funcao) {
        this.morada = morada;
        this.contacto = contacto;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.mNumber = mNumber;
        this.alcunha = alcunha;
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

    public NomeCompleto nomeCompleto() {
        return nomeCompleto;
    }

    public NumeroMecanografico mNumber() {
        return mNumber;
    }

    public Alcunha alcunha() {
        return alcunha;
    }
}
