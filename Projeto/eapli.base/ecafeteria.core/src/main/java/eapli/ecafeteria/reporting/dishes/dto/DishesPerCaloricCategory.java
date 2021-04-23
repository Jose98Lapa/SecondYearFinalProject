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
package eapli.ecafeteria.reporting.dishes.dto;

import java.math.BigInteger;

import eapli.framework.representations.dto.DTO;

/**
 * A pure DTO for reporting. We don't even bother in having the fields private
 * as the only purpose of this "class" is to carry data as a data bag.
 * <p>
 * We need the constructor just to simplify the JPA query methods
 *
 * @author Paulo Gandra de Sousa
 */
@SuppressWarnings({ "squid:ClassVariableVisibilityCheck" })
@DTO
public class DishesPerCaloricCategory {

    public String caloricCategory;
    // this needs to be a BigInteger because it is mapped from a native query
    // and JPA won't do type conversion
    public BigInteger quantityOfDishes;

    public DishesPerCaloricCategory(final String caloricCategory,
            final BigInteger quantityOfDishes) {
        this.caloricCategory = caloricCategory;
        this.quantityOfDishes = quantityOfDishes;
    }
}
