package eapli.base.app.user.console.presentation;


import eapli.framework.io.util.Console;

import java.util.List;

public class Utils {
    static public < E > int selectIndex ( List< E > list, String question ) {

        int value;

        do {
            value = Console.readInteger(question);
        } while ( value < -1 || value > list.size( ) );

        return value;
    }

    static public < E > int selectIndex ( int size, String question,int limit ) {

        int value;

        do {
            value = Console.readInteger(question);
        } while ( value < limit || value > size );

        return value;
    }
}
