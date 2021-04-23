/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.ecafeteria.dishmanagement.domain;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

/**
 * The nutricional information of a dish.
 * <p>
 * Both {@code calories} and {@code salt} would be a very interesting situation to use
 * <a href="http://martinfowler.com/eaaDev/quantity.html">Quantity
 * pattern</a>
 * </p>
 * <p>
 * Also check the
 * <a hef="http://jscience.org/api/javax/measure/package-summary.html">javax.measure</a> javadocs or
 * <a href="https://www.baeldung.com/javax-measure">intro</a>
 * </p>
 *
 * @author Jorge Santos ajs@isep.ipp.pt 11/04/2016
 */
@Embeddable
public class NutricionalInfo implements ValueObject {

    private static final long serialVersionUID = 1L;

    /**
     * Special case value of unknown nutricional info. Even tough {@link Dish#nutricionalInfo()}
     * returns an Optional it might be helpful to have a Null value.
     */
    public static final NutricionalInfo UNKNOWN = new NutricionalInfo();

    @XmlElement
    @JsonProperty
    private final int calories;

    @XmlElement
    @JsonProperty
    private final int salt;

    public NutricionalInfo(final int calories, final int salt) {
        Preconditions.ensure(calories >= 0, "Calories can't be negative");
        Preconditions.ensure(salt >= 0, "Salt can't be negative");

        this.calories = calories;
        this.salt = salt;
    }

    /**
     * Special case constructor for unknown values and ORM.
     *
     * @param b
     */
    protected NutricionalInfo() {
        calories = salt = -1;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NutricionalInfo)) {
            return false;
        }

        final NutricionalInfo that = (NutricionalInfo) o;
        return calories == that.calories && salt == that.salt;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(calories).with(salt).code();
    }

    @Override
    public String toString() {
        return this.calories + " " + this.salt;
    }

    public int calories() {
        return this.calories;
    }

    public int salt() {
        return this.salt;
    }
}
