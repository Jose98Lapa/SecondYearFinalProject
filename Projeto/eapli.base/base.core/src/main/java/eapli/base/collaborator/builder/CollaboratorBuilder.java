package eapli.base.collaborator.builder;

import eapli.base.collaborator.domain.*;
import eapli.base.function.domain.Function;
import eapli.base.function.builder.FunctionBuilder;
import eapli.framework.domain.model.DomainFactory;

public class CollaboratorBuilder implements DomainFactory<Collaborator> {
    private Address address;
    private Contact contact;
    private FullName fullName;
    private InstituionalEmail email;
    private MecanographicNumber mNumber;
    private Nickname nickname;
    private BirthDate birthDate;

    private Function function;
    private Collaborator supervisor;

    public CollaboratorBuilder withAddress(final Address address){
        this.address = address;
        return this;
    }

    public CollaboratorBuilder withAddress(final String street, final String doorNumber, final String floor, final String location, final String postalCode){
        this.address =new Address(street, doorNumber, floor, location, postalCode);
        return this;
    }

    public CollaboratorBuilder withContact(final Contact contact){
        this.contact = contact;
        return this;
    }

    public CollaboratorBuilder withContact(final String contact){
        this.contact = new Contact(contact);
        return this;
    }

    public CollaboratorBuilder withFullName(final FullName fullName){
        this.fullName = fullName;
        return this;
    }

    public CollaboratorBuilder withFullName(final String fullName){
        this.fullName = new FullName(fullName);
        return this;
    }

    public CollaboratorBuilder withInstitutionalEmail(final InstituionalEmail email){
        this.email=email;
        return this;
    }

    public CollaboratorBuilder withInstitutionalEmail(final String email){
        this.email=new InstituionalEmail(email);
        return this;
    }

    public CollaboratorBuilder withMecanoGraphicNumber(final MecanographicNumber mNumber){
        this.mNumber=mNumber;
        return this;
    }

    public CollaboratorBuilder withMecanoGraphicNumber(final String mNumber){
        this.mNumber=new MecanographicNumber(mNumber);
        return this;
    }

    public CollaboratorBuilder withNickname(final Nickname nickname){
        this.nickname = nickname;
        return this;
    }

    public CollaboratorBuilder withNickname(final String alcunha){
        this.nickname =new Nickname(alcunha);
        return this;
    }

    public CollaboratorBuilder withDateOfBirth(final BirthDate birthDate){
        this.birthDate = birthDate;
        return this;
    }

    public CollaboratorBuilder withDateOfBirth(final String dataDeNascimento){
        this.birthDate = new BirthDate(dataDeNascimento);
        return this;
    }

    public CollaboratorBuilder withFunction(final Function function){
        this.function = function;
        return this;
    }

    public CollaboratorBuilder withFunction(final String idFuncao, final String designacao){
        this.function = new FunctionBuilder().withIdFuncao(idFuncao).withDesignacao(designacao).build();
        return this;
    }

    public CollaboratorBuilder withSupervisor(final Collaborator supervisor){
        this.supervisor = supervisor;
        return this;
    }

    @Override
    public Collaborator build() {
        return new Collaborator(address, contact, fullName,email,mNumber, nickname, birthDate, function,supervisor);
    }

}
