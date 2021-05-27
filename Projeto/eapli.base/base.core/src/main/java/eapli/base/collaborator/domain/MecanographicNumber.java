/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@Embeddable
public class MecanographicNumber implements ValueObject, Comparable<MecanographicNumber>, Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    private String mecNumber;

    public MecanographicNumber(final String mecanographicmecNumber) {
        if (mecanographicmecNumber == null || mecanographicmecNumber.isEmpty() || !mecanographicmecNumber.matches("^[0-9]{1,6}$"))
            throw new IllegalArgumentException("Numero Mecanografico nao cumpre os critérios");
        this.mecNumber = mecanographicmecNumber;
        }


    protected MecanographicNumber() {
        // for ORM
    }

    public static MecanographicNumber valueOf(final String mecanographicmecNumber) {
        return new MecanographicNumber(mecanographicmecNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MecanographicNumber that = (MecanographicNumber) o;
        return Objects.equals(mecNumber, that.mecNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mecNumber);
    }

    @Override
    public String toString() {
        return this.mecNumber;
    }

    @Override
    public int compareTo(final MecanographicNumber arg0) {
        return mecNumber.compareTo(arg0.mecNumber);
    }
}
