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
package eapli.ecafeteria.app.backoffice.console.presentation.meals;

import java.util.Calendar;

import eapli.ecafeteria.app.backoffice.console.presentation.dishes.DishPrinter;
import eapli.ecafeteria.dishmanagement.application.ListDishService;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.mealmanagement.application.RegisterMealController;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 * Work in Progress - not fully implemented
 *
 * @author losa
 */
@SuppressWarnings({ "squid:S106" })
public class RegisterMealUI extends AbstractUI {
    private final RegisterMealController controller = new RegisterMealController();
    private final ListDishService listDishService = new ListDishService();

    @Override
    protected boolean doShow() {
        try {
            final Calendar currentDay = Console.readCalendar("Which date?");
            final Dish theDish = selectDish();

            controller.registerMeal(MealType.LUNCH, currentDay, theDish);
        } catch (@SuppressWarnings("unused") final IntegrityViolationException ex) {
            System.out.println("There is already a meal for that day/type in that menu");
        }
        return false;
    }

    private Dish selectDish() {
        System.out.println("List of Dishes - Select a Dish");
        final Iterable<Dish> listDish = listDishService.allDishes();
        final SelectWidget<Dish> selectorDish = new SelectWidget<>("Select a dish", listDish,
                new DishPrinter());
        selectorDish.show();
        return selectorDish.selectedElement();
    }

    @Override
    public String headline() {
        return "Register Meal On a Menu";
    }
}
