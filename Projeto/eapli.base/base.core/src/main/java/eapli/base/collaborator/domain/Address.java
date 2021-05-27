package eapli.base.collaborator.domain;

import eapli.base.collaborator.dto.AddressDTO;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Address implements ValueObject, DTOable<AddressDTO> , Serializable {

    @Column @JoinColumn
    private Street street;
    @Column @JoinColumn
    private DoorNumber doorNumber;
    @Column @JoinColumn
    private Floor floor;
    @Column @JoinColumn
    private Localization localization;
    @Column @JoinColumn
    private ZipCode zipCode;


    public Address(final String estrada, final String numPorta, final String andar, final String localizacao, final String codPostal){
        this.street = new Street(estrada);
        this.doorNumber = new DoorNumber(numPorta);
        this.floor = new Floor(andar);
        this.localization = new Localization(localizacao);
        this.zipCode = new ZipCode(codPostal);
    }

    protected Address() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(doorNumber, address.doorNumber) && Objects.equals(floor, address.floor) && Objects.equals(localization, address.localization) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, doorNumber, floor, localization, zipCode);
    }

    @Override
    public String toString() {
        return "Morada:\n" +
                "Estrada -> " + street + "\n" +
                "Numero da Porto -> " + doorNumber + "\n" +
                "Andar -> " + floor + "\n" +
                "Localizacao -> " + localization + "\n" +
                "Codigo postal -> " + zipCode;
    }

    @Override
    public AddressDTO toDTO() {
        return new AddressDTO(street.toString(), doorNumber.toString(), floor.toString(), localization.toString(), zipCode.toString());
    }
}
