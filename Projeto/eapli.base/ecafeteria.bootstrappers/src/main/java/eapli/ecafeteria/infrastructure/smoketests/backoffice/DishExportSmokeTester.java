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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.dishmanagement.export.application.ExportDishesController;
import eapli.ecafeteria.dishmanagement.export.application.FileFormat;
import eapli.framework.actions.Action;
import eapli.framework.io.util.Files;

/**
 *
 * @author Paulo Gandra de Sousa 28/04/2020
 *
 */
public class DishExportSmokeTester implements Action {
    private static final Logger LOGGER = LogManager
            .getLogger(DishExportSmokeTester.class);

    private final ExportDishesController exportDishesController = new ExportDishesController();

    @Override
    public boolean execute() {
        testExportTo(FileFormat.XML);
        testExportTo(FileFormat.CSV);
        testExportTo(FileFormat.JSON);

        // nothing else to do
        return true;
    }

    private void testExportTo(final FileFormat format) {
        final String filename = "target/export-dishes." + format.toString();
        try {
            exportDishesController.export(filename, format);
            outputExportedContent(format, filename);
        } catch (final IOException e) {
            LOGGER.error(e);
        }
    }

    private void outputExportedContent(final FileFormat format, final String filename)
            throws IOException {
        // output the exported content
        Files.textFrom(new FileInputStream(filename));
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("-- EXPORT DISHES TO {} --", format);

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    LOGGER.info(line);
                }
            }

            LOGGER.info("----");
        }
    }
}
