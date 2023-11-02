public class Main {
    public static void main(String[] args) {
        test1();

    }

    public static void test1(){
        System.out.printf("Результат операции: %s \n", Calculator.calculation(2, 2, '+'));
        // Результат операции: 4
        System.out.printf("Результат операции: %s \n", Calculator.calculation(2, 1, '-'));
        // Результат операции: 1
        System.out.printf("Результат операции: %s \n", Calculator.calculation(2, 3, '*'));
        // Результат операции: 6
        System.out.printf("Результат операции: %s \n", Calculator.calculation(8, 2, '/'));
        // Результат операции: 4

//        System.out.printf("Результат операции: %s \n", Calculator.calculation(8, 2, '_'));
        // Результат операции: 0  // Некорректный результат
//        System.out.printf("Результат операции: %s \n", Calculator.calculation(8, 0, '/'));
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
//        System.out.printf("Результат операции: %s \n", Calculator.calculation(123456789128, 10, '*'));
        // java: integer number too large
//        System.out.printf("Результат операции: %s \n", Calculator.calculation(1234567891, 10, '*'));
        // Результат операции: -539222978

    }
}
