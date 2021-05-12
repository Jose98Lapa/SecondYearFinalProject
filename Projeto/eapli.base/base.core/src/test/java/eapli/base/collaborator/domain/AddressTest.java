package eapli.base.collaborator.domain;

import eapli.base.collaborator.dto.AddressDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {
    Address address = new Address("Rua Galego","2","3","Viana do Castelo","4953-231");

    @Test
    public void test(){
        assertEquals(address,new Address("Rua Galego","2","3","Viana do Castelo","4953-231"));
        assertNotEquals(address,new Address("Rua dos Galego","2","3","Viana do Castelo","4953-231"));
        assertThrows(IllegalArgumentException.class,() -> new Address("","","","",""));
    }

    @Test
    void toDTO() {
        AddressDTO expected = new AddressDTO("Rua Galego","2","3","Viana do Castelo","4953-231");
        AddressDTO notExpected = new AddressDTO("Rua dos Galego","2","3","Viana do Castelo","4953-231");
        AddressDTO actual = address.toDTO();
        assertEquals(expected.andar,actual.andar);
        assertEquals(expected.codPostal,actual.codPostal);
        assertEquals(expected.localizacao,actual.localizacao);
        assertEquals(expected.rua,actual.rua);
        assertEquals(expected.numPorta,actual.numPorta);
        assertNotEquals(notExpected,actual);
    }
}