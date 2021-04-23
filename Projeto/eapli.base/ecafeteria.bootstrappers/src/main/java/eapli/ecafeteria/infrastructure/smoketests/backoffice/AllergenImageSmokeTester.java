/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.ecafeteria.infrastructure.smoketests.backoffice;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.dishmanagement.domain.Allergen;
import eapli.ecafeteria.dishmanagement.repositories.AllergenRepository;
import eapli.ecafeteria.infrastructure.bootstrapers.TestDataConstants;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.io.util.Files;
import ij.IJ;
import ij.ImagePlus;

/**
 *
 * @author Paulo Gandra Sousa 19/05/2020
 *
 */
public class AllergenImageSmokeTester implements Action {
    private static final Logger LOGGER = LogManager.getLogger(AllergenImageSmokeTester.class);

    private final AllergenRepository allergenRepo = PersistenceContext.repositories().allergens();

    @Override
    public boolean execute() {
        // peixes should already have an image
        final Allergen peixes = allergenRepo.ofIdentity(TestDataConstants.ALLERGEN_PEIXES)
                .orElseThrow(IllegalStateException::new);

        show(peixes);

        // gluten should not have an image
        final Allergen gluten = allergenRepo.ofIdentity(TestDataConstants.ALLERGEN_GLUTEN)
                .orElseThrow(IllegalStateException::new);

        LOGGER.info("Fetched Gluten from persistence storage");
        show(gluten);

        // let's set up an image for gluten
        final InputStream imageStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("images/gluten.jpg");
        if (imageStream != null) {
            try {
                gluten.changeImage(IOUtils.toByteArray(imageStream));

                LOGGER.info("Added an image to Gluten");
                show(gluten);
            } catch (final IOException e) {
                LOGGER.error(e);
            }
        } else {
            LOGGER.warn("");
        }
        // nothing else to do
        return true;
    }

    private void show(final Allergen allergen) {
        if (allergen.hasImage()) {
            LOGGER.info("Allergen {} has image", allergen.identity());

            try {
                // create temp file
                // TODO allow for other media types beside jpg. Will need to store that info on the
                // object
                final File file = File.createTempFile("allergen-image-" + allergen.identity(), ".jpg");
                file.deleteOnExit();
                LOGGER.info("Created temp file with allergen's image at {}", file.getAbsolutePath());

                // save content to temp file
                FileUtils.writeByteArrayToFile(file, allergen.image());

                // open the file and show it
                openFileEmbedded(file.getAbsolutePath());
                Files.openInOSViewer(file.getAbsolutePath());
            } catch (final IOException e) {
                LOGGER.error(e);
            } catch (final InterruptedException e) {
                LOGGER.error(e);
                Thread.currentThread().interrupt();
            }
        } else {
            LOGGER.info("Allergen {} has NO image", allergen);
        }
    }

    private void openFileEmbedded(final String path) {
        final ImagePlus imp = IJ.openImage(path);
        imp.show();
    }
}
