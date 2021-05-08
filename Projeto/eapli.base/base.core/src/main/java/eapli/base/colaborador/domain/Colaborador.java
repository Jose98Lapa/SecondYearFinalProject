package eapli.base.colaborador.domain;

import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.funcao.domain.Funcao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;

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

    @Nullable
    @ManyToOne
    private Colaborador supervisor;

    @ManyToOne
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

    protected Colaborador() {
    }

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
        if (supervisor==null)
            return new ColaboradorDTO(morada, contacto, nomeCompleto, email, mNumber, alcunha, dataDeNascimento, funcao);
        return new ColaboradorDTO(morada, contacto, nomeCompleto, email, mNumber, alcunha, dataDeNascimento, funcao, supervisor);
    }

    @Override
    public String toString() {
        return "Nome: " + nomeCompleto + " ID: " + mNumber + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colaborador that = (Colaborador) o;
        return this.mNumber.equals(that.mNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(morada, contacto, nomeCompleto, email, mNumber, alcunha, dataDeNascimento, funcao);
    }
}
