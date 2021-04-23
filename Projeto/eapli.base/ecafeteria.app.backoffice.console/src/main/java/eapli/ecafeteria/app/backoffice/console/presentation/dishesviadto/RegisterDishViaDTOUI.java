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
package eapli.ecafeteria.app.backoffice.console.presentation.dishesviadto;

import eapli.ecafeteria.app.backoffice.console.presentation.dishes.NutricionalInfoDataWidget;
import eapli.ecafeteria.dishmanagement.application.viadto.RegisterDishViaDTOController;
import eapli.ecafeteria.dishmanagement.dto.DishDTO;
import eapli.ecafeteria.dishmanagement.dto.DishTypeDTO;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author Paulo Gandra de Sousa
 */
@SuppressWarnings("java:S106")
public class RegisterDishViaDTOUI extends AbstractUI {

    private final RegisterDishViaDTOController theController = new RegisterDishViaDTOController();

    @Override
    @SuppressWarnings("squid:S106")
    protected boolean doShow() {
        final Iterable<DishTypeDTO> dishTypes = this.theController.dishTypes();

        final SelectWidget<DishTypeDTO> selector = new SelectWidget<>("Dish types:", dishTypes,
                new DishTypeDTOPrinter());
        selector.show();
        final DishTypeDTO theDishType = selector.selectedElement();

        final String name = Console.readLine("Name");

        final NutricionalInfoDataWidget nutricionalData = new NutricionalInfoDataWidget();

        nutricionalData.show();

        final double price = Console.readDouble("Price");

        try {
            final DishDTO dish = new DishDTO(theDishType.acronym, theDishType.description, name,
                    nutricionalData.calories(), nutricionalData.salt(), price, "EUR", true);
            this.theController.registerDish(dish);
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("You tried to enter a dish which already exists in the database.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Register Dish";
    }
}
