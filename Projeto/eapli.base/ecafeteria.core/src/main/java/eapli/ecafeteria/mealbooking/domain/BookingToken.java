/*
 * Copyright (c) 2013-2020 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and
 * associated documentation files (the "Software"), to deal in the Software
 * without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish,
 * distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.ecafeteria.mealbooking.domain;

import java.util.UUID;

import javax.persistence.Embeddable;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

/**
 * A booking token used to identify a booking. it will be useful for the
 * delivery operation. A booking token is a unique string of characters
 *
 * <p/>
 * technically we are using a UUID as implementation but that detail is hidden
 * from the user of this class
 *
 * @author Paulo Gandra Sousa
 *
 */
@Embeddable
public class BookingToken implements ValueObject, Comparable<BookingToken> {

    private static final long serialVersionUID = -1820803667379631580L;

    private final String token;

    public BookingToken() {
        token = UUID.randomUUID().toString();
    }

    private BookingToken(final String value) {
        Preconditions.nonEmpty(value);
        token = UUID.fromString(value).toString();
    }

    public static BookingToken valueOf(final String value) {
        return new BookingToken(value);
    }

    @Override
    public String toString() {
        return token;
    }

    public static BookingToken newToken() {
        return valueOf(UUID.randomUUID().toString());
    }

    @Override
    public int compareTo(final BookingToken o) {
        return token.compareTo(o.token);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof BookingToken)) {
            return false;
        }
        final BookingToken other = (BookingToken) o;
        return token.equals(other.token);
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }
}
