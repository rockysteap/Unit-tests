package seminar_tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user;

    @BeforeEach
    public void setUp() {
        user = new User("user1", "pass1");
    }

    @Test
    public void userIsAuthenticatedIsFalse() {
        assertFalse(user.isAuth());
    }

    @Test
    public void userAuthenticationReturnsFalse() {
        assertFalse(user.Auth("user", "pass"));
        assertFalse(user.isAuth());
    }


    @Test
    public void userAuthenticationReturnsTrue() {
        assertTrue(user.Auth(user.getLogin(), user.getPassword()));
        assertTrue(user.isAuth());
    }

    @Test
    public void userDeAuthentication() {
        user.Auth(user.getLogin(), user.getPassword());

        user.deAuth();

        assertFalse(user.isAuth());
    }

    @Test
    public void userCheckForAdminIsFalse() {
        assertFalse(user.isAdmin());
    }

    @Test
    public void userCheckForAdminIsTrue() {
        user.becomeAdmin();

        assertTrue(user.isAdmin());
    }
}
