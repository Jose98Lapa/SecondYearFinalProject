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
package eapli.ecafeteria.deamon.booking.protocol;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import eapli.framework.csv.util.CsvLineMarshaler;

/**
 *
 * @author Paulo Gandra Sousa 05/06/2020
 *
 */
public class BookMealRequestTest extends BaseBookingRequestTest {
    private static final String BOOK_MEAL_1_USER1 = "BOOK_A_MEAL, 1, \"user1\"";

    private static final Logger LOGGER = LogManager.getLogger(BookMealRequestTest.class);

    // semantic error
    private static final String[] SEMANTIC_ERROR_FIXTURES = {
            // empty meal
            "BOOK_A_MEAL, , \"LUNCH\"",
            // invalid meal
            "BOOK_A_MEAL, 1a, \"LUNCH\"",
            // empty user
            "BOOK_A_MEAL, 1, \"\"",
            // unknown meal
            "BOOK_A_MEAL, 2345, \"user1\"",
            // unknown user
            "BOOK_A_MEAL, 1, \"abcxpto\"",
    };

    @Before
    public void setup() {
        setMockControllerUnknowns();
    }

    @Test
    public void ensureOkReturnsBookingId() throws ParseException {
        setMockControllerNoData();

        final BookingProtocolRequest req = BookingProtocolMessageParser
                .parse(BOOK_MEAL_1_USER1);

        final String result = req.execute();
        LOGGER.info("{} -> {}", BOOK_MEAL_1_USER1, result);

        final String[] lines = result.split("\n");
        assertEquals(1, lines.length);

        final String[] tokens = CsvLineMarshaler.tokenize(lines[0]).toArray(new String[0]);
        assertEquals(2, tokens.length);
        assertEquals('\n', result.charAt(result.length() - 1));
    }

    @Override
    protected String[] getSemanticErrorFixtures() {
        return SEMANTIC_ERROR_FIXTURES;
    }

    @Override
    protected String getSampleOkRequest() {
        return BOOK_MEAL_1_USER1;
    }
}
