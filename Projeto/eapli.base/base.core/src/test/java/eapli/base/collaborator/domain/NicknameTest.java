package eapli.base.collaborator.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NicknameTest {
    Nickname nickname = new Nickname("Tomy");

    @Test
    public void test(){
        assertEquals(nickname, new Nickname("Tomy"));
        assertNotEquals(nickname, new Nickname("Johny"));
        assertThrows(IllegalArgumentException.class,() -> new Nickname(""));
        assertThrows(IllegalArgumentException.class,() -> new Nickname(null));
    }
}