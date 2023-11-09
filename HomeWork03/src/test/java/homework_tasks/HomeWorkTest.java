package homework_tasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWorkTest {

    // Task1

    @ParameterizedTest
    @ValueSource(ints = {-2, 0, 2})
    public void evenNumberSentForTrue(int n) {
        assertTrue(HomeWork.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1})
    public void oddNumberSentForFalse(int n) {
        assertFalse(HomeWork.evenOddNumber(n));
    }


    // Task2

    @ParameterizedTest
    @ValueSource(ints = {26, 99})
    public void numberInIntervalIsTrue(int n) {
        assertTrue(HomeWork.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100})
    public void numberInIntervalIsFalse(int n) {
        assertFalse(HomeWork.numberInInterval(n));
    }

}
