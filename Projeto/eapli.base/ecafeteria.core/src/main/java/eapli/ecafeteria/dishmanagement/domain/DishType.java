/*
 * Copyright (c) 2013-2021 the original author or authors.
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.ecafeteria.dishmanagement.dto.DishTypeDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.strings.util.StringPredicates;

/**
 * A dish type, e.g., vegetarian or fish or meat.
 * <p>
 * This class is implemented in a more traditional way than DDD, by using
 * primitive types for the attributes instead of value objects. this means that
 * some semantic is lost and potential code duplication may rise if the same
 * concept is used as an attribute in more than one class. however, the learning
 * curve is smoother when compared to full DDD.
 *
 * @author MCN 29/03/2016.
 */
@XmlRootElement
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "acronym" }) })
public class DishType implements AggregateRoot<String> {

    private static final long serialVersionUID = 1L;

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;

    @Version
    private Long version;

    // business ID
    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private String acronym;

    @XmlElement
    @JsonProperty
    private String description;

    @XmlElement
    @JsonProperty
    private boolean active;

    protected DishType() {
        // for ORM
    }

    /**
     * DishType constructor.
     *
     * @param name
     *            Mandatory
     * @param description
     *            Mandatory
     */
    public DishType(final String name, final String description) {
        setName(name);
        setDescription(description);
        this.active = true;
    }

    /**
     * Sets and validates newDescription.
     *
     * @param newDescription
     */
    private void setDescription(final String newDescription) {
        if (descriptionMeetsMinimumRequirements(newDescription)) {
            this.description = newDescription;
        } else {
            throw new IllegalArgumentException("Invalid Description");
        }
    }

    /**
     * Sets and validates newName.
     *
     * @param newName
     *            The new DishType name.
     */
    private void setName(final String newName) {
        if (nameMeetsMinimumRequirements(newName)) {
            this.acronym = newName;
        } else {
            throw new IllegalArgumentException("Invalid Name");
        }
    }

    /**
     * Ensure name is not null or empty.
     *
     * @param name
     *            The name to assess.
     * @return True if name meets minimum requirements. False if name does not meet
     *         minimum requirements.
     */
    private static boolean nameMeetsMinimumRequirements(final String name) {
        return !StringPredicates.isNullOrEmpty(name);
    }

    /**
     * Ensure description is not null or empty.
     *
     * @param description
     *            The description to assess.
     * @return True if description meets minimum requirements. False if description
     *         does not meet minimum requirements.
     */
    private static boolean descriptionMeetsMinimumRequirements(final String description) {
        return !StringPredicates.isNullOrEmpty(description);
    }

    public String description() {
        return this.description;
    }

    public boolean isActive() {
        return this.active;
    }

    /**
     * Toggles the state of the dishtype, activating it or deactivating it
     * accordingly.
     *
     * @return whether the dishtype is active or not
     */
    public boolean toogleState() {

        this.active = !this.active;
        return isActive();
    }

    /**
     * Change DishType description
     *
     * @param newDescription
     *            New description.
     */
    public void changeDescriptionTo(final String newDescription) {
        if (!descriptionMeetsMinimumRequirements(newDescription)) {
            throw new IllegalArgumentException();
        }
        this.description = newDescription;
    }

    @Override
    public boolean hasIdentity(final String id) {
        return id.equalsIgnoreCase(this.acronym);
    }

    @Override
    public String identity() {
        return this.acronym;
    }

    @Override
    public boolean sameAs(final Object other) {
        final DishType dishType = (DishType) other;
        return this.equals(dishType) && description().equals(dishType.description())
                && isActive() == dishType.isActive();
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    public DishTypeDTO toDTO() {
        return new DishTypeDTO(acronym, description, active);
    }

    @Override
    public String toString() {
        return identity();
    }
}
