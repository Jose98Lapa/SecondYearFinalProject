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
package eapli.ecafeteria.app.user.console;

import eapli.cafeteria.app.common.console.ECafeteriaBaseApplication;
import eapli.ecafeteria.app.user.console.presentation.FrontMenu;
import eapli.ecafeteria.cafeteriausermanagement.application.eventhandlers.MealBookedWatchDog;
import eapli.ecafeteria.infrastructure.persistence.PersistenceContext;
import eapli.ecafeteria.mealbooking.domain.BookedEvent;
import eapli.ecafeteria.usermanagement.domain.CafeteriaPasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;

/**
 * eCafeteria User Application.
 *
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
public final class ECafeteriaUserApp extends ECafeteriaBaseApplication {

    /**
     * Empty constructor is private to avoid instantiation of this class.
     */
    private ECafeteriaUserApp() {
    }

    public static void main(final String[] args) {

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new CafeteriaPasswordPolicy(), new PlainTextEncoder());

        new ECafeteriaUserApp().run(args);
    }

    @Override
    protected void doMain(final String[] args) {
        new FrontMenu().show();
    }

    @Override
    protected String appTitle() {
        return "my eCafeteria";
    }

    @Override
    protected String appGoodbye() {
        return "Thank you for using 'my eCafeteria'";
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doSetupEventHandlers(final EventDispatcher dispatcher) {
        // typically there would be this watch dog here as this would be handled by a backend
        // server, but since we are for now dealing only with console application clients we will do
        // it here
        dispatcher.subscribe(new MealBookedWatchDog(), BookedEvent.class);
    }
}
