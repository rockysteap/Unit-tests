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
            case '^' -> (int) Math.round(Math.pow(firstOperand, secondOperand));

            default -> throw new IllegalStateException("Неизвестный оператор " + operator);
        };
    }


    public static double computeCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double computeCircumference(double radius) {
        /*
        Описать разработку через тестирование (TDD - test driven development)
        1. Сначала пишется тест, покрывающий желаемое изменение,
        2. затем пишется код, который позволит пройти тест,
        //        return 0;
        //        return 2 * 3.14 * radius;
        3. и под конец проводится рефакторинг нового кода к соответствующим стандартам
        */
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        System.out.println(computeCircumference(10));
    }
}
