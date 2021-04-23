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

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Base class for Protocol parser testing.
 *
 * @author Paulo Gandra Sousa 03/06/2020
 *
 */
public abstract class BookingProtocolMessageParserTest {
    private static final Logger LOGGER = LogManager.getLogger(BookingProtocolMessageParserTest.class);

    /**
     * helper method
     *
     * @param msg
     * @param expected
     * @return
     */
    protected BookingProtocolRequest ensureParseResultsInMessageOfType(final String msg,
            final Class<? extends BookingProtocolRequest> expected) {
        final BookingProtocolRequest result = BookingProtocolMessageParser.parse(msg);
        assertTrue(result.getClass().isAssignableFrom(expected));

        return result;
    }

    /**
     * helper method
     *
     * @param msg
     * @return
     */
    protected BookingProtocolRequest ensureErrorInRequest(final String msg) {
        return ensureParseResultsInMessageOfType(msg, ErrorInRequest.class);
    }

    /**
     * helper method
     *
     * @param msg
     */
    protected void ensureErrorInRequest(final String[] msg) {
        for (int i = 0; i < msg.length; i++) {
            LOGGER.info("Testing for ERROR_IN_REQUEST #{}: {}", i, msg[i]);
            ensureParseResultsInMessageOfType(msg[i], ErrorInRequest.class);
        }
        LOGGER.info("Testing for ERROR_IN_REQUEST - All Clear");
    }

    /**
     * helper method
     *
     * @param msg
     * @return
     */
    protected BookingProtocolRequest ensureUnknownRequest(final String msg) {
        return ensureParseResultsInMessageOfType(msg, UnknownRequest.class);
    }

    /**
     * helper method
     *
     * @param msg
     */
    protected void ensureUnknownRequest(final String[] msg) {
        for (int i = 0; i < msg.length; i++) {
            LOGGER.info("Testing for UNKNOWN_REQUEST #{}: {}", i, msg[i]);
            ensureParseResultsInMessageOfType(msg[i], UnknownRequest.class);
        }
        LOGGER.info("Testing for UNKNOWN_REQUEST - All Clear");
    }
}