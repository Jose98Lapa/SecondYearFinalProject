/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and
 * associated documentation files (the "Software"), to deal in the Software
 * without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish,
 * distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.ecafeteria.infrastructure.smoketests.backoffice;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.dishmanagement.domain.Allergen;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.repositories.AllergenRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishRepository;
import eapli.ecafeteria.infrastructure.bootstrapers.TestDataConstants;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;

/**
 * @author Paulo Gandra de Sousa 29/04/2020
 *
 */
public class DishesAndAllergensSmokeTester implements Action {
    private static final Logger LOGGER = LogManager.getLogger(DishesAndAllergensSmokeTester.class);

    private final DishRepository dishRepo = PersistenceContext.repositories().dishes();

    private final AllergenRepository allergenRepo = PersistenceContext.repositories().allergens();

    @Override
    public boolean execute() {
        listAllDishesWithGluten();

        listAllAllergensNotUsed();

        // nothing else to do
        return true;
    }

    private void listAllAllergensNotUsed() {
        // list all allergens not used in the cafeteria's dishes
        final Iterable<Allergen> notInUse = allergenRepo.findAllergensNotInUse();
        LOGGER.info("--- ALLERGENS NOT IN USE ---");
        for (final Allergen a : notInUse) {
            LOGGER.info("{}", a.identity());
        }
    }

    private void listAllDishesWithGluten() {
        // list all dishes with gluten
        final Optional<Allergen> maybeGluten = allergenRepo.ofIdentity(TestDataConstants.ALLERGEN_GLUTEN);
        final Iterable<Dish> dishesWithGluten = maybeGluten
                .map(dishRepo::findAllDishesWithAllergen)
                .orElseThrow(IllegalStateException::new);
        LOGGER.info("--- DISHES WITH GLUTEN ---");
        for (final Dish d : dishesWithGluten) {
            LOGGER.info("{}", d.identity());
        }
    }
}
