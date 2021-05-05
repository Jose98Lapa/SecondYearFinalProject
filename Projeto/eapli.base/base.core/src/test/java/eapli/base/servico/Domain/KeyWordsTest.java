package eapli.base.servico.Domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KeyWordsTest {
    KeyWords keyWords = new KeyWords("AAAA");

    @Test
    public void test() {
        assertEquals(keyWords, new KeyWords("AAAA"));
        assertNotEquals(keyWords, new KeyWords("AA"));
        assertThrows(IllegalArgumentException.class,() -> new KeyWords("A22"));
        assertThrows(IllegalArgumentException.class,() -> new KeyWords(" "));
        assertThrows(IllegalArgumentException.class,() -> new KeyWords(null));
    }

}