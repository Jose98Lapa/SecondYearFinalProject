package eapli.base.form.domain;

import eapli.base.utils.GenerateRandomStringID;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class FormID implements ValueObject,Comparable<FormID>, Serializable{

    private String FormularioID;


    public FormID(final String ID) {
        if (StringPredicates.isNullOrEmpty(ID)) {
            FormularioID = GenerateRandomStringID.generateRandomStringID();
        }else{
            this.FormularioID = ID;
        }
    }

    protected FormID() {

    }

    @Override
    public String toString() {
        return FormularioID;
    }

    public static FormID valueOf(String string) {
        return new FormID(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormID that = (FormID) o;
        return Objects.equals(FormularioID, that.FormularioID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FormularioID);
    }

    @Override
    public int compareTo(FormID o) {
        return FormularioID.compareTo(o.FormularioID);
    }
}
