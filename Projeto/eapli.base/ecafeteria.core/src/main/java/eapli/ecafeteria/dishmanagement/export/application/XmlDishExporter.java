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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import eapli.ecafeteria.dishmanagement.domain.Dish;

/**
 * The XML export Strategy implementation. In this scenario we are creating the XML by hand but we
 * could have an implementation that relies on JAX-B.
 *
 * @author Paulo Gandra de Sousa 28/04/2020
 *
 */
public class XmlDishExporter implements DishExporter {

    private PrintWriter stream;

    @Override
    public void begin(final String filename) throws IOException {
        stream = new PrintWriter(new FileWriter(filename));
        stream.println("<Dishes>");
    }

    @Override
    public void element(final Dish e) {
        stream.println("<Dish>");
        stream.printf("<Name>%s</Name>%n", e.name());
        stream.printf("<Type>%s</Type>%n", e.dishType().identity());
        stream.printf("<Active>%s</Active>%n", e.isActive());
        e.nutricionalInfo().ifPresent((ni) -> {
            stream.println("<NutricionalInfo>");
            stream.printf("<Salt>%s</Salt>%n", ni.salt());
            stream.printf("<Calories>%s</Calories>%n", ni.calories());
            stream.println("</NutricionalInfo>");
        });
        stream.println("</Dish>");
    }

    @Override
    public void elementSeparator() {
        // nothing to do
    }

    @Override
    public void end() {
        stream.println("</Dishes>");
        stream.close();
    }

    @Override
    public void cleanup() {
        if (stream != null) {
            stream.close();
        }
    }
}
