package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Contacto implements ValueObject {

    private String contact;

    public Contacto(final String contact){
        if (contact==null ||contact.isEmpty()||!contact.matches("^[0-9]{9}$"))
            throw new IllegalArgumentException("Contacto nao cumpre os critérios");
        this.contact = contact;
        //check if it already exists
}

    protected Contacto() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(contact, contacto.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact);
    }

    @Override
    public String toString() {
        return this.contact;
    }

}
