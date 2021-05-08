package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

public class Contacto implements ValueObject {

    private String contact;

    public Contacto(final String contact){
        if (contact==null ||contact.isEmpty()||!contact.matches("^[0-9]{9}$"))
            throw new IllegalArgumentException("Contacto nao cumpre os critérios");
        this.contact = contact;
        //check if it already exists
}

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contacto)) {
            return false;
        }

        final Contacto that = (Contacto) o;
        return this.contact.equals(that.contact);
    }

    @Override
    public int hashCode() {
        return this.contact.hashCode();
    }

    @Override
    public String toString() {
        return this.contact;
    }

}
