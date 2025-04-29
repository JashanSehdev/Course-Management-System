package Controllers;
import java.util.*;

public class AuthenticationManager{
    private List<User> users;

    public AuthenticationManager(){
        users = new ArrayList<>();
    }

    public void show_all_user(){
        for (User u : users){
            System.out.println(u.username+" "+u.role);
        }
    }

    public void register(String username,String password, String role,Course_Manager manager){

        for(User user : users){
            if(user.username.equalsIgnoreCase(username)){
                System.out.println("Username Already Exists");
                return;
            }
        }



        if (role.equalsIgnoreCase("Student")){
            users.add(new Student(username,password,manager)); // I think there are requirement to add course manager
        }
        else if(role.equalsIgnoreCase("Instructor")){
            users.add(new Instructor(username,password,manager));
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
