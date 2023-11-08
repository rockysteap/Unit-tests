package coverage;

import coverage.SomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SomeServiceTest {
    SomeService someService;

    // 3.1.
    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void multipleThreeNotFiveReturnsBuzz() {
        assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz");
    }

    @Test
    void multipleThreeNotFiveReturnsFizzBuzz() {
        assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,7,11,17,22})
    void multipleThreeNotFiveReturnsNumber(int i) {
        assertThat(someService.fizzBuzz(i)).isEqualTo(String.valueOf(i));
//        assertThat(someService.fizzBuzz(11)).isEqualTo("11");
    }

    @Test
    void checkFirstLast6IsTrue() {
        assertTrue(someService.firstLast6(new int[]{6, 2, 3}));
        assertTrue(someService.firstLast6(new int[]{2, 3, 6}));
    }

    @Test
    void checkFirstLast6IsFalse() {
        assertFalse(someService.firstLast6(new int[]{2, 6, 3}));
        assertFalse(someService.firstLast6(new int[]{2, 3}));
    }


    @ParameterizedTest
    @CsvSource({
            "2000.0,50,1000",
            "2000.0,100,0",
            "2000.0,0,2000"
    })
    void insufficientCoverageTest(double i, int d, int r) {

        assertThat(someService.calculatingDiscount(i, d)).isEqualTo(r); // обычная скидка


    }

    @Test
    void checkDiscountWithNegativePercentValue() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

    @Test
    void checkDiscountExceeds100Percent() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }

    @Test
    void checkLuckySumWithoutThirteen() {
        assertEquals(13, someService.luckySum(1, 4, 8));
    }

    @Test
    void checkLuckySumWithThirteenAsA() {
        assertEquals(12, someService.luckySum(13, 4, 8));
    }

    @Test
    void checkLuckySumWithThirteenAsB() {
        assertEquals(12, someService.luckySum(4, 13, 8));
    }

    @Test
    void checkLuckySumWithThirteenAsC() {
        assertEquals(12, someService.luckySum(4, 8, 13));
    }

}
