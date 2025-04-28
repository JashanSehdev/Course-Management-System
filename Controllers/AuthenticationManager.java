package Controllers;
import java.util.*;

public class AuthenticationManager{
    private List<User> users;

    public AuthenticationManager(){
        users = new ArrayList<>();
    }

    public void register(String username,String password, String role){

        for(User user : users){
            if(user.username.equalsIgnoreCase(username)){
                System.out.println("Username Already Exists");
                return;
            }
        }



        if (role.equalsIgnoreCase("Student")){
            users.add(new Student(username,password));
        }
        else if(role.equalsIgnoreCase("Instructor")){
            users.add(new Instructor(username,password));
        }
        else {
            System.out.println("Invalid role");
        }

    }

    public User login(String username, String password){
        for(User user : users){
            if(user.username.equals(username) && user.password.equals(password)){
                return user;
            }
        }
        return null;
    }
}
