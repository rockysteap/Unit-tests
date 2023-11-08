package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.MoodAnalyser;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// 3.5.
public class MoodAnalyserTest {

    MoodAnalyser moodAnalyser;

    @BeforeEach
    void setUp() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    void testHappyUserMood() {
        assertEquals("happy", moodAnalyser.analyseMood("Это был отличный день!"));
    }

    @Test
    void testUnhappyUserMood() {
        assertEquals("unhappy", moodAnalyser.analyseMood("Это был ужасный день!"));
    }

    @Test
    void testNormalUserMood() {
        assertEquals("so so", moodAnalyser.analyseMood("Это был обычный день."));
    }

}
