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
package eapli.ecafeteria.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.TransactionSystemException;

import eapli.ecafeteria.dishmanagement.application.RegisterDishController;
import eapli.ecafeteria.dishmanagement.domain.Allergen;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.repositories.AllergenRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.bootstrapers.TestDataConstants;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

/**
 *
 * @author mcn
 */
public class DishBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(DishBootstrapper.class);

    private final DishTypeRepository dishTypeRepo = PersistenceContext.repositories().dishTypes();
    private final AllergenRepository allergenRepo = PersistenceContext.repositories().allergens();
    private final RegisterDishController controller = new RegisterDishController();

    private DishType getDishType(final String acronym) {
        return dishTypeRepo.ofIdentity(acronym).orElseThrow(IllegalStateException::new);
    }

    private Allergen getAllergen(final String name) {
        return allergenRepo.ofIdentity(name).orElseThrow(IllegalStateException::new);
    }

    @Override
    public boolean execute() {
        final DishType vegie = getDishType(TestDataConstants.DISH_TYPE_VEGIE);
        final DishType fish = getDishType(TestDataConstants.DISH_TYPE_FISH);
        final DishType meat = getDishType(TestDataConstants.DISH_TYPE_MEAT);

        final Allergen gluten = getAllergen(TestDataConstants.ALLERGEN_GLUTEN);
        final Allergen peixe = getAllergen(TestDataConstants.ALLERGEN_PEIXES);
        final Allergen crustaceos = getAllergen(TestDataConstants.ALLERGEN_CRUSTACEOS);

        final Set<Allergen> allergeans1 = new HashSet<>();
        allergeans1.add(gluten);
        allergeans1.add(peixe);
        final Set<Allergen> allergeans2 = new HashSet<>();
        allergeans2.add(gluten);
        final Set<Allergen> allergeans3 = new HashSet<>();
        allergeans3.add(crustaceos);
        final Set<Allergen> allergeans4 = new HashSet<>();

        register(vegie, TestDataConstants.DISH_NAME_TOFU_GRELHADO, 140, 1, 2.99, null);
        register(vegie, TestDataConstants.DISH_NAME_LENTILHAS_SALTEADAS, 180, 1, 2.85, allergeans4);
        register(fish, TestDataConstants.DISH_NAME_BACALHAU_A_BRAZ, 250, 2, 3.99, allergeans1);
        register(fish, TestDataConstants.DISH_NAME_LAGOSTA_SUADA, 230, 2, 24.99, allergeans3);
        register(meat, TestDataConstants.DISH_NAME_PICANHA, 375, 2, 4.99, allergeans3);
        register(meat, TestDataConstants.DISH_NAME_COSTELETA_A_SALSICHEIRO, 475, 2, 3.99,
                allergeans2);

        return true;
    }

    private Optional<Dish> register(final DishType dishType, final String description,
            final int cal, final int salt,
            final double price, final Set<Allergen> allergens) {
        try {
            LOGGER.debug("{} ( {} )", description, dishType);

            if (allergens != null) {
                return Optional.of(
                        controller.registerDish(dishType, description, cal, salt, price,
                                allergens));
            } else {
                return Optional.of(
                        controller.registerDish(dishType, description, cal, salt, price));
            }
        } catch (final IntegrityViolationException | ConcurrencyException
                | TransactionSystemException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated object
            LOGGER.warn("Assuming {} already exists (see trace log for details on {} {})",
                    description,
                    e.getClass().getSimpleName(), e.getMessage());
            LOGGER.trace(e);
            return Optional.empty();
        }
    }
}
