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
package eapli.ecafeteria.deamon.booking.protocol;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import eapli.ecafeteria.cafeteriausermanagement.domain.CafeteriaUser;
import eapli.ecafeteria.cafeteriausermanagement.domain.MecanographicNumber;
import eapli.ecafeteria.dishmanagement.domain.Dish;
import eapli.ecafeteria.dishmanagement.domain.DishType;
import eapli.ecafeteria.mealbooking.application.BookAMealForADayController;
import eapli.ecafeteria.mealbooking.domain.BookingToken;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.framework.csv.util.CsvLineMarshaler;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;
import eapli.framework.time.util.Calendars;

/**
 *
 * @author Paulo Gandra Sousa 08/06/2020
 *
 */
public abstract class BaseBookingRequestTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseBookingRequestTest.class);

    protected static final String NOT_IMPLEMENTED_YET = "not implemented yet";

    protected void setMockControllerNoData() {
        // MOCK controller
        BookingProtocolMessageParser.injectController(new BookAMealForADayController() {
            @Override
            public Iterable<Meal> getMealsOfADay(final Calendar when, final MealType forMeal) {
                return new ArrayList<>();
            }

            @Override
            public BookingToken bookMeal(final Meal meal, final CafeteriaUser booker) {
                return new BookingToken();
            }

            @Override
            public BookingToken bookMeal(final Long mealId, final MecanographicNumber booker) {
                return new BookingToken();
            }
        });
    }

    protected void setMockControllerUnknowns() {
        // MOCK controller
        BookingProtocolMessageParser.injectController(new BookAMealForADayController() {
            @Override
            public Iterable<Meal> getMealsOfADay(final Calendar when, final MealType forMeal) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public BookingToken bookMeal(final Meal meal, final CafeteriaUser booker) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public BookingToken bookMeal(final Long mealId, final MecanographicNumber booker) {
                throw new IllegalArgumentException("Unknown");
            }
        });
    }

    protected void setMockController1RowOfData() {
        // MOCK controller
        BookingProtocolMessageParser.injectController(new BookAMealForADayController() {
            @Override
            public Iterable<Meal> getMealsOfADay(final Calendar when, final MealType forMeal) {
                final DishType dt = new DishType("fish", "fish");
                final Dish d1 = new Dish(dt, Designation.valueOf("bacalhau"), Money.euros(7.95));
                final List<Meal> results = new ArrayList<>();
                results.add(new Meal(MealType.LUNCH, Calendars.now(), d1));
                return results;
            }

            @Override
            public BookingToken bookMeal(final Meal meal, final CafeteriaUser booker) {
                return new BookingToken();
            }

            @Override
            public BookingToken bookMeal(final Long mealId, final MecanographicNumber booker) {
                return new BookingToken();
            }
        });
    }

    protected void setMockControllerThrow() {
        // MOCK controller
        BookingProtocolMessageParser.injectController(new BookAMealForADayController() {
            @Override
            public Iterable<Meal> getMealsOfADay(final Calendar when, final MealType forMeal) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public BookingToken bookMeal(final Meal meal, final CafeteriaUser booker) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public BookingToken bookMeal(final Long mealId, final MecanographicNumber booker) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }
        });
    }

    @Test
    public void ensureBadRequest() throws ParseException {
        final String[] fixtures = getSemanticErrorFixtures();
        for (int i = 0; i < fixtures.length; i++) {
            LOGGER.info("Testing for BAD_REQUEST #{}: {}", i, fixtures[i]);
            ensureBadRequest(fixtures[i]);
        }
        LOGGER.info("Testing for BAD_REQUEST - All clear");
    }

    protected abstract String[] getSemanticErrorFixtures();

    public void ensureBadRequest(final String msg) throws ParseException {

        final BookingProtocolRequest req = BookingProtocolMessageParser.parse(msg);

        final String result = req.execute();
        LOGGER.info("{} -> {}", msg, result);

        final String[] tokens = CsvLineMarshaler.tokenize(result).toArray(new String[0]);
        assertEquals(4, tokens.length);
        assertEquals("BAD_REQUEST", tokens[0]);
        // assertEquals("\"" + unescapeQuotes(msg) + "\"", tokens[1]);
        assertEquals("", tokens[3]);// \n
        assertEquals('\n', result.charAt(result.length() - 1));
    }

    protected abstract String getSampleOkRequest();

    @Test
    public void ensureServerErrorOnThrows() throws ParseException {

        setMockControllerThrow();

        final BookingProtocolRequest req = BookingProtocolMessageParser
                .parse(getSampleOkRequest());

        final String result = req.execute();
        LOGGER.info("{} -> {}", getSampleOkRequest(), result);

        final String[] lines = result.split("\n");
        assertEquals(1, lines.length);

        final String[] tokens = CsvLineMarshaler.tokenize(lines[0]).toArray(new String[0]);
        assertEquals(3, tokens.length);
        assertEquals("SERVER_ERROR", tokens[0]);
        assertEquals("\"" + NOT_IMPLEMENTED_YET + "\"", tokens[2]);
        assertEquals('\n', result.charAt(result.length() - 1));
    }
}