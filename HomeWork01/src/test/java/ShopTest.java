import Shop.Product;
import Shop.Shop;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopTest {
    /*
    1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
         (правильное количество продуктов, верное содержимое корзины).
    2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
    3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
         (проверьте правильность сортировки).
    */

    public static Shop myShop;
    public static List<Product> myProducts;
    public static List<String> testListNotSorted;
    public static List<String> testListSorted;


    public static void testWithAssertJ() {
        initializeShop();
        test_ListData_BeforeSort();
        test_MostExpensiveProduct();
        myShop.sortProductsByPrice();
        test_ListData_SortedByPrice();

    }

    public static void initializeShop() {
        // Подготовка списка товаров для использования в тестах
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        p1.setTitle("P1");
        p1.setCost(70);
        p2.setTitle("P2");
        p2.setCost(100);
        p3.setTitle("P3");
        p3.setCost(30);

        myProducts = new ArrayList<>();
        myProducts.add(p1);
        myProducts.add(p2);
        myProducts.add(p3);

        myShop = new Shop();
        myShop.setProducts(myProducts);

    }


    public static void test_ListData_BeforeSort() {
        // Проверка данных списка до сортировок
        // [Product{cost=70, title='P1'}, Product{cost=100, title='P2'}, Product{cost=30, title='P3'}]
        testListNotSorted = Arrays.asList(
                "Product{cost=70, title='P1'}",
                "Product{cost=100, title='P2'}",
                "Product{cost=30, title='P3'}");

        int i = 0;
        for (Product myProduct : myProducts) {
            assertThat(myProduct.toString()).isEqualTo(testListNotSorted.get(i));
            i++;
        }
    }


    public static void test_MostExpensiveProduct() {
        // Находит значение максимальной цены, перебрав все продукты в списке, и
        // сравнивает со значением, которое возвращается из метода поиска самого дорогого продукта
        // Product{cost=100, title='P2'}
        Integer maxPrice = 0;
        for (Product myProduct : myProducts) {
            if (myProduct.getCost() > maxPrice) {
                maxPrice = myProduct.getCost();
            }
        }
        assertThat(myShop.getMostExpensiveProduct().getCost()).isEqualTo(maxPrice);
    }


    public static void test_ListData_SortedByPrice() {
        // Проверка данных списка после сортировки по цене
        // [Product{cost=30, title='P3'}, Product{cost=70, title='P1'}, Product{cost=100, title='P2'}]
        testListSorted = Arrays.asList(
                "Product{cost=30, title='P3'}",
                "Product{cost=70, title='P1'}",
                "Product{cost=100, title='P2'}");

        int i = 0;
        for (Product myProduct : myProducts) {
            assertThat(myProduct.toString()).isEqualTo(testListSorted.get(i));
            i++;
        }
    }
}
