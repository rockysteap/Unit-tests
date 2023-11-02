import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    // метод без использования Assert
    public static void test1() {

        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }
        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }
        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }
        if (1 != Calculator.calculation(2, 2, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        try {
            Calculator.calculation(8, 4, '_');
        } catch (IllegalStateException e) {
            if (!e.getMessage().equals("Неизвестный оператор _")){
                throw new AssertionError("Ошибка в методе");
            }
        }
    }

    // метод c использованием assert
    public static void test1WithAssert(){

        // Assert - Утверждение -> Использует правильную логику
        assert 4 == Calculator.calculation(2,2,'+');
        assert 2 == Calculator.calculation(4,2,'-');
        assert 4 == Calculator.calculation(8,2,'/');
        assert 6 == Calculator.calculation(3,2,'*');

    }


    // метод c использованием библиотеки AssertJ
    public static void test1WithAssertJ(){

        assertThat(Calculator.calculation(2,2,'+')).isEqualTo(4);
        assertThat(Calculator.calculation(4,2,'-')).isEqualTo(2);
        assertThat(Calculator.calculation(8,2,'/')).isEqualTo(4);
        assertThat(Calculator.calculation(3,2,'*')).isEqualTo(6);

        assertThatThrownBy(() -> Calculator.calculation(8, 4, '_')).isInstanceOf(IllegalStateException.class);
    }

}
