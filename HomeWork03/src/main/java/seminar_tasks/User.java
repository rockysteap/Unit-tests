package seminar_tasks;

public class User {

    private String login;
    private String password;
    private boolean isAdmin = false;
    private boolean isAuth = false;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean Auth(String login, String password) {
        if (login.equals(this.login) && password.equals(this.password)) {
            this.isAuth = true;
            return true;
        }
        return false;
    }

    public void deAuth() {
        if (this.isAuth) {
            this.isAuth = false;
        }
    }

    public void becomeAdmin() {
        if (!this.isAdmin) {
            this.isAdmin = true;
        }
    }


    /* Setters/Getters*/

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


    public boolean isAuth() {
        return isAuth;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

}
