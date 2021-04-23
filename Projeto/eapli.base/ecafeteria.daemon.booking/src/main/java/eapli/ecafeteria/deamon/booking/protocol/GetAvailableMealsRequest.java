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

import java.util.Calendar;

import eapli.ecafeteria.dishmanagement.domain.NutricionalInfo;
import eapli.ecafeteria.mealbooking.application.BookAMealForADayController;
import eapli.ecafeteria.mealmanagement.domain.Meal;
import eapli.ecafeteria.mealmanagement.domain.MealType;
import eapli.framework.csv.CsvRecord;
import eapli.framework.time.util.Calendars;

/**
 *
 * @author Paulo Gandra Sousa 01/06/2020
 *
 */
public class GetAvailableMealsRequest extends BookingProtocolRequest {

    private final String date;
    private final String type;

    public GetAvailableMealsRequest(final BookAMealForADayController controller, final String request,
            final String date, final String mealType) {
        super(controller, request);
        this.date = date;
        this.type = mealType;
    }

    @Override
    public String execute() {
        final Calendar forDay = Calendars.parse(date, "dd/MM/yyyy");
        if (forDay == null) {
            return buildBadRequest("Invalid date");
        }

        MealType mealType;
        try {
            mealType = MealType.valueOf(type);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Invalid meal type");
        }

        try {
            final Iterable<Meal> meals = controller.getMealsOfADay(forDay, mealType);
            return buildResponse(meals);
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage());
        }
    }

    private String buildResponse(final Iterable<Meal> meals) {
        final var sb = new StringBuilder();

        // header
        sb.append("\"ID\", \"NAME\", \"TYPE\", \"CALORIES\", \"SALT\", \"PRICE\"");
        sb.append("\n");

        // result rows
        for (final Meal each : meals) {
            sb.append(
                    CsvRecord.valueOf(new Object[] {
                            each.identity(),
                            each.dish().name(),
                            each.dish().dishType().identity(),
                            each.dish().nutricionalInfo().orElse(NutricionalInfo.UNKNOWN).salt(),
                            each.dish().nutricionalInfo().orElse(NutricionalInfo.UNKNOWN).calories(),
                            each.dish().currentPrice().amountAsDouble()
                    }).toString());
            // end of line
            sb.append("\n");
        }

        // end of message
        sb.append("\n");

        return sb.toString();
    }
}
