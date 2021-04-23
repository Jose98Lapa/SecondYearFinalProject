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
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import eapli.framework.csv.util.CsvLineMarshaler;

/**
 *
 * @author Paulo Gandra Sousa 03/06/2020
 *
 */
public class GetAvailableMealsRequestTest extends BaseBookingRequestTest {
    private static final String GET_AVAILABLE_MEALS_05_06_2020_LUNCH = "GET_AVAILABLE_MEALS, \"05/06/2020\", \"LUNCH\"";

    private static final Logger LOGGER = LogManager.getLogger(GetAvailableMealsRequestTest.class);

    // semantic error
    private static final String[] SEMANTIC_ERROR_FIXTURES = {
            // empty date
            "GET_AVAILABLE_MEALS, \"\", \"LUNCH\"",
            // empty meal type
            "GET_AVAILABLE_MEALS, \"03/06/2020\", \"\"",
            // wrong date
            "GET_AVAILABLE_MEALS, \"03-06-2020\", \"LUNCH\"",
            // wrong date
            "GET_AVAILABLE_MEALS, \"03 06/2020\", \"LUNCH\"",
            // wrong date
            "GET_AVAILABLE_MEALS, \"abc2020\", \"LUNCH\"",
            // wrong meal type
            "GET_AVAILABLE_MEALS, \"03/06/2020\", \"BREAKFAST\"",
            // wrong meal type
            "GET_AVAILABLE_MEALS, \"03/06/2020\", \"23ab\"",
    };

    @Override
    protected String[] getSemanticErrorFixtures() {
        return SEMANTIC_ERROR_FIXTURES;
    }

    @Before
    public void setup() {
        setMockControllerNoData();
    }

    @Test
    public void ensureNoResultsCreatesHeaderOnly() throws ParseException {
        final BookingProtocolRequest req = BookingProtocolMessageParser
                .parse(GET_AVAILABLE_MEALS_05_06_2020_LUNCH);

        final String result = req.execute();
        LOGGER.info("{} -> {}", GET_AVAILABLE_MEALS_05_06_2020_LUNCH, result);

        final String[] lines = result.split("\n");
        assertEquals(1, lines.length);
        assertFirstRowIsHeader(result, lines);
        assertLastRowIsEmpty(result);
    }

    private void assertLastRowIsEmpty(final String result) {
        assertTrue(result.endsWith("\n\n"));
    }

    private void assertFirstRowIsHeader(final String result, final String[] lines) throws ParseException {
        final String[] tokens = CsvLineMarshaler.tokenize(lines[0]).toArray(new String[0]);
        assertEquals(6, tokens.length);
        assertEquals("\"ID\"", tokens[0]);
        assertEquals("\"NAME\"", tokens[1]);
        assertEquals("\"TYPE\"", tokens[2]);
        assertEquals("\"CALORIES\"", tokens[3]);
        assertEquals("\"SALT\"", tokens[4]);
        assertEquals("\"PRICE\"", tokens[5]);
    }

    @Test
    public void ensure1ResultCreatesHeaderAnd1Row() throws ParseException {

        setMockController1RowOfData();

        final BookingProtocolRequest req = BookingProtocolMessageParser
                .parse(GET_AVAILABLE_MEALS_05_06_2020_LUNCH);

        final String result = req.execute();
        LOGGER.info("{} -> {}", GET_AVAILABLE_MEALS_05_06_2020_LUNCH, result);

        final String[] lines = result.split("\n");
        assertEquals(2, lines.length);
        assertFirstRowIsHeader(result, lines);
        assertDataRow(lines[1]);
        assertLastRowIsEmpty(result);
    }

    private void assertDataRow(final String line) throws ParseException {
        final String[] tokens = CsvLineMarshaler.tokenize(line).toArray(new String[0]);
        assertEquals(6, tokens.length);
    }

    @Override
    protected String getSampleOkRequest() {
        return GET_AVAILABLE_MEALS_05_06_2020_LUNCH;
    }
}
