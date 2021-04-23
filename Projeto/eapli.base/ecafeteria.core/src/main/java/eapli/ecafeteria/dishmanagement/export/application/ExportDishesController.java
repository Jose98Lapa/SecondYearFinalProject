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
package eapli.ecafeteria.dishmanagement.export.application;

import java.io.IOException;

import eapli.ecafeteria.dishmanagement.application.ListDishService;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.framework.application.UseCaseController;

/**
 *
 * @author Paulo Gandra de Sousa 28/04/2020
 *
 */
@UseCaseController
public class ExportDishesController {

    private final ListDishService listSvc = new ListDishService();
    private final DishExporterFactory factory = new DishExporterFactory();
    private final DishExporterService exportSvc = new DishExporterService();

    public void export(final String filename, final FileFormat format) throws IOException {
        final DishExporter exporter = factory.build(format);

        // Note that we are fetching all the data from the database. This of course will only work
        // for a small amount of data. To export a large volume of data we should be using some kind
        // of cursor-based iterable and not a pure in-memory collection.
        final Iterable<Dish> dishes = listSvc.allDishes();
        exportSvc.export(dishes, filename, exporter);
    }
}
