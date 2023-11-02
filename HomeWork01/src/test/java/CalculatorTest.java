import Calculator.Calculator;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CalculatorTest {

    // Тестирование с использованием библиотеки AssertJ
    public static void testWithAssertJ() {
        test_0_percent_Discount();
        test_10_percent_Discount();
        test_101_percent_Discount();
        test_negative_purchaseAmount();
        test_negative_discountAmount();
    }

    public static void test_0_percent_Discount() {
        // 0% скидка от 100
        assertThat(Calculator.calculateDiscount(100, 0)).isEqualTo(100);
    }

    public static void test_10_percent_Discount() {
        // 10% скидка от 100
        assertThat(Calculator.calculateDiscount(100, 10)).isEqualTo(90);
    }

    public static void test_101_percent_Discount() {
        // 101% скидка от 100
        assertThatThrownBy(() -> Calculator.calculateDiscount(100, 101)).isInstanceOf(ArithmeticException.class)
                .hasMessage("Размер скидки превышает 100%");
    }

    public static void test_negative_purchaseAmount() {
        // отрицательная сумма покупки
        assertThatThrownBy(() -> Calculator.calculateDiscount(-100, 1)).isInstanceOf(ArithmeticException.class)
                .hasMessage("Отрицательная сумма покупки");
    }

    public static void test_negative_discountAmount() {
        // отрицательное значение скидки
        assertThatThrownBy(() -> Calculator.calculateDiscount(100, -1)).isInstanceOf(ArithmeticException.class)
                .hasMessage("Отрицательное значение скидки");
    }


}
