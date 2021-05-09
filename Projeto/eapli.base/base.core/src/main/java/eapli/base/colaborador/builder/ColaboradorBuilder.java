package eapli.base.colaborador.builder;

import eapli.base.colaborador.domain.*;
import eapli.base.funcao.domain.Funcao;
import eapli.base.funcao.builder.FuncaoBuilder;

public class ColaboradorBuilder {
    private Morada morada;
    private Contacto contacto;
    private NomeCompleto nomeCompleto;
    private EmailInstitucional email;
    private NumeroMecanografico mNumber;
    private Alcunha alcunha;
    private DataDeNascimento dataDeNascimento;

    private Funcao funcao;
    private Colaborador supervisor;

    public ColaboradorBuilder withAddress(final Morada morada){
        this.morada = morada;
        return this;
    }

    public ColaboradorBuilder withAddress(final String street, final String doorNumber, final String floor, final String location, final String postalCode){
        this.morada =new Morada(street, doorNumber, floor, location, postalCode);
        return this;
    }

    public ColaboradorBuilder withContact(final Contacto contacto){
        this.contacto = contacto;
        return this;
    }

    public ColaboradorBuilder withContact(final String contact){
        this.contacto = new Contacto(contact);
        return this;
    }

    public ColaboradorBuilder withFullName(final NomeCompleto nomeCompleto){
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public ColaboradorBuilder withFullName(final String fullName){
        this.nomeCompleto = new NomeCompleto(fullName);
        return this;
    }

    public ColaboradorBuilder withInstitutionalEmail(final EmailInstitucional email){
        this.email=email;
        return this;
    }

    public ColaboradorBuilder withInstitutionalEmail(final String email){
        this.email=new EmailInstitucional(email);
        return this;
    }

    public ColaboradorBuilder withMecanoGraphicNumber(final NumeroMecanografico mNumber){
        this.mNumber=mNumber;
        return this;
    }

    public ColaboradorBuilder withMecanoGraphicNumber(final String mNumber){
        this.mNumber=new NumeroMecanografico(mNumber);
        return this;
    }

    public ColaboradorBuilder withNickname(final Alcunha alcunha){
        this.alcunha = alcunha;
        return this;
    }

    public ColaboradorBuilder withNickname(final String alcunha){
        this.alcunha =new Alcunha(alcunha);
        return this;
    }

    public ColaboradorBuilder withDateOfBirth(final DataDeNascimento dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public ColaboradorBuilder withDateOfBirth(final String dataDeNascimento){
        this.dataDeNascimento = new DataDeNascimento(dataDeNascimento);
        return this;
    }

    public ColaboradorBuilder withFunction(final Funcao funcao){
        this.funcao = funcao;
        return this;
    }

    public ColaboradorBuilder withFunction( final String idFuncao, final String designacao){
        this.funcao = new FuncaoBuilder().withIdFuncao(idFuncao).withDesignacao(designacao).build();
        return this;
    }

    public ColaboradorBuilder withSupervisor(final Colaborador supervisor){
        this.supervisor = supervisor;
        return this;
    }

    public Colaborador build() {
        return new Colaborador(morada, contacto, nomeCompleto,email,mNumber, alcunha,dataDeNascimento,funcao,supervisor);
    }

}
