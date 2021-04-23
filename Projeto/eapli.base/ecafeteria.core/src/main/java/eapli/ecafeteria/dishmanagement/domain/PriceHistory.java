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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.general.domain.model.Money;
import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Invariants;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@XmlRootElement
@Entity
public class PriceHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue // (strategy = GenerationType.AUTO)
    private Long pk;

    /**
     * Showcase a collection of value objects mapped as Entity to allow the use of
     * {@code Embeddable} (value objects)
     * inside other {@code Embeddable} (value objects).
     */
    @XmlElementWrapper(name = "prices")
    @XmlElement(name = "history")
    @JsonProperty
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final List<PriceOnPeriod> history = new ArrayList<>();

    public PriceHistory(final Calendar startsOn, final Money price) {
        history.add(new PriceOnPeriod(startsOn, price));
    }

    public PriceHistory(final Money price) {
        this(Calendars.now(), price);
    }

    protected PriceHistory() {
        // for orm
    }

    void update(final Calendar startsOn, final Money price) {
        if (!history.isEmpty()) {
            // remove the current price (position = 0)
            final PriceOnPeriod lastPrice = history.remove(0);

            // close the period of validity and add element
            history.add(0, new PriceOnPeriod(lastPrice.startsOn(), startsOn, lastPrice.price()));
        }

        // add the new price with an open interval of validity
        history.add(0, new PriceOnPeriod(startsOn, price));
    }

    public Money current() {
        Invariants.nonEmpty(history);

        return history.get(0).price();
    }

    public Money onDate(final Calendar date) {
        Invariants.nonEmpty(history);

        final Iterator<PriceOnPeriod> iter = history.iterator();
        while (iter.hasNext()) {
            final PriceOnPeriod elem = iter.next();
            if (elem.includes(date)) {
                return elem.price();
            }
        }

        return null;
    }
}
