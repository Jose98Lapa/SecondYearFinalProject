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
import eapli.ecafeteria.reporting.dishes.dto.DishesPerDishType;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

/**
 * This classes creates a report on the number of dishes per dish types by using
 * the AbstractListUI from the framework.
 *
 * @author PAG
 */
@SuppressWarnings("squid:S106")
public class ReportDishesPerDishTypeUI extends AbstractListUI<DishesPerDishType> {

    private final DishReportingController theController = new DishReportingController();

    @Override
    protected Iterable<DishesPerDishType> elements() {
        return this.theController.reportDishesPerDishType();
    }

    @Override
    protected Visitor<DishesPerDishType> elementPrinter() {
        return new DishesPerDishTypePrinter();
    }

    @Override
    protected String elementName() {
        return "Dishes per dish type";
    }

    @Override
    protected String listHeader() {
        return "DISHES PER DISH TYPE";
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
