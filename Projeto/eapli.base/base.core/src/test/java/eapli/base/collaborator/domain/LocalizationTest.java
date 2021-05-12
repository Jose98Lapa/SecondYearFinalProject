package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocalizationTest {
    Localization localization = new Localization("Viana do Castelo");

    @Test
    public void test(){
        assertEquals(localization,new Localization("Viana do Castelo"));
        assertNotEquals(localization,new Localization("Porto"));
        assertThrows(IllegalArgumentException.class,() -> new Localization(""));
        assertThrows(IllegalArgumentException.class,() -> new Localization(null));
    }

}