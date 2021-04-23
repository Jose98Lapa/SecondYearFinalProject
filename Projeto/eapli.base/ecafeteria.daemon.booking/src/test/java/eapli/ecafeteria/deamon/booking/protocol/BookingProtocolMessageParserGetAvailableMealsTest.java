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
package eapli.ecafeteria.deamon.booking.protocol;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.domain.MecanographicNumber;
import eapli.ecafeteria.mealbooking.application.BookAMealForADayController;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;

/**
 * Test plan:
 * <ul>
 * <li>ensure rightly formatted message (for each message type) is parsed correctly</li>
 * <li>ensure wrongly formatted message (for each message type) is parsed to `ERROR_IN_REQUEST`</li>
 * <li>ensure unknown message type is parsed to `UnknownRequest`</li>
 * </ul>
 *
 * @author Paulo Gandra Sousa 03/06/2020
 *
 */
public class BookingProtocolMessageParserGetAvailableMealsTest extends BookingProtocolMessageParserTest {

    // OK
    static final String GET_AVAILABLE_MEALS_OK = "GET_AVAILABLE_MEALS, \"03/06/2020\", \"LUNCH\"";

    private static final String[] SINTAX_ERROR_FIXTURES = {
            // missing quotes
            "GET_AVAILABLE_MEALS, 03/06/2020, \"LUNCH\"",
            // missing quotes
            "GET_AVAILABLE_MEALS, \"03/06/2020\", \"LUNCH",
            // missing quotes
            "GET_AVAILABLE_MEALS, \"03/06/2020\", LUNCH",
            // missing param
            "GET_AVAILABLE_MEALS, \"LUNCH\"",
            // missing param
            "GET_AVAILABLE_MEALS, \"03/06/2020\"",
            // extra param
            "GET_AVAILABLE_MEALS, \"03/06/2020\", \"LUNCH\", 123",
            // no content meal type
            "GET_AVAILABLE_MEALS, \"03/06/2020\", ",
            // no content date
            "GET_AVAILABLE_MEALS, , \"LUNCH\"",
            // wrong number of parameters
            "GET_AVAILABLE_MEALS",
            // no content
            "GET_AVAILABLE_MEALS,,",
            // missing comma
            "GET_AVAILABLE_MEALS \"03/06/2020\", \"LUNCH\""
    };

    @Before
    public void setup() {
        // MOCK controller
        BookingProtocolMessageParser.injectController(new BookAMealForADayController() {
            @Override
            public Iterable<Meal> getMealsOfADay(final Calendar when, final MealType forMeal) {
                return new ArrayList<>();
            }

            @Override
            public BookingToken bookMeal(final Meal meal, final CafeteriaUser booker) {
                return BookingToken.valueOf("AAA000");
            }

            @Override
            public BookingToken bookMeal(final Long mealId, final MecanographicNumber booker) {
                return BookingToken.valueOf("AAA000");
            }
        });
    }

    @SuppressWarnings("java:S2699")
    @Test
    public void ensureParseOfProperMessage() {
        ensureParseResultsInMessageOfType(GET_AVAILABLE_MEALS_OK, GetAvailableMealsRequest.class);
    }

    @SuppressWarnings("java:S2699")
    @Test
    public void ensureErrorInRequest() {
        ensureErrorInRequest(SINTAX_ERROR_FIXTURES);
    }
}
