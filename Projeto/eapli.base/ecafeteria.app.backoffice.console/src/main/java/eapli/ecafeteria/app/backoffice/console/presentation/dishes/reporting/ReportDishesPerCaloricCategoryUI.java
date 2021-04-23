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
package eapli.ecafeteria.app.backoffice.console.presentation.dishes.reporting;

import eapli.ecafeteria.reporting.dishes.application.DishReportingController;
import eapli.ecafeteria.reporting.dishes.dto.DishesPerCaloricCategory;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

/**
 * This classes lists the number of dishes per dish type by using the
 * AbstractListUI from the framework.
 *
 * @author Paulo Gandra de Sousa
 */
public class ReportDishesPerCaloricCategoryUI extends AbstractListUI<DishesPerCaloricCategory> {

    private final DishReportingController theController = new DishReportingController();

    @Override
    protected Iterable<DishesPerCaloricCategory> elements() {
        return theController.reportDishesPerCaloricCategory();
    }

    @Override
    protected Visitor<DishesPerCaloricCategory> elementPrinter() {
        return new DishesPerCaloricCategoryPrinter();
    }

    @Override
    protected String elementName() {
        return "Dishes per Caloric Category";
    }

    @Override
    protected String listHeader() {
        return "DISHES PER CALORIC CATEGORY";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    public String headline() {
        return "Report";
    }
}
