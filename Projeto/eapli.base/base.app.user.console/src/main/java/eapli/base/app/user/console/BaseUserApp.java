package eapli.base.app.user.console;


import eapli.base.app.user.console.presentation.FrontMenu;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Base User App.
 */
@SuppressWarnings("squid:S106")
public final class BaseUserApp {

    /**
     * Empty constructor is private to avoid instantiation of this class.
     */
    private BaseUserApp() {
    }

    public static void main(final String[] args) {
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

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        new FrontMenu().show();
       // new EspecificarServicoUI().show();

        // exiting the application, closing all threads
        System.exit(0);
    }
}
