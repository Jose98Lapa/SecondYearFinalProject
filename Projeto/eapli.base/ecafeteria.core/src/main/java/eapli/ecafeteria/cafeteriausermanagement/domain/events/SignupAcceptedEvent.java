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
package eapli.ecafeteria.cafeteriausermanagement.domain.events;

import eapli.ecafeteria.cafeteriausermanagement.domain.MecanographicNumber;
import eapli.ecafeteria.cafeteriausermanagement.domain.SignupRequest;
import eapli.framework.domain.events.DomainEventBase;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.Username;

/**
 * This is the event that is published when a {@link SignupRequest} is
 * accepted.
 * <p>
 * It is published by an
 * {@link eapli.framework.infrastructure.eventpubsub.EventPublisher}, in this
 * case inside
 * {@link eapli.ecafeteria.cafeteriausermanagement.application.AcceptRefuseSignupRequestControllerEventfulImpl}.
 * <p>
 * Afterwards it is processed by any
 * {@link eapli.framework.infrastructure.eventpubsub.EventHandler} that may
 * consume these types of events (e.g.
 * {@link eapli.ecafeteria.usermanagement.application.eventhandlers.SignupAcceptedWatchDog}.
 *
 * @author Paulo Gandra de Sousa
 */
public class SignupAcceptedEvent extends DomainEventBase {

    private static final long serialVersionUID = 1L;

    private final SignupRequest theSignupRequest;

    public SignupAcceptedEvent(final SignupRequest theSignupRequest) {
        this.theSignupRequest = theSignupRequest;
    }

    public Username username() {
        return theSignupRequest.username();
    }

    public Password password() {
        return theSignupRequest.password();
    }

    public Name name() {
        return theSignupRequest.name();
    }

    public EmailAddress email() {
        return theSignupRequest.email();
    }

    public MecanographicNumber mecanographicNumber() {
        return theSignupRequest.mecanographicNumber();
    }

    @Override
    public String toString() {
        return "SignupAccepted(" + username() + ")";
    }
}
