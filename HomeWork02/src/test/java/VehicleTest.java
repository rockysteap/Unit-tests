import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Проект Vehicle. Написать следующие тесты с использованием JUnit5: */
class VehicleTest {
    Car car;
    Motorcycle moto;

    @BeforeEach
    void setUp() {
        car = new Car("Volga", "2410", 1979);
        moto = new Motorcycle("Ural", "Gear UP 2023", 2023);
    }

    /* Тест 1 - Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя
оператор instanceof).*/
    @Test
    @DisplayName("Проверить, что экземпляр объекта Car это Vehicle")
    void checkIfCarIsAVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    /* Тест 2 - Проверить, что объект Car создается с 4-мя колесами.*/
    @Test
    @DisplayName("Проверить, что car создается с 4 колесами")
    void check4CarWheels() {
        assertEquals(car.getNumWheels(), 4);
    }

    /* Тест 3 - Проверить, что объект Motorcycle создается с 2-мя колесами.*/
    @Test
    @DisplayName("Проверить, что motorcycle c 2 колесами")
    void check2MotoWheels() {
        assertEquals(moto.getNumWheels(), 2);
    }

    /*- Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).*/
    @Test
    @DisplayName("Проверить, что Car развивает скорость 60 с помощью testDrive()")
    void checkCarTestDriveSpeed() {
        car.testDrive();
        assertEquals(car.getSpeed(), 60);
    }

    /* - Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод
testDrive()).*/
    @Test
    @DisplayName("Проверить, что Motorcycle развивает скорость 75 с помощью testDrive()")
    void checkMotoTestDriveSpeed() {
        moto.testDrive();
        assertEquals(moto.getSpeed(), 75);
    }

    /* - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина
останавливается (speed = 0).*/
    @Test
    @DisplayName("Проверить, что машина останавливается после testDrive()")
    void checkCarParkingAfterDriveSpeed() {
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);
    }

    /* - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл
останавливается (speed = 0).*/
    @Test
    @DisplayName("Проверить, что мотоцикл останавливается после testDrive()")
    void checkMotoParkingAfterDriveSpeed() {
        moto.testDrive();
        moto.park();
        assertEquals(moto.getSpeed(), 0);
    }
}
