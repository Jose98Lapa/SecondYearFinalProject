package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class Address implements ValueObject {

    String street;
    String doorNumber;
    String floor;
    String location;
    PostalCode postalCode;

    public Address(final String street, final String doorNumber, final String floor, final String location, final String postalCode){
        if (street==null ||street.isEmpty()||!street.matches("^[\\w\\.]+(\\s\\w+){2,}$"))
            throw new IllegalArgumentException("Street does not fit the criteria");
        this.street = street;

        if (doorNumber==null ||doorNumber.isEmpty()||!doorNumber.matches("^\\d{0,4}$"))
            throw new IllegalArgumentException("Door Number does not fit the criteria");
        this.doorNumber = doorNumber;

        if (floor==null ||floor.isEmpty()||!floor.matches("^\\d{0,3}$"))
            throw new IllegalArgumentException("Floor does not fit the criteria");
        this.floor = floor;

        if (location==null ||location.isEmpty()||!location.matches("^[a-zA-Z]+(?:[\\s-][A-zÀ-ú]+)*$"))
            throw new IllegalArgumentException("Location does not fit the criteria");
        this.location = location;

        this.postalCode= new PostalCode(postalCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) && doorNumber.equals(address.doorNumber) && floor.equals(address.floor) && location.equals(address.location) && postalCode.equals(address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, doorNumber, floor, location, postalCode);
    }

    @Override
    public String toString() {
        return "Address:\n" +
                "Street -> " + street + "\n" +
                "DoorNumber -> " + doorNumber + "\n" +
                "Floor -> " + floor + "\n" +
                "Location -> " + location + "\n" +
                "PostalCode -> " + postalCode;
    }
}
