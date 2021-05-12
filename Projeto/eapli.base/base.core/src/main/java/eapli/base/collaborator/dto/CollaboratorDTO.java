package eapli.base.collaborator.dto;

import eapli.base.collaborator.domain.*;
import eapli.base.function.domain.Function;
import eapli.framework.representations.dto.DTO;

@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class CollaboratorDTO {
    public String rua;
    public String numPorta;
    public String andar;
    public String localizacao;
    public String codPostal;
    public String contacto;
    public String nomeCompleto;
    public String email;
    public String mNumber;
    public String alcunha;
    public String dataDeNascimento;
    public String designacao;
    public String IDfuncao;
    public String mSupervisor;

    public CollaboratorDTO(String rua, String numPorta, String andar, String localizacao, String codPostal, String contacto, String nomeCompleto, String email, String mNumber, String alcunha, String dataDeNascimento) {
        this.rua = rua;
        this.numPorta = numPorta;
        this.andar = andar;
        this.localizacao = localizacao;
        this.codPostal = codPostal;
        this.contacto = contacto;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.mNumber = mNumber;
        this.alcunha = alcunha;
        this.dataDeNascimento = dataDeNascimento;
    }

    public CollaboratorDTO(Address address, Contact contact, FullName fullName, InstituionalEmail email, MecanographicNumber mNumber, Nickname nickname, BirthDate birthDate, Function function, Collaborator Supervisor){
        AddressDTO addressDTO = address.toDTO();
        this.rua= addressDTO.rua;
        this.numPorta= addressDTO.numPorta;
        this.andar= addressDTO.andar;
        this.localizacao= addressDTO.localizacao;
        this.codPostal= addressDTO.codPostal;
        this.contacto= contact.toString();
        this.nomeCompleto= fullName.toString();
        this.email=email.toString();
        this.mNumber=mNumber.toString();
        this.alcunha= nickname.toString();
        this.dataDeNascimento= birthDate.toString();
        this.designacao= function.toDTO().designacao;
        this.IDfuncao= function.toDTO().IdFuncao;
        this.mSupervisor=Supervisor.identity().toString();
    }

    public CollaboratorDTO(Address address, Contact contact, FullName fullName, InstituionalEmail email, MecanographicNumber mNumber, Nickname nickname, BirthDate birthDate, Function function){
        AddressDTO addressDTO = address.toDTO();
        this.rua= addressDTO.rua;
        this.numPorta= addressDTO.numPorta;
        this.andar= addressDTO.andar;
        this.localizacao= addressDTO.localizacao;
        this.codPostal= addressDTO.codPostal;
        this.contacto= contact.toString();
        this.nomeCompleto= fullName.toString();
        this.email=email.toString();
        this.mNumber=mNumber.toString();
        this.alcunha= nickname.toString();
        this.dataDeNascimento= birthDate.toString();
        this.designacao= function.toDTO().designacao;
        this.IDfuncao= function.toDTO().IdFuncao;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeCompleto + " ID: " + mNumber + "\n";
    }

}
