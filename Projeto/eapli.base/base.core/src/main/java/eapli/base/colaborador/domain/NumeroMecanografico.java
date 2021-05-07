/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@Embeddable
public class NumeroMecanografico implements ValueObject, Comparable<NumeroMecanografico> {

    private static final long serialVersionUID = 1L;

    private String mecNumber;
    @Transient
    private final String regex = "^[0-9]{1,6}$";

    public NumeroMecanografico(final String mecanographicmecNumber) {
        if (StringPredicates.isNullOrEmpty(mecanographicmecNumber)) {
            throw new IllegalArgumentException(
                    "Mecanographic Number should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mecanographicmecNumber);

        if (m.matches())
            this.mecNumber=mecanographicmecNumber;
        else
            throw new IllegalArgumentException("Mecanographic Number does not fit the criteria");

        //check if it already exists
    }

    protected NumeroMecanografico() {
        // for ORM
    }

    public static NumeroMecanografico valueOf(final String mecanographicmecNumber) {
        return new NumeroMecanografico(mecanographicmecNumber);
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
        return this.mecNumber.equals(that.mecNumber);
    }

    @Override
    public int hashCode() {
        return this.mecNumber.hashCode();
    }

    @Override
    public String toString() {
        return this.mecNumber;
    }

    @Override
    public int compareTo(final NumeroMecanografico arg0) {
        return mecNumber.compareTo(arg0.mecNumber);
    }
}
