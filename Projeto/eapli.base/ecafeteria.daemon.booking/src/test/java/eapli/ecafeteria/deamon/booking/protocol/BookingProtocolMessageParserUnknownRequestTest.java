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

import org.junit.Test;

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
public class BookingProtocolMessageParserUnknownRequestTest extends BookingProtocolMessageParserTest {

    private static final String[] ERROR_FIXTURES = {
            "\"BOOK_A_MEAL\", 1, \"abc\"",
            "abc, 123",
            "GET_AVIALABLE_MEALS",
            "",
            "123:abc",
            "get_available_meals, \"03/06/2020\", \"LUNCH\""
    };

    @SuppressWarnings("java:S2699")
    @Test
    public void ensureUnknowRequest() {
        ensureUnknownRequest(ERROR_FIXTURES);
    }
}
