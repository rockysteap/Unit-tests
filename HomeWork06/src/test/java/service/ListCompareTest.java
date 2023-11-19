package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListCompareTest {
    List<Number> numList1;
    List<Number> numList2;
    List<Number> numList3;
    List<Number> numList4;
    ByteArrayOutputStream outputStream;
    PrintStream printStream;

    @BeforeEach
    void setUp() {
        numList1 = new ArrayList<>(Arrays.asList(1.2, 2, 3.8, 40));
        numList2 = new ArrayList<>(Arrays.asList(1.2, 2, 3.8, 40));
        numList3 = new ArrayList<>(Arrays.asList(2, 4, 40));
        numList4 = new ArrayList<>();

        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
    }


    @Test
    void getListAverage_TestWithEmptyList() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> ListCompare.getListAverage(numList4));
        assertTrue(thrown.getMessage().contains("Список пуст"));
    }

    @Test
    void getListAverage_TestWithFilledList() {
        assertEquals((1.2 + 2 + 3.8 + 40) / 4, ListCompare.getListAverage(numList1));
    }

    @Test
    void compareListsAverages_TestWithEqualLists() {
        System.setOut(printStream);
        ListCompare.compareListsAverages(numList1, numList2);
        assertEquals("Средние значения равны", outputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    void compareListsAverages_TestWithFirstAverageLarger() {
        System.setOut(printStream);
        ListCompare.compareListsAverages(numList3, numList1);
        assertEquals("Первый список имеет большее среднее значение", outputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    void compareListsAverages_TestWithSecondAverageLarger() {
        System.setOut(printStream);
        ListCompare.compareListsAverages(numList2, numList3);
        assertEquals("Второй список имеет большее среднее значение", outputStream.toString().trim());
        System.setOut(System.out);
    }

    // Псевдо-интеграционный тест:
    // без заглушек проверим вызов модуля, который находит среднее, из модуля сравнения
    @Test
    void verifyGetListAverageCall() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> ListCompare.compareListsAverages(numList4, numList4));
        // проверим,
        assertTrue(thrown.getMessage().contains("Список пуст"));

    }

}