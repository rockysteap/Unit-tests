public class CalculateRootTest {

    public static void test1() {

        if (2 != CalculateRoot.calculation(4, 2)) {
            throw new AssertionError("Ошибка в методе");
        }

    }

    public static void testWithAssert() {

        assert 2 == CalculateRoot.calculation(4, 0);

    }

}
