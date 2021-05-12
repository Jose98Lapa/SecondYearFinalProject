package eapli.base.catalogue.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IconTest {
    @Test
    public void ensureIconCannotBeEmpty() {
        System.out.println("Icon can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new Icon(" "));
    }

    @Test
    public void ensureIconCannotBeNull() {
        System.out.println("Icon can not be null");
        assertThrows(IllegalArgumentException.class,() -> new Icon(null));
    }

}