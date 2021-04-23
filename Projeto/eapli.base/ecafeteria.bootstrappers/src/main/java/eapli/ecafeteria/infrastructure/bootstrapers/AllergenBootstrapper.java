/*
 * Copyright (c) 2013-2021 the original author or authors.
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
package eapli.ecafeteria.infrastructure.bootstrapers;

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.dishmanagement.application.RegisterAllergenController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

/**
 *
 * @author mcn
 */
public class AllergenBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(AllergenBootstrapper.class);

    private final RegisterAllergenController controller = new RegisterAllergenController();

    @Override
    public boolean execute() {
        register(TestDataConstants.ALLERGEN_GLUTEN,
                "Cereais que contêm glúten (trigo, centeio, cevada, aveia, espelta, gamut ou outras estirpes hibridizadas) e produtos à base destes cereais");
        register(TestDataConstants.ALLERGEN_CRUSTACEOS, "Crustáceos e produtos à base de crustáceos");
        register("ovos", "Ovos e produtos à base de ovos");
        register(TestDataConstants.ALLERGEN_PEIXES, "Peixes e produtos à base de peixe", "images/sardinha.jpg");
        register("amendoins", "Amendoins e produtos à base de amendoins");
        register("soja", "Soja e produtos à base de sojaAmendoins e produtos à base de amendoins");
        register("leite", "Leite e produtos à base de leite (incluindo lactose)");
        register("frutossecos",
                "Frutos de casca rija, nomeadamente, amêndoas, avelãs, nozes, castanhas de caju, pistácios, entre outros");
        register("aipo", "Aipo e produtos à base de aipo");
        register("mostarda", "Mostarda e produtos à base de mostarda");
        register("sesamo", "Sementes de sésamo e produtos à base de sementes de sésamo");
        register("sulfitos",
                "Dióxido de enxofre e sulfitos em concentrações superiores a 10mg/Kg ou 10ml/L");
        register("tremoco", "Tremoço e produtos à base de tremoço");
        register("moluscos", "Moluscos e produtos à base de moluscos");
        return true;
    }

    private void register(final String name, final String description) {
        try {
            controller.registerAllergen(name, description);
            LOGGER.info(name);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", name);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private void register(final String name, final String description, final String imageFilename) {
        // getting the input stream is a responsibility of the presentation layer
        final InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(imageFilename);

        if (inputStream == null) {
            LOGGER.warn("Could not load image {}", imageFilename);
            // fallback to registration without image
            register(name, description);
        } else {
            try {
                controller.registerAllergen(name, description, inputStream);
                LOGGER.info(name);
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                // ignoring exception. assuming it is just a primary key violation
                // due to the tentative of inserting a duplicated user
                LOGGER.warn("Assuming {} already exists (activate trace log for details)", name);
                LOGGER.trace("Assuming existing record", e);
            } catch (final IOException e) {
                LOGGER.error("There was a problem loading the image file {} while registering allergen {}",
                        imageFilename, name);
            }
        }
    }
}
