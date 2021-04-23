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
package eapli.ecafeteria.dishmanagement.application;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import eapli.ecafeteria.dishmanagement.domain.Allergen;
import eapli.ecafeteria.dishmanagement.repositories.AllergenRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author mcn
 */
@UseCaseController
public class RegisterAllergenController {

    private final AllergenRepository repository = PersistenceContext.repositories().allergens();

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    public Allergen registerAllergen(final String name, final String description) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);

        final Allergen newAllergen = new Allergen(name, description);
        return repository.save(newAllergen);
    }

    /**
     * Registers an allergen with an image. Getting the input stream is a responsibility of the
     * presentation layer as it interfaces with the "outside world", i.e., can be a local file or
     * some other resource fetched from the cloud.
     *
     * @param name
     * @param description
     * @param imageStream
     * @return
     * @throws IOException
     */
    public Allergen registerAllergen(final String name, final String description,
            InputStream imageStream) throws IOException {
        authorizationService.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.MENU_MANAGER);

        final Allergen newAllergen = new Allergen(name, description, IOUtils.toByteArray(imageStream));
        return repository.save(newAllergen);
    }
}
