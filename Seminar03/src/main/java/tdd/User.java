package tdd;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;

    }

    //3.6.
    public boolean authenticate(String name, String password) {
        return false;
    }

}



/* Заготовка от преподавателя, написанная на семинаре

    public class User {
    String login;
    String pass;
    boolean aunt;
    boolean admin;

    public User() {
        this.login = "admin";
        this.pass = "admin";
        aunt=false;
        admin=false;
    }

    private boolean checkPass(String login, String pass) {
        if (this.login.equals(login) && this.pass.equals(pass)) {
            aunt=true;
            return true;
        } else {
            return false;
        }
    }
}

*/