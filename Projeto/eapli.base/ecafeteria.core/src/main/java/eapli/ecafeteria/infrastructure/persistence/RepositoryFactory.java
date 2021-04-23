/*
 * Copyright (c) 2013-2021 the original author or authors.
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
package eapli.ecafeteria.infrastructure.persistence;

import eapli.ecafeteria.cafeteriausermanagement.repositories.CafeteriaUserRepository;
import eapli.ecafeteria.cafeteriausermanagement.repositories.CardMovementRepository;
import eapli.ecafeteria.cafeteriausermanagement.repositories.SignupRequestRepository;
import eapli.ecafeteria.dishmanagement.repositories.AllergenRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishRepository;
import eapli.ecafeteria.dishmanagement.repositories.DishTypeRepository;
import eapli.ecafeteria.mealbooking.repositories.BookingRepository;
import eapli.ecafeteria.mealmanagement.repositories.MealRepository;
import eapli.ecafeteria.reporting.dishes.repositories.DishReportingRepository;
import eapli.ecafeteria.sales.repositories.CreditRechargeRepository;
import eapli.ecafeteria.traceability.repositories.MaterialRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * The interface for the repository factory of eCafeteria.
 *
 * <p>
 * This is the Abstract Factory in the Abstract Factory (GoF) pattern. Each of the return types is
 * an Abstract Product.
 * For instance, {@link eapli.ecafeteria.dishmanagement.domain.repositories.DishRepository
 * DishRepository} is an Abstract Product while
 * {@link eapli.ecafeteria.persistence.impl.jpa.JpaDishRepository JpaDishRepository} is a Concrete
 * Product.
 * </p>
 *
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * Factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @return
     */
    DishTypeRepository dishTypes();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    DishTypeRepository dishTypes(TransactionalContext autoTx);

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    CafeteriaUserRepository cafeteriaUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CafeteriaUserRepository cafeteriaUsers();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    DishRepository dishes();

    MaterialRepository materials();

    CardMovementRepository cardMovements();

    CardMovementRepository cardMovements(TransactionalContext autoTx);

    CreditRechargeRepository creditRecharges();

    CreditRechargeRepository creditRecharges(TransactionalContext autoTx);

    DishReportingRepository dishReporting();

    MealRepository meals();

    AllergenRepository allergens();

    BookingRepository bookings();

    BookingRepository bookings(TransactionalContext ctx);
}
