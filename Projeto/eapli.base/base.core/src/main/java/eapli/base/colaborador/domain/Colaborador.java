package eapli.base.colaborador.domain;

import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.funcao.domain.Funcao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;

@Entity
public class Colaborador implements AggregateRoot<NumeroMecanografico>, DTOable<ColaboradorDTO> {

    private Morada morada;
    private Contacto contacto;
    private NomeCompleto nomeCompleto;
    private EmailInstitucional email;
    @EmbeddedId
    private NumeroMecanografico mNumber;
    private Alcunha alcunha;
    private DataDeNascimento dataDeNascimento;
    @OneToOne
    private Colaborador supervisor;
    @OneToOne
    private Funcao funcao;

    public Colaborador(Morada morada, Contacto contacto, NomeCompleto nomeCompleto, EmailInstitucional email, NumeroMecanografico mNumber, Alcunha alcunha, DataDeNascimento dataDeNascimento, Funcao funcao, Colaborador supervisor) {
        this.morada = morada;
        this.contacto = contacto;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.mNumber = mNumber;
        this.alcunha = alcunha;
        this.dataDeNascimento = dataDeNascimento;
        this.funcao = funcao;
        this.supervisor = supervisor;
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

    @Override
    public ColaboradorDTO toDTO() {
        return new ColaboradorDTO(morada,contacto,nomeCompleto,email,mNumber,alcunha,dataDeNascimento,funcao,supervisor);
    }

    @Override
    public String toString() {
        return "Nome: "+nomeCompleto+" ID: "+mNumber+"\n";
    }
}
