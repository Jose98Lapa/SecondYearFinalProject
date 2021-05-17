package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaceOfResidenceTest {
    PlaceOfResidence placeOfResidence = new PlaceOfResidence("Viana do Castelo");

    @Test
    public void test(){
        assertEquals(placeOfResidence, new PlaceOfResidence("Viana do Castelo"));
        assertNotEquals(placeOfResidence, new PlaceOfResidence("Porto"));
        assertThrows(IllegalArgumentException.class,() -> new PlaceOfResidence(""));
        assertThrows(IllegalArgumentException.class,() -> new PlaceOfResidence(null));
    }

}