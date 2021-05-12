package eapli.base.collaborator.domain;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.function.domain.Function;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Collaborator implements AggregateRoot<MecanographicNumber>, DTOable<CollaboratorDTO> {

    private Address address;

    private Contact contact;

    private FullName fullName;

    private InstituionalEmail email;

    @EmbeddedId
    private MecanographicNumber mNumber;

    private Nickname nickname;

    private BirthDate birthDate;

    @Nullable
    @ManyToOne
    private Collaborator supervisor;

    @ManyToOne
    private Function function;

    public Collaborator(Address address, Contact contact, FullName fullName, InstituionalEmail email, MecanographicNumber mNumber, Nickname nickname, BirthDate birthDate, Function function, Collaborator supervisor) {
        this.address = address;
        this.contact = contact;
        this.fullName = fullName;
        this.email = email;
        this.mNumber = mNumber;
        this.nickname = nickname;
        this.birthDate = birthDate;
        this.function = function;
        this.supervisor = supervisor;
    }

    protected Collaborator() {
    }

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

    @Override
    public CollaboratorDTO toDTO() {
        if (supervisor==null)
            return new CollaboratorDTO(address, contact, fullName, email, mNumber, nickname, birthDate, function);
        return new CollaboratorDTO(address, contact, fullName, email, mNumber, nickname, birthDate, function, supervisor);
    }

    @Override
    public String toString() {
        return "Nome: " + fullName + " ID: " + mNumber + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborator that = (Collaborator) o;
        return this.mNumber.equals(that.mNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, contact, fullName, email, mNumber, nickname, birthDate, function);
    }
}
