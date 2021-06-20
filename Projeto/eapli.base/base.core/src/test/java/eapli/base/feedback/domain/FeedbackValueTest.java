package eapli.base.feedback.domain;

import eapli.base.team.domain.Acronym;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackValueTest {
    @Test
    public void test() {
        FeedbackValue feedbackValue = new FeedbackValue(1);
        assertEquals(feedbackValue, new FeedbackValue(1));
        assertNotEquals(feedbackValue, new FeedbackValue(2));
        assertThrows(IllegalArgumentException.class,() -> new FeedbackValue(-1));
        assertThrows(IllegalArgumentException.class,() -> new FeedbackValue(10));

    }
}