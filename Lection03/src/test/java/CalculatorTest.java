import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void evaluatesAddition() {
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
    }


    @Test
    void evaluatesSubtraction() {
        assertThat(Calculator.calculation(4, 2, '-')).isEqualTo(2);
    }


    @Test
    void evaluatesMultiplication() {
        assertThat(Calculator.calculation(2, 6, '*')).isEqualTo(12);
    }


    @Test
    void evaluatesDivision() {
        assertThat(Calculator.calculation(6, 2, '/')).isEqualTo(3);
    }

    @Test
    void evaluatesExponentiation() {
        assertThat(Calculator.calculation(6, 3, '^')).isEqualTo(216);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol() {
        assertThatThrownBy(() -> Calculator.calculation(8, 4, '_'))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void computeCircleRadiusWorksCorrectly() {
        assertThat(Calculator.computeCircleArea(10)).isEqualTo(314.1592653589793);
    }

    @Test
    void computeCircumferenceWorksCorrectly() {
        /*  Описать разработку через тестирование (TDD - test driven development)
            1. Сначала пишется тест, покрывающий желаемое изменение,
            2. затем пишется код, который позволит пройти тест,
            3. и под конец проводится рефакторинг нового кода к соответствующим стандартам
         */
        assertThat(Calculator.computeCircumference(10)).isEqualTo(62.83185307179586);
    }

}
