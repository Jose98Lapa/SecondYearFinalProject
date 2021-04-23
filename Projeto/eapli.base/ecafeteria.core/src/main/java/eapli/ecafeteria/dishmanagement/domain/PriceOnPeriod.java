/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.ecafeteria.dishmanagement.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Money;
import eapli.framework.time.domain.model.DateInterval;
import eapli.framework.validations.Preconditions;

/**
 * A price that is/was valid on a certain time period.
 * <p>
 * Showcases a value object (domain) mapped as a separate table (JPA entity).
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@XmlRootElement
@Entity
public class PriceOnPeriod implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long pk;

    @XmlElement
    @JsonProperty
    private final Money price;

    @XmlElement
    @JsonProperty
    private DateInterval validity;

    protected PriceOnPeriod() {
        // for orm
        price = null;
        validity = null;
    }

    private PriceOnPeriod(final Money price) {
        Preconditions.ensure(price != null && price.isPositive());

        this.price = price;
    }

    public PriceOnPeriod(final Calendar startsOn, final Calendar finishesOn, final Money price) {
        this(price);
        validity = new DateInterval(startsOn, finishesOn);
    }

    public PriceOnPeriod(final Calendar startsOn, final Money price) {
        this(price);
        validity = new DateInterval(startsOn);
    }

    public Money price() {
        return price;
    }

    public boolean includes(final Calendar onDate) {
        return validity.includes(onDate);
    }

    public Calendar startsOn() {
        return validity.start();
    }
}
