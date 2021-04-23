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
package eapli.ecafeteria.traceability.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.strings.util.StringPredicates;

/**
 * A material (e.g., rice) used in the cooking of a meal.
 *
 */
@Entity
public class Material implements AggregateRoot<String> {

    private static final long serialVersionUID = 1L;

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;
    @Version
    private Long version;

    // business ID
    @Column(unique = true, nullable = false)
    private String acronym;
    private String description;

    protected Material() {
        // for ORM
    }

    public Material(final String name, final String description) {
        if (StringPredicates.isNullOrEmpty(name)) {
            throw new IllegalArgumentException();
        }
        this.acronym = name;
        this.description = description;
    }

    public String description() {
        return this.description;
    }

    public void changeDescriptionTo(final String newDescription) {
        this.description = newDescription;
    }

    @Override
    public String identity() {
        return this.acronym;
    }

    @Override
    public boolean hasIdentity(final String id) {
        return id.equalsIgnoreCase(this.acronym);
    }

    @Override
    public boolean sameAs(final Object o) {
        if (!this.equals(o)) {
            return false;
        }
        final Material other = (Material) o;
        return acronym.equals(other.acronym) && description.equals(other.description);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }
}
