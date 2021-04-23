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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import eapli.ecafeteria.dishmanagement.dto.DishDTO;
import eapli.ecafeteria.dishmanagement.dto.DishDTORepresentationBuilder;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;

/**
 *
 * @author Paulo Gandra de Sousa
 *
 */
public class DishRepresentationalBuilderTest {

    private static final Designation BACALHAU_NAME = Designation.valueOf("Bacalhau");
    private static final DishType FISH_DISH_TYPE = new DishType("fish", "fish");
    private final Dish SIMPLE_BIZ_OBJ = new Dish(FISH_DISH_TYPE, BACALHAU_NAME, Money.euros(1.0));
    private final Dish WITH_NUTR_BIZ_OBJ = new Dish(FISH_DISH_TYPE, BACALHAU_NAME,
            new NutricionalInfo(1, 1),
            Money.euros(1.0));

    @Test
    public void ensureBuildReturnsAnObject() {
        final DishDTO subject = SIMPLE_BIZ_OBJ
                .buildRepresentation(new DishDTORepresentationBuilder());
        assertNotNull(subject);
    }

    @Test
    public void ensureBuildSimpleDish() {
        final DishDTO subject = SIMPLE_BIZ_OBJ
                .buildRepresentation(new DishDTORepresentationBuilder());
        assertEquals(SIMPLE_BIZ_OBJ.isActive(), subject.active);
        assertEquals(SIMPLE_BIZ_OBJ.name().toString(), subject.name);
        assertEquals(SIMPLE_BIZ_OBJ.dishType().identity().toString(), subject.dishTypeAcronym);
        assertEquals(SIMPLE_BIZ_OBJ.dishType().description().toString(),
                subject.dishTypeDescription);
        assertEquals(SIMPLE_BIZ_OBJ.currentPrice().amountAsDouble(), subject.price, 0.001);
        assertEquals(SIMPLE_BIZ_OBJ.currentPrice().currency().toString(), subject.currency);
        assertEquals(0, subject.calories);
        assertEquals(0, subject.salt);
    }

    @Test
    public void ensureBuildDishWithNutricionalInfo() {
        final DishDTO subject = WITH_NUTR_BIZ_OBJ
                .buildRepresentation(new DishDTORepresentationBuilder());
        assertEquals(WITH_NUTR_BIZ_OBJ.isActive(), subject.active);
        assertEquals(WITH_NUTR_BIZ_OBJ.name().toString(), subject.name);
        assertEquals(WITH_NUTR_BIZ_OBJ.dishType().identity().toString(), subject.dishTypeAcronym);
        assertEquals(WITH_NUTR_BIZ_OBJ.dishType().description().toString(),
                subject.dishTypeDescription);
        assertEquals(WITH_NUTR_BIZ_OBJ.currentPrice().amountAsDouble(), subject.price, 0.001);
        assertEquals(WITH_NUTR_BIZ_OBJ.currentPrice().currency().toString(), subject.currency);
        assertEquals(WITH_NUTR_BIZ_OBJ.nutricionalInfo().get().calories(), subject.calories);
        assertEquals(WITH_NUTR_BIZ_OBJ.nutricionalInfo().get().salt(), subject.salt);
    }
}
