package eapli.base.colaborador.domain;

import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.funcao.domain.Funcao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Colaborador implements AggregateRoot<NumeroMecanografico>, DTOable<ColaboradorDTO> {

    private Morada morada;
    private Contacto contacto;
    private NomeCompleto nomeCompleto;
    private EmailInstitucional email;
    @Id
    private NumeroMecanografico mNumber;
    private Alcunha alcunha;
    private DataDeNascimento dataDeNascimento;

    private Funcao funcao;
    private NumeroMecanografico mSupervisor;

    public Colaborador(Morada morada, Contacto contacto, NomeCompleto nomeCompleto, EmailInstitucional email, NumeroMecanografico mNumber, Alcunha alcunha, DataDeNascimento dataDeNascimento, Funcao funcao, NumeroMecanografico mSupervisor) {
        this.morada = morada;
        this.contacto = contacto;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.mNumber = mNumber;
        this.alcunha = alcunha;
        this.dataDeNascimento = dataDeNascimento;
        this.funcao = funcao;
        this.mSupervisor = mSupervisor;
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
        return new ColaboradorDTO(morada,contacto,nomeCompleto,email,mNumber,alcunha,dataDeNascimento,funcao,mSupervisor);
    }
}
