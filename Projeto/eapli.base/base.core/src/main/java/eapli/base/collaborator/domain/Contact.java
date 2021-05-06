package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact implements ValueObject {

    private String contact;

    public Contact(final String contact){
        if (contact==null ||contact.isEmpty()||!contact.matches("^[0-9]{9}$"))
            throw new IllegalArgumentException("Contact does not fit the criteria");
        this.contact = contact;
        //check if it already exists
}

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contact)) {
            return false;
        }

        final Contact that = (Contact) o;
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
