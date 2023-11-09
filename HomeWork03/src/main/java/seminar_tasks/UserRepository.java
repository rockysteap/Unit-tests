package seminar_tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {

    private final List<User> userList = new ArrayList<>();

    public boolean addUser(User user) {
        if (user.isAuth()) {
            userList.add(user);
            return true;
        }
        return false;
    }

    public Integer getSize() {
        return userList.size();
    }

    public void printUsers() {
        for (User user : userList) {
            System.out.println("Логин->" + user.getLogin()
                    + " Авторизован->" + user.isAuth() + " Админ->" + user.isAdmin());
        }
    }

    public void deAuthAllUsersExceptAdmins() {
        Iterator<User> userRepoIterator = userList.iterator();
        while (userRepoIterator.hasNext()) {
            User nextUser = userRepoIterator.next();
            if (!nextUser.isAdmin()) {
                nextUser.deAuth();
                userRepoIterator.remove();
            }
        }
    }

}



