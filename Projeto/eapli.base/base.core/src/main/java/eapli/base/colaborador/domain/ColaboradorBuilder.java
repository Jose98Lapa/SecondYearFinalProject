package eapli.base.colaborador.domain;

import eapli.base.funcao.domain.Function;
import eapli.framework.domain.model.DomainFactory;

public class ColaboradorBuilder implements DomainFactory<Colaborador> {
    private Address address;
    private Contact contact;
    private FullName fullName;
    private InstitutionalEmail email;
    private MecanographicNumber mNumber;
    private Nickname nickname;
    private Function function;
    //private MecanographicNumber supervisorNumber;

    public ColaboradorBuilder withAddress(final Address address){
        this.address=address;
        return this;
    }

    public ColaboradorBuilder withAddress(final String street, final String doorNumber, final String floor, final String location, final String postalCode){
        this.address=new Address(street, doorNumber, floor, location, postalCode);
        return this;
    }

    public ColaboradorBuilder withContact(final Contact contact){
        this.contact=contact;
        return this;
    }

    public ColaboradorBuilder withContact(final String contact){
        this.contact= new Contact(contact);
        return this;
    }

    public ColaboradorBuilder withFullName(final FullName fullName){
        this.fullName=fullName;
        return this;
    }

    public ColaboradorBuilder withFullName(final String fullName){
        this.fullName= new FullName(fullName);
        return this;
    }

    public ColaboradorBuilder withInstitutionalEmail(final InstitutionalEmail email){
        this.email=email;
        return this;
    }

    public ColaboradorBuilder withInstitutionalEmail(final String email){
        this.email=new InstitutionalEmail(email);
        return this;
    }

    public ColaboradorBuilder withMecanoGraphicNumber(final MecanographicNumber mNumber){
        this.mNumber=mNumber;
        return this;
    }

    public ColaboradorBuilder withMecanoGraphicNumber(final String mNumber){
        this.mNumber=new MecanographicNumber(mNumber);
        return this;
    }

    public ColaboradorBuilder withNickname(final Nickname nickname){
        this.nickname=nickname;
        return this;
    }

    public ColaboradorBuilder withNickname(final String nickname){
        this.nickname=new Nickname(nickname);
        return this;
    }


    @Override
    public Colaborador build() {
        return new Colaborador(address,contact,fullName,email,mNumber,nickname,function);
    }

}
