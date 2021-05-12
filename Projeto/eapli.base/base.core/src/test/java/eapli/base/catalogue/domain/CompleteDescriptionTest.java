package eapli.base.catalogue.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompleteDescriptionTest {

    @Test
    public void ensureDescriptionCannotBeEmpty() {
        System.out.println("Complete description can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new CompleteDescription(" "));
    }

    @Test
    public void ensureDescriptionCannotBeNull() {
        System.out.println("Complete description can not be null");
        assertThrows(IllegalArgumentException.class,() -> new CompleteDescription(null));
    }

}