/*
 * Copyright (c) 2013-2021 the original author or authors.
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
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;

/**
 * An Allergen.
 *
 * @author mcn
 */
@XmlRootElement
@Entity
public class Allergen implements AggregateRoot<String>, Serializable {

    private static final long serialVersionUID = 1L;

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;

    @Version
    private Long version;

    // this example uses a String instead of a specific value object
    @XmlAttribute
    @JsonProperty
    @Column(unique = true, nullable = false)
    private final String shortName;

    @XmlAttribute
    @JsonProperty
    private final String fullName;

    @JsonIgnore
    @XmlTransient
    @Lob
    private byte[] image;

    protected Allergen() {
        // for ORM
        shortName = null;
        fullName = null;
    }

    public Allergen(final String shortName, final String fullName, final byte[] image) {
        this(shortName, fullName);
        Preconditions.nonNull(image);

        changeImage(image);
    }

    public Allergen(final String shortName, final String fullName) {
        Preconditions.ensure(fullNameMeetsMinimumRequirements(fullName));
        Preconditions.ensure(shortNameMeetsMinimumRequirements(shortName));

        this.fullName = fullName;
        this.shortName = shortName;
    }

    /**
     * Ensure name is not null or empty.
     * <p>
     * This is duplicate code that would be avoided if we were using the
     * ShortName class instead of String.
     *
     * @param name
     * @return {@code true} if name meets minimum requirements. {@code false} otherwise.
     */
    private boolean shortNameMeetsMinimumRequirements(final String name) {
        return !StringPredicates.isNullOrEmpty(name);
    }

    /**
     * Ensure description is not null or empty.
     *
     * <p>
     * This is duplicate code that would be avoided if we were using the
     * Designation class instead of String.
     *
     * @param description
     * @return True if description meets minimum requirements. False if
     *         description does not meet minimum requirements.
     */
    private boolean fullNameMeetsMinimumRequirements(final String name) {
        return !StringPredicates.isNullOrEmpty(name);
    }

    public String shortName() {
        return shortName;
    }

    public String fullName() {
        return fullName;
    }

    @Override
    public String identity() {
        return shortName;
    }

    public byte[] image() {
        // defensive copy
        return Arrays.copyOf(image, image.length);
    }

    public void changeImage(final byte[] image) {
        // defensive copy
        this.image = Arrays.copyOf(image, image.length);
    }

    @Override
    public boolean sameAs(final Object other) {
        final Allergen allergean = (Allergen) other;
        return this.equals(allergean) && fullName.equals(allergean.fullName());
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean hasIdentity(final String name) {
        return name.equalsIgnoreCase(shortName);
    }

    public boolean hasImage() {
        return image != null && image.length != 0;
    }
}
