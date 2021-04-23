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

import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import eapli.ecafeteria.dishmanagement.dto.DishDTO;
import eapli.ecafeteria.reporting.dishes.dto.DishesPerCaloricCategory;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.Representationable;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

/**
 * A Dish.
 *
 * <p>
 * <img src="dish.svg">
 * </p>
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 *
 *         <!--
 * @startuml dish.svg
 *
 *           package DishAgregate{
 *
 *           class Dish
 *           {
 *           Designation name;
 *           DishType dishType;
 *           NutricionalInfo nutricionalInfo;
 *           Money price;
 *           boolean active;
 *           Set<AllergenInDish> allergens;
 *           }
 *
 *           NutricionalInfo <-down- Dish
 *           Dish o-down- AllergenInDish : allergens
 *           }
 *
 *           package DishTypeAgregate{
 *
 *           class DishType
 *           }
 *
 *           DishType <-down- Dish
 *
 *           interface DTOable<DishDTO>
 *           {
 *           DishDTO toDTO();
 *           }
 *
 *           interface Representationable{
 *           +buildRepresentation()
 *           }
 *           interface RepresentationBuilder<R>{
 *           +startObject()
 *           +endObject()
 *           +startCollection()
 *           +endCollection()
 *           +withElement()
 *           +withProperty()
 *           }
 *           Representationable ..> RepresentationBuilder
 *
 *           Dish .up.|> DTOable
 *           Dish .up.|> Representationable
 *
 *           Dish .right.> DishDTO
 *           DTOable ..> DishDTO
 * @enduml
 *         -->
 */
@XmlRootElement
@Entity
@SqlResultSetMapping(name = "DishesPerCaloricCategoryMapping", classes = @ConstructorResult(targetClass = DishesPerCaloricCategory.class, columns = {
        @ColumnResult(name = "caloricCategory"), @ColumnResult(name = "n") }))
public class Dish implements AggregateRoot<Designation>, DTOable<DishDTO>, Representationable {

    private static final long serialVersionUID = 1L;

    /**
     * Immutable empty set of allergens for the situations where a dish does not
     * contain any allergen.
     */
    @SuppressWarnings("squid:S2386")
    public static final Set<Allergen> NO_ALLERGENS = Collections.emptySet();

    @Version
    private Long version;

    /**
     * This is just to showcase the use of EmbeddedId, but this class should have a private Long pk
     * since using a string as primary key is not efficient
     */
    @XmlElement
    @JsonProperty
    @EmbeddedId
    private Designation name;

    // cascade = CascadeType.NONE as the dishType is part of another aggregate
    @XmlElement
    @JsonProperty
    @ManyToOne(optional = false)
    private DishType dishType;

    @XmlElement
    @JsonProperty
    @AttributeOverride(name = "value", column = @Column(name = "shortDescription"))
    private Description shortDescription;

    @XmlElement
    @JsonProperty
    @AttributeOverride(name = "value", column = @Column(name = "longDescription"))
    private Description longDescription;

    @XmlElement
    @JsonProperty
    private NutricionalInfo nutricionalInfo;

    @XmlElement(name = "priceHistory")
    @JsonProperty
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private PriceHistory price;

    @XmlElement
    @JsonProperty
    private boolean active;

    /**
     * Showcase {@code ElementCollection} to have a collection of value objects.
     */
    @XmlElementWrapper(name = "allergens")
    @XmlElement(name = "allergenInDish")
    @JsonProperty
    @ElementCollection
    private final Set<AllergenInDish> allergens = new HashSet<>();

    /**
     * Constructs a dish with allergen information.
     *
     * @param dishType
     * @param name
     * @param nutricionalInfo
     * @param price
     * @param allergens
     */
    public Dish(final DishType dishType, final Designation name, final NutricionalInfo nutricionalInfo,
            final Money price, final Set<Allergen> allergens) {
        this(dishType, name, nutricionalInfo, price);

        Preconditions.nonNull(allergens);

        copyAllergens(allergens);
    }

    private void copyAllergens(final Set<Allergen> allergens) {
        // to keep with Information Expert principle we are copying the received data to our own
        // internal data. This way we do not suffer from side effects if someone accesses the
        // original data and changes it without our knowledge
        for (final Allergen allergen : allergens) {
            addAllergen(allergen);
        }
    }

    /**
     * Construtor.
     *
     * @param dishType
     *            - type of dish
     * @param name
     *            - name, e.g., Bacalhau à Braz
     * @param nutricionalInfo
     * @param price
     */
    public Dish(final DishType dishType, final Designation name, final NutricionalInfo nutricionalInfo,
            final Money price) {
        Preconditions.noneNull(dishType, name, nutricionalInfo);

        this.dishType = dishType;
        this.name = name;
        this.nutricionalInfo = nutricionalInfo;
        this.price = new PriceHistory(price);
        this.active = true;
    }

    /**
     * Constructor.
     *
     * @param dishType
     * @param name
     * @param price
     */
    public Dish(final DishType dishType, final Designation name, final Money price) {
        Preconditions.noneNull(dishType, name, price);

        this.dishType = dishType;
        this.name = name;
        this.nutricionalInfo = null;
        this.price = new PriceHistory(price);
        this.active = true;
    }

    protected Dish() {
        // for ORM only.
    }

    public boolean addAllergen(final Allergen allergen) {
        final AllergenInDish allergenInDish = new AllergenInDish(allergen);
        return allergens.add(allergenInDish);
    }

    /**
     *
     * @return a read-only set of Allergens in Dish
     */
    public Set<AllergenInDish> allergens() {
        // notice the unmodifiable "copy" we are returning to keep with the Information Expert
        // principle and disallow callers to change "our" attributes
        return Collections.unmodifiableSet(allergens);
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
    public boolean sameAs(final Object other) {
        if (!(other instanceof Dish)) {
            return false;
        }

        final Dish that = (Dish) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && dishType.equals(that.dishType)
                && nutricionalInfo.equals(that.nutricionalInfo) && price.equals(that.price)
                && active == that.active;
    }

    public DishType dishType() {
        return this.dishType;
    }

    @Override
    public Designation identity() {
        return this.name;
    }

    public Optional<NutricionalInfo> nutricionalInfo() {
        return Optional.ofNullable(this.nutricionalInfo);
    }

    public Designation name() {
        return this.name;
    }

    public Money currentPrice() {
        return price.current();
    }

    public Money priceOnDate(final Calendar date) {
        return price.onDate(date);
    }

    /**
     *
     * @return true or false whether is or not active
     */
    public boolean isActive() {
        return this.active;
    }

    /**
     * Toggles the state of the dish, activating it or deactivating it
     * accordingly.
     *
     * @return whether the dish is active or not
     */
    public boolean toogleState() {
        this.active = !this.active;
        return isActive();
    }

    /**
     * Changes the nutricional info of the dish.
     *
     * @param newNutricionalInfo
     *            The new NutricionalInfo.
     */
    public void changeNutricionalInfoTo(final NutricionalInfo newNutricionalInfo) {
        if (newNutricionalInfo == null) {
            throw new IllegalArgumentException();
        }
        this.nutricionalInfo = newNutricionalInfo;
    }

    /**
     * Changes the dish price to a new price.
     *
     * @param newPrice
     *            the new price of this dish
     */
    public void changePriceTo(final Money newPrice) {
        // TODO extra business logic associated with changing the price of a
        // dish, e.g., save price history
        price = new PriceHistory(newPrice);
    }

    /**
     * Showcase the {@link DTOable} interface. In this case it is the Dish class that dictates the
     * DTO structure.
     *
     * @see #buildRepresentation
     */
    @Override
    public DishDTO toDTO() {
        return new DishDTO(dishType.identity(),
                dishType.description(),
                name.toString(),
                nutricionalInfo.calories(),
                nutricionalInfo.salt(),
                currentPrice().amountAsDouble(),
                currentPrice().currency().getCurrencyCode(),
                active);
    }

    /**
     * Showcase the {@link Representationable} interface allowing the caller to decide on the actual
     * representation to
     * obtain, can be used to transform to custom DTOs.
     *
     * @see #toDTO
     */
    @Override
    public <R> R buildRepresentation(final RepresentationBuilder<R> builder) {
        builder.startObject("Dish")
                .withProperty("name", name)
                .withProperty("currentPrice", currentPrice())
                .withProperty("active", active)
                .startObject("dishType")
                .withProperty("acronym", dishType.identity())
                .withProperty("description", dishType.description())
                .endObject();
        if (nutricionalInfo != null) {
            builder.startObject("nutricionalInfo")
                    .withProperty("salt", nutricionalInfo.salt())
                    .withProperty("calories", nutricionalInfo.calories())
                    .endObject();
        }
        return builder.build();
    }
}
