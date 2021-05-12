package eapli.base.catalogue.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BriefDescriptionTest {

    @Test
    public void ensureDescriptionCannotBeToLong() {
        System.out.println("Brief description can not be too long");
        assertThrows(IllegalArgumentException.class,() -> new BriefDescription("Esta descrição breve é um bocado longa demais, pois se alguem se alongar demasiado numa descrição" +
                "breve, ela deixa de ser breve"));
    }

    @Test
    public void ensureDescriptionCannotBeEmpty() {
        System.out.println("Brief bescription can not be empty");
        assertThrows(IllegalArgumentException.class,() -> new BriefDescription(" "));
    }

    @Test
    public void ensureDescriptionCannotBeNull() {
        System.out.println("Brief description can not be null");
        assertThrows(IllegalArgumentException.class,() -> new BriefDescription(null));
    }

}