package eapli.base.collaborator.dto;

import eapli.base.collaborator.domain.*;
import eapli.base.function.domain.Function;
import eapli.framework.representations.dto.DTO;

@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class CollaboratorDTO {
    public String placeOfResidence;
    public String contact;
    public String fullName;
    public String email;
    public String mNumber;
    public String nickname;
    public String dateOfBirth;
    public String designation;
    public String idFunction;
    public String mSupervisor;

    public CollaboratorDTO(String placeOfResidence,String contact, String fullName, String email, String mNumber, String nickname, String dateOfBirth) {
        this.placeOfResidence = placeOfResidence;
        this.contact = contact;
        this.fullName = fullName;
        this.email = email;
        this.mNumber = mNumber;
        this.nickname = nickname;
        this.dateOfBirth = dateOfBirth;
    }

    public CollaboratorDTO(PlaceOfResidence placeOfResidence, Contact contact, FullName fullName, InstituionalEmail email, MecanographicNumber mNumber, Nickname nickname, BirthDate birthDate, Function function, Collaborator Supervisor){
        this.placeOfResidence= placeOfResidence.toString();
        this.contact= contact.toString();
        this.fullName= fullName.toString();
        this.email=email.toString();
        this.mNumber=mNumber.toString();
        this.nickname= nickname.toString();
        this.dateOfBirth= birthDate.toString();
        this.designation= function.toDTO().designation;
        this.idFunction= function.toDTO().idFunction;
        this.mSupervisor=Supervisor.identity().toString();
    }

    public CollaboratorDTO(PlaceOfResidence placeOfResidence, Contact contact, FullName fullName, InstituionalEmail email, MecanographicNumber mNumber, Nickname nickname, BirthDate birthDate, Function function){
        this.placeOfResidence=placeOfResidence.toString();
        this.contact= contact.toString();
        this.fullName= fullName.toString();
        this.email=email.toString();
        this.mNumber=mNumber.toString();
        this.nickname= nickname.toString();
        this.dateOfBirth= birthDate.toString();
        this.designation= function.toDTO().designation;
        this.idFunction= function.toDTO().idFunction;
    }

    @Override
    public String toString() {
        return "Nome: " + fullName + " ID: " + mNumber + "\n";
    }

}
