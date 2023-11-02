package Calculator;

public class Calculator {

    public static double calculateDiscount(double purchaseAmount, int discountAmount) {
        /*
         Проверить пограничные случаи:
         0% - 100% -> ok, отрицательная скидка не должна проходить (использовать ArithmeticException)
         purchaseAmount - сумма покупки
         discountAmount - размер скидки в процентах
         Метод должен возвращать сумму покупки со скидкой
        */
        if (purchaseAmount < 0) {
            throw new ArithmeticException("Отрицательная сумма покупки");
        }
        if (discountAmount < 0) {
            throw new ArithmeticException("Отрицательное значение скидки");
        }
        if (discountAmount > 100) {
            throw new ArithmeticException("Размер скидки превышает 100%");
        }
        if (discountAmount == 0) {
            return purchaseAmount;
        } else {
            return purchaseAmount - purchaseAmount * (discountAmount / (double) 100);
        }

    }
}
