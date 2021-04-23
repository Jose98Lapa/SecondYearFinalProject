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
package eapli.ecafeteria.dishmanagement.dto;

import eapli.framework.representations.dto.DTO;

/**
 * A pure DTO for dishes. Members are public by design.
 *
 * @author Paulo Gandra de Sousa
 *
 */
@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class DishDTO {

    public DishDTO(final String dishTypeAcronym, final String dishTypeDescription,
            final String name2,
            final Integer calories2, final Integer salt2, final double amount,
            final String currency2, final boolean active2) {
        this.dishTypeAcronym = dishTypeAcronym;
        this.dishTypeDescription = dishTypeDescription;
        name = name2;
        calories = calories2;
        salt = salt2;
        price = amount;
        this.currency = currency2;
        this.active = active2;
    }

    public DishDTO() {
        // empty
    }

    public String dishTypeAcronym;
    public String dishTypeDescription;

    public String name;

    public int calories;
    public int salt;

    public double price;
    public String currency;

    public boolean active;
}
