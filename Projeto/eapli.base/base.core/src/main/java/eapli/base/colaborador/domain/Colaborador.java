package eapli.base.colaborador.domain;

import eapli.base.funcao.domain.Function;
import eapli.framework.domain.model.AggregateRoot;


public class Colaborador implements AggregateRoot<MecanographicNumber>{

    private Address address;
    private Contact contact;
    private FullName fullName;
    private InstitutionalEmail email;
    private MecanographicNumber mNumber;
    private Nickname nickname;
    private Function function;
    //private MecanographicNumber supervisorNumber;

    public Colaborador(Address address, Contact contact, FullName fullName, InstitutionalEmail email, MecanographicNumber mNumber, Nickname nickname, Function function) {
        this.address = address;
        this.contact = contact;
        this.fullName = fullName;
        this.email = email;
        this.mNumber = mNumber;
        this.nickname = nickname;
        this.function = function;
        //this.supervisorNumber = supervisorNumber;
    }

    protected Colaborador(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(MecanographicNumber other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public MecanographicNumber identity() {
        return mNumber;
    }

    @Override
    public boolean hasIdentity(MecanographicNumber otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }

}
