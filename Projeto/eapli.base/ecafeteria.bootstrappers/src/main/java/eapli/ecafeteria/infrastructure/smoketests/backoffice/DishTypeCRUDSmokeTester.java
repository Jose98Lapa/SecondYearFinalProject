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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.framework.validations.Invariants;

/**
 *
 * @author Paulo Gandra de Sousa
 *
 */
public class DishTypeCRUDSmokeTester {
    private static final Logger LOGGER = LogManager.getLogger(DishTypeCRUDSmokeTester.class);

    private final DishTypeRepository repo = PersistenceContext.repositories().dishTypes();

    public void testDishTypeCRUD() {
        // save
        repo.save(new DishType("one", "one desc"));
        repo.save(new DishType("two", "two desc"));
        LOGGER.info("»»» created dish types");

        // findAll
        final Iterable<DishType> l = repo.findAll();
        Invariants.nonNull(l);
        Invariants.nonNull(l.iterator());
        Invariants.ensure(l.iterator().hasNext());
        LOGGER.info("»»» find all dish types");

        // count
        final long n = repo.count();
        LOGGER.info("»»» # dish types = {}", n);

        // ofIdentity
        final DishType dt1 = repo.ofIdentity("one").orElseThrow(IllegalStateException::new);
        final DishType dt2 = repo.ofIdentity("two").orElseThrow(IllegalStateException::new);
        LOGGER.info("»»» found dish types of identity");

        // containsOfIdentity
        final boolean hasId = repo.containsOfIdentity(dt1.identity());
        Invariants.ensure(hasId);
        LOGGER.info("»»» contains dish types of identity");

        // contains
        final boolean has = repo.contains(dt1);
        Invariants.ensure(has);
        LOGGER.info("»»» contains dish type");

        // delete
        repo.delete(dt1);
        LOGGER.info("»»» delete dish types");

        // deleteOfIdentity
        repo.deleteOfIdentity(dt2.identity());
        LOGGER.info("»»» delete dish types of identity");

        // size
        final long n2 = repo.size();
        Invariants.ensure(n2 == n - 2);
        LOGGER.info("»»» # dish types = {}", n2);
    }
}
