/*
 * Copyright (c) 2013-2021 the original author or authors.
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

import eapli.ecafeteria.dishmanagement.application.ActivateDeactivateDishController;
import eapli.ecafeteria.dishmanagement.application.ActivateDeactivateDishTypeController;
import eapli.ecafeteria.dishmanagement.application.ChangeDishController;
import eapli.ecafeteria.dishmanagement.application.ChangeDishTypeController;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.domain.NutricionalInfo;
import eapli.ecafeteria.infrastructure.bootstrapers.TestDataConstants;
import eapli.ecafeteria.reporting.dishes.application.DishReportingController;
import eapli.ecafeteria.reporting.dishes.dto.DishesPerCaloricCategory;
import eapli.ecafeteria.reporting.dishes.dto.DishesPerDishType;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.Money;
import eapli.framework.representations.builders.JsonRepresentationBuilder;
import eapli.framework.strings.FormattedString;
import eapli.framework.strings.PrettyJsonString;
import eapli.framework.strings.PrettyXmlString;
import eapli.framework.validations.Invariants;

/**
 *
 * @author Paulo Gandra de Sousa
 *
 */
public class DishManagementSmokeTester implements Action {
    private static final Logger LOGGER = LogManager.getLogger(DishManagementSmokeTester.class);

    private final ChangeDishTypeController changeDishTypeController = new ChangeDishTypeController();
    private final ChangeDishController changeDishController = new ChangeDishController();
    private final DishTypeCRUDSmokeTester crudTester = new DishTypeCRUDSmokeTester();
    private final ActivateDeactivateDishController activateDishController = new ActivateDeactivateDishController();
    private final DishReportingController dishReportingController = new DishReportingController();
    private final ActivateDeactivateDishTypeController activateDishTypeController = new ActivateDeactivateDishTypeController();

    @Override
    public boolean execute() {
        testDishTypeCRUD();
        testActivateDeactivateDishType();
        testChangeDishType();
        testChangeMeatDishType();

        testActivateDeactivateDish();
        testChangeDish();
        testChangePicanhaDish();
        testReportingDish();

        testDishJsonRepresentation();

        testDishJsonMapping();
        testDishXmlMapping();

        // nothing else to do
        return true;
    }

    /**
     * Get a JSON representation based on jackson annotations. This is ideal for scenarios where
     * there is only one representation needed for all use cases and we want to take advantage of a
     * library to avoid coding errors.
     */
    private void testDishJsonMapping() {
        final Iterable<Dish> l = changeDishController.allDishes();
        Invariants.nonNull(l);

        final Dish dish = l.iterator().next();

        final FormattedString json = PrettyJsonString.fromObject(dish);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("-- DISH Mapping to JSON --");
            LOGGER.info(json.toString());
        }
    }

    /**
     * Get an XML representation based on JAX-B annotations. This is ideal for scenarios where
     * there is only one representation needed for all use cases and we want to take advantage of a
     * library to avoid coding errors.
     */
    private void testDishXmlMapping() {
        final Iterable<Dish> l = changeDishController.allDishes();
        Invariants.nonNull(l);

        final Dish dish = l.iterator().next();

        final FormattedString xml = PrettyXmlString.fromObject(dish, Dish.class);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("-- DISH Mapping to XML --");
            LOGGER.info(xml.toString());
        }
    }

    /**
     * Get a JSON representation using the {@link eapli.framework.representations.Representationable
     * Representationable} interface. This is ideal for scenarios where there might be the need to
     * get different representations for different use cases. In such scenarios we cannot rely on a
     * single DTO or automatic mapping thru Jackson/JAX-B.
     *
     * @param dish
     */
    private void testDishJsonRepresentation() {
        final Iterable<Dish> l = changeDishController.allDishes();
        Invariants.nonNull(l);

        final Dish dish = l.iterator().next();

        final var builder = new JsonRepresentationBuilder();
        final String json = dish.buildRepresentation(builder);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("-- DISH JSON --");
            LOGGER.info(json);
            LOGGER.info("-- DISH Pretty JSON --");
            LOGGER.info(PrettyJsonString.fromString(json).toString());
        }
    }

    private void testDishTypeCRUD() {
        crudTester.testDishTypeCRUD();
    }

    /**
     * This smoke test just changes the first dish type it gets from the controller simulating the
     * user has selected one
     * from a dropbox or some other UI widget.
     */
    private void testChangeDishType() {
        final Iterable<DishType> l = changeDishTypeController.dishTypes();
        Invariants.nonNull(l);

        final DishType dt = l.iterator().next();

        doChangeDishTypeAndLog(dt);
    }

    /**
     * This smoke test changes one specific dish type simulating the user has searched for dish
     * types by their acronym.
     */
    private void testChangeMeatDishType() {
        final Optional<DishType> searched = changeDishTypeController
                .searchDishType(TestDataConstants.DISH_TYPE_MEAT);
        final Optional<DishType> changed = searched.map(this::doChangeDishTypeAndLog);
        if (!changed.isPresent()) {
            LOGGER.info("»»» The dish type {} does not exist", TestDataConstants.DISH_TYPE_MEAT);
        }
    }

    private DishType doChangeDishTypeAndLog(final DishType dt) {
        final String newDescription = dt.description() + " (edited)";
        final DishType changedDishType = changeDishTypeController.changeDishType(dt,
                newDescription);
        Invariants.ensure(dt.description().equals(newDescription));

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("»»» Changed description of {} to {}", dt.identity(),
                    changedDishType.description());
        }

        return changedDishType;
    }

    private void testActivateDeactivateDish() {
        final Iterable<Dish> l = activateDishController.allDishes();
        Invariants.nonNull(l);

        Dish dish = l.iterator().next();

        final boolean oldStatus = dish.isActive();

        dish = activateDishController.changeDishState(dish);
        Invariants.ensure(dish.isActive() == !oldStatus);

        LOGGER.info("»»» Changed status of {} to {}", dish, dish.isActive());
    }

    /**
     * This smoke test simulates the user selecting the entry in a dropdown UI.
     */
    private void testChangeDish() {
        final Iterable<Dish> l = changeDishController.allDishes();
        Invariants.nonNull(l);

        final Dish dish = l.iterator().next();

        doChangeDishAndLog(dish);
    }

    /**
     * This smoke test simulates the user searching for a dish.
     */
    private void testChangePicanhaDish() {
        final Optional<Dish> searched = changeDishController
                .searchDish(TestDataConstants.DISH_NAME_PICANHA);
        final Optional<Dish> changed = searched.map(this::doChangeDishAndLog);
        if (!changed.isPresent()) {
            LOGGER.info("»»» The dish {} does not exist", TestDataConstants.DISH_NAME_PICANHA);
        }
    }

    private Dish doChangeDishAndLog(final Dish dish) {
        // change price
        final Money oldPrice = dish.currentPrice();
        final Money newPrice = oldPrice.add(Money.euros(1));
        final Dish changedPrice = changeDishController.changeDishPrice(dish, newPrice);
        Invariants.ensure(dish.currentPrice().equals(newPrice));

        LOGGER.info("»»» Changed price of {} to {}", dish, dish.currentPrice());

        // change nutricional info
        final NutricionalInfo newInfo = new NutricionalInfo(10, 2);
        final Dish changedPriceAndNutricional = changeDishController.changeDishNutricionalInfo(changedPrice, newInfo);
        Invariants.ensure(
                changedPriceAndNutricional.nutricionalInfo().orElseThrow(IllegalStateException::new).equals(newInfo));

        LOGGER.info("»»» Changed nutricional info of {} to {}", dish, changedPriceAndNutricional.nutricionalInfo());

        return changedPriceAndNutricional;
    }

    private void testReportingDish() {
        final Iterable<DishesPerCaloricCategory> l1 = dishReportingController
                .reportDishesPerCaloricCategory();
        Invariants.nonNull(l1);

        final Iterable<Object[]> l2 = dishReportingController
                .reportDishesPerCaloricCategoryAsTuples();
        Invariants.nonNull(l2);

        final Iterable<DishesPerDishType> l3 = dishReportingController.reportDishesPerDishType();
        Invariants.nonNull(l3);

        final Iterable<Dish> l4 = dishReportingController.reportHighCaloriesDishes();
        Invariants.nonNull(l4);

        LOGGER.info("»»» Reporting dishes");
    }

    private void testActivateDeactivateDishType() {
        final Iterable<DishType> l = activateDishTypeController.allDishTypes();
        Invariants.nonNull(l);

        DishType dish = l.iterator().next();

        final boolean oldStatus = dish.isActive();

        dish = activateDishTypeController.changeDishTypeState(dish);
        Invariants.ensure(dish.isActive() == !oldStatus);

        LOGGER.info("»»» Changed status of {} to {}", dish, dish.isActive());
    }
}
