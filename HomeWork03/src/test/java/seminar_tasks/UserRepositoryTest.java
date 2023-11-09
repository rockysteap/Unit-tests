package seminar_tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {

    UserRepository userRepo;
    User user1;
    User user2;
    User user3;
    User user4;
    User user5;
    List<User> testUserList;


    @BeforeEach
    public void setUp() {
        // Инициализируем репозиторий
        userRepo = new UserRepository();

        // Добавим новых пользователей
        user1 = new User("user1", "pass1");
        user2 = new User("user2", "pass2");
        user3 = new User("user3", "pass3");
        user4 = new User("user3", "pass3");
        user5 = new User("user3", "pass3");

        // и поместим всех во временный список для возможности перебора
        testUserList = List.of(new User[]{user1, user2, user3, user4, user5});

    }

    @Test
    public void userRepoWithoutUsersIsEmpty() {
        assertEquals(0, userRepo.getSize());
    }

    @Test
    public void notAuthedUserAddsToRepoIsFalse() {
        assertFalse(userRepo.addUser(user1));
    }

    @Test
    public void authedUserAddsToRepoIsTrue() {
        user1.Auth(user1.getLogin(), user1.getPassword());

        assertTrue(userRepo.addUser(user1));
    }

    @Test
    public void userRepoWithUsersIsNotEmpty() {
        user1.Auth(user1.getLogin(), user1.getPassword());

        userRepo.addUser(user1);

        assertEquals(1, userRepo.getSize());
    }


    // HomeWork Task3

    @Test
    public void checkDeAuthAllUserExceptAdmins() {
        // Назначим администраторов
        user3.becomeAdmin();
        user5.becomeAdmin();
        // Авторизуем всех пользователей и добавим в репозиторий
        for (User testUser : testUserList) {
            testUser.Auth(testUser.getLogin(), testUser.getPassword());
            userRepo.addUser(testUser);
        }

        // Сохраним в переменную текущий размер репозитория
        int repoSizeBeforeMassDeAuth = userRepo.getSize();
        // и количество пользователей не администраторов
        int noAdminUsersCount = 3;
        // Проведем массовое отключение всех, кроме администраторов
        userRepo.deAuthAllUsersExceptAdmins();

        // Проверим размер репозитория с учетом отключенных пользователей
        assertEquals(repoSizeBeforeMassDeAuth - noAdminUsersCount, userRepo.getSize());

    }

    @Test
    public void printUserRepoContentEqualsToReference() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Назначим администраторов
        user3.becomeAdmin();
        user5.becomeAdmin();
        // Авторизуем всех пользователей и добавим в репозиторий
        for (User testUser : testUserList) {
            testUser.Auth(testUser.getLogin(), testUser.getPassword());
            userRepo.addUser(testUser);
        }
        // Сохраним эталонный вариант вывода
        String reference = """
                Логин->user1 Авторизован->true Админ->false\r
                Логин->user2 Авторизован->true Админ->false\r
                Логин->user3 Авторизован->true Админ->true\r
                Логин->user3 Авторизован->true Админ->false\r
                Логин->user3 Авторизован->true Админ->true\r
                """;

        // Захватим поток вывода
        System.setOut(new PrintStream(outputStream));
        userRepo.printUsers();
        // Сохраним поток в переменную
        String printed = outputStream.toString();
        // Вернем оригинальный поток
        System.setOut(System.out);

        // Протестируем сохраненный вывод:
        assertEquals(reference, printed);
    }

}
