package Controllers;

abstract public class User {
    public String username;
    public String role;
    protected String password;
    User(String username, String password, String role){
        this.username = username;
        this.role = role;
        this.password = password;
    }
}
