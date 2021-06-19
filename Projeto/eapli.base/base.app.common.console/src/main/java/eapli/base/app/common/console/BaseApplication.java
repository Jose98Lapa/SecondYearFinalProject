/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.app.common.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.base.Application;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;
import eapli.framework.infrastructure.eventpubsub.impl.inprocess.InProcessPubSub;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.Color.BLACK;
import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.ansi;

/**
 *
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
public abstract class BaseApplication {

    // we are assuming we will always use the in process event
    // dispatcher. check the Spring version of the Base project
    // for an alternative
    final EventDispatcher dispatcher = InProcessPubSub.dispatcher();

    protected static final String SEPARATOR_HR = "=====================================";
    private static final Logger LOGGER = LogManager.getLogger(BaseApplication.class);

    /**
     * @param args
     *            the command line arguments
     */
    public void run(final String[] args) {
        printHeader();

        try {
            setupEventHandlers();

            doMain(args);

            printFooter();
        } catch (final Exception e) {
            System.out.println(
                    "Something unexpected has happened and the application will terminate. Please check the logs.\n");
            LOGGER.error(e);
        } finally {
            clearEventHandlers();
        }

        // exiting the application, closing all threads
        System.exit(0);
    }

    protected void printFooter() {
        System.out.println("\n");
        System.out.println(SEPARATOR_HR);
        System.out.println(appGoodbye());
        System.out.println(SEPARATOR_HR);
    }

    protected void printHeader() {
/*        System.out.println(SEPARATOR_HR);
        System.out.println(appTitle() + " " + Application.VERSION);
        System.out.println(Application.COPYRIGHT);
        System.out.println(SEPARATOR_HR)*/;
        System.setProperty("jansi.force", "true");
        System.setProperty("jansi.passthrough", "true");
        System.out.println("+==============================================================================+\n");
        AnsiConsole.systemInstall();
        Ansi ansi = ansi().fg(BLUE).a(" /$$   /$$           /$$                 /$$                     /$$      \n" +
                "| $$  | $$          | $$                | $$                    | $$      \n" +
                "| $$  | $$  /$$$$$$ | $$  /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$$| $$   /$$\n" +
                "| $$$$$$$$ /$$__  $$| $$ /$$__  $$ /$$__  $$ /$$__  $$ /$$_____/| $$  /$$/\n" +
                "| $$__  $$| $$$$$$$$| $$| $$  \\ $$| $$  | $$| $$$$$$$$|  $$$$$$ | $$$$$$/ \n" +
                "| $$  | $$| $$_____/| $$| $$  | $$| $$  | $$| $$_____/ \\____  $$| $$_  $$ \n" +
                "| $$  | $$|  $$$$$$$| $$| $$$$$$$/|  $$$$$$$|  $$$$$$$ /$$$$$$$/| $$ \\  $$\n" +
                "|__/  |__/ \\_______/|__/| $$____/  \\_______/ \\_______/|_______/ |__/  \\__/\n" +
                "                        | $$                                              \n" +
                "                        | $$                                              \n" +
                "                        |__/                                              \n" +
                "\n").fg(BLACK).reset();
        System.out.println(ansi);
    }

    private final void clearEventHandlers() {
        try {
            doClearEventHandlers(dispatcher);

            dispatcher.shutdown();
        } catch (final Exception e) {
            LOGGER.error("Unable to cleanup event handlers", e);
        }
    }

    private final void setupEventHandlers() {
        doSetupEventHandlers(dispatcher);
    }

    protected abstract void doMain(final String[] args);

    protected abstract String appTitle();

    protected abstract String appGoodbye();

    protected void doClearEventHandlers(final EventDispatcher dispatcher) {
        // nothing to do
    }

    protected abstract void doSetupEventHandlers(EventDispatcher dispatcher);
}
