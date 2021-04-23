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
package eapli.ecafeteria.mealbooking.application;

import java.util.Calendar;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.domain.MecanographicNumber;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;

/**
 * In this case we are defining an interface for the controller in order to afterwards mock a
 * controller during tests.
 *
 * @author Paulo Gandra Sousa 05/06/2020
 *
 */
public interface BookAMealForADayController {

    /**
     *
     * @param when
     * @param forMeal
     * @return
     */
    Iterable<Meal> getMealsOfADay(Calendar when, MealType forMeal);

    /**
     *
     * @param mealId
     * @param booker
     * @return
     */
    BookingToken bookMeal(Long mealId, MecanographicNumber booker);

    /**
     *
     * @param meal
     * @param booker
     * @return
     */
    BookingToken bookMeal(Meal meal, CafeteriaUser booker);
}