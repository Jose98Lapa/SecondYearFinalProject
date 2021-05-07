/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@Embeddable
public class NumeroMecanografico implements ValueObject, Comparable<NumeroMecanografico> {

    private static final long serialVersionUID = 1L;

    private String number;
    private final String regex = "^[0-9]{1,6}$";

    public NumeroMecanografico(final String mecanographicNumber) {
        if (StringPredicates.isNullOrEmpty(mecanographicNumber)) {
            throw new IllegalArgumentException(
                    "Mecanographic Number should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mecanographicNumber);

        if (m.matches())
            this.number=mecanographicNumber;
        else
            throw new IllegalArgumentException("Mecanographic Number does not fit the criteria");

        //check if it already exists
    }

    protected NumeroMecanografico() {
        // for ORM
    }

    public static NumeroMecanografico valueOf(final String mecanographicNumber) {
        return new NumeroMecanografico(mecanographicNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NumeroMecanografico)) {
            return false;
        }

        final NumeroMecanografico that = (NumeroMecanografico) o;
        return this.number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    @Override
    public String toString() {
        return this.number;
    }

    @Override
    public int compareTo(final NumeroMecanografico arg0) {
        return number.compareTo(arg0.number);
    }
}
