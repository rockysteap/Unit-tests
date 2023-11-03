import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int firstOperand = getOperand();
        int secondOperand = getOperand();
        char operator = getOperator();
        int result = calculation(firstOperand, secondOperand, operator);
        System.out.println("Результат операции: " + result);
    }

    public static char getOperator() {
        System.out.print("Введите операцию: ");
        return scanner.next().charAt(0);
    }

    public static int getOperand() {
        System.out.print("Введите число: ");
        int operand;

        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте ещё раз.");
            if (scanner.hasNextInt()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Ошибка в вводимых данных");
            }
        }
        return operand;
    }

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
}
