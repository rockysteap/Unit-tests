public class Calculator {
    public static int calculation(int firstOperand, int
            secondOperand, char operator) {
        return switch (operator) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            case '/' -> {
                if (secondOperand != 0) {
                    yield firstOperand / secondOperand;
                } else {
                    throw new ArithmeticException("Деление на ноль");
                }
            }

            default -> throw new IllegalStateException("Неизвестный оператор " + operator);
        };
    }
}
