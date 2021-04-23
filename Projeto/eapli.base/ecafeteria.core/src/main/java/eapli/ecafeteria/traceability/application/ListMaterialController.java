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
package eapli.ecafeteria.traceability.application;

import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.traceability.domain.Material;
import eapli.ecafeteria.traceability.repositories.MaterialRepository;
import eapli.ecafeteria.usermanagement.domain.CafeteriaRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * Created on 29/03/2016.
 */
@UseCaseController
public class ListMaterialController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final MaterialRepository repository = PersistenceContext.repositories().materials();

    public Iterable<Material> all() {
        authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
                CafeteriaRoles.KITCHEN_MANAGER);
        return this.repository.findAll();
    }
}
