public class CalculateRoot {

    public static double calculation(int num, int root) {
        if (root == 0) {
            throw new ArithmeticException("Деление на ноль");
        } else if (root % 2 == 0) {
            return Math.pow(num, (double) 1 / root);
        } else {
            return Math.pow(num, (double) 1 / root);
        }
    }

}
