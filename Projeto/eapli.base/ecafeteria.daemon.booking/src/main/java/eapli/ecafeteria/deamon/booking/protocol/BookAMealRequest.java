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

import eapli.ecafeteria.cafeteriausermanagement.domain.MecanographicNumber;
import eapli.ecafeteria.mealbooking.application.BookAMealForADayController;
import eapli.ecafeteria.mealbooking.domain.BookingToken;

/**
 *
 * @author Paulo Gandra Sousa 01/06/2020
 *
 */
public class BookAMealRequest extends BookingProtocolRequest {

    private final String mealid;
    private final String userid;

    public BookAMealRequest(final BookAMealForADayController controller, final String request, final String mealId,
            final String username) {
        super(controller, request);
        this.mealid = mealId;
        this.userid = username;
    }

    @Override
    public String execute() {
        // semantic validation
        Long meal;
        try {
            meal = Long.valueOf(mealid);
        } catch (final NumberFormatException e) {
            return buildBadRequest("Invalid meal id");
        }

        MecanographicNumber mec;
        try {
            mec = MecanographicNumber.valueOf(userid);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Invalid user mec. number");
        }

        // execution
        try {
            final BookingToken token = controller.bookMeal(meal, mec);
            // response
            return buildResponse(token);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Unknown meal and/or user mec. number");
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage());
        }
    }

    private String buildResponse(final BookingToken token) {
        return "BOOKED, \"" + token + "\"\n";
    }
}
