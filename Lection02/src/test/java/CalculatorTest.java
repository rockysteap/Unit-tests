import org.junit.jupiter.api.Disabled;
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

//    @Disabled
    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in;
        System.setIn(in);

        Calculator.getOperand();

        System.out.println(testedValue);
        System.setIn(inputStream);
    }

//    @Disabled
    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertThatThrownBy(Calculator::getOperand).isInstanceOf(IllegalStateException.class)
                .describedAs("Ошибка в вводимых данных");

        System.setIn(inputStream);
        System.setOut(null);
    }

}
