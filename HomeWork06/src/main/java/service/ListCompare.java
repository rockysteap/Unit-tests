package service;

import java.util.List;

public final class ListCompare {
    /**
     * Создайте программу, которая принимает два списка чисел и
     * выполняет следующие действия:
     * a. Рассчитывает среднее значение каждого списка.
     * b. Сравнивает эти средние значения и выводит соответствующее сообщение:
     * - ""Первый список имеет большее среднее значение"",
     * если среднее значение первого списка больше.
     * - ""Второй список имеет большее среднее значение"",
     * если среднее значение второго списка больше.
     * - ""Средние значения равны"", если средние значения списков равны.
     */

    private ListCompare() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Проверяет список на пустоту.
     * @param lst числовой список
     * @return double среднее арифметическое числового списка
     */
    public static Double getListAverage(final List<Number> lst) {
        if (lst.isEmpty()) {
            try {
                throw new Exception("Список пуст");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        double sum = 0;
        for (Number number : lst) {
            sum += number.doubleValue();
        }
        return sum / lst.size();
    }

    /**
     * Сравнивает средние арифметические числовых списков.
     *
     * @param lst1 числовой список
     * @param lst2 числовой список
     */
    public static void compareListsAverages(final List<Number> lst1,
                                            final List<Number> lst2) {
        double avr1 = getListAverage(lst1);
        double avr2 = getListAverage(lst2);

        if (avr1 > avr2) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if (avr1 < avr2) {
            System.out.println("Второй список имеет большее среднее значение");
        } else {
            System.out.println("Средние значения равны");
        }
    }

}
