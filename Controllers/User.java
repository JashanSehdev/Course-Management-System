package Controllers;

abstract public class User {
    String username;
    String role;
    String password;
    User(String username, String password, String role){
        this.username = username;
        this.role = role;
        this.password = password;
    }
}
