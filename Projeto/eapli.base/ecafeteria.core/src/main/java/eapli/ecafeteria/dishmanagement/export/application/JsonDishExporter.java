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
 * The JSON export Strategy implementation. In this scenario we are creating the JSON by hand but we
 * could have an implementation that relies on Jackson.
 *
 * @author Paulo Gandra de Sousa 28/04/2020
 *
 */
public class JsonDishExporter implements DishExporter {
    private PrintWriter stream;

    @Override
    public void begin(final String filename) throws IOException {
        stream = new PrintWriter(new FileWriter(filename));
        stream.print("[ ");
    }

    @Override
    public void element(final Dish e) {
        stream.print("{ ");
        stream.printf("\"Name\":\"%s\", ", e.name());
        stream.printf("\"Type\":\"%s\", ", e.dishType().identity());
        stream.printf("\"Active\":\"%s\"", e.isActive());
        e.nutricionalInfo().ifPresent(ni -> {
            stream.println(", \"NutricionalInfo\": {");
            stream.printf("\"Salt\":\"%s\",", ni.salt());
            stream.printf("\"Calories\":\"%s\"", ni.calories());
            stream.println("}");
        });
        stream.print("}");
    }

    @Override
    public void elementSeparator() {
        stream.println(", ");
    }

    @Override
    public void end() {
        stream.println(" ]");
    }

    @Override
    public void cleanup() {
        if (stream != null) {
            stream.close();
        }
    }
}
