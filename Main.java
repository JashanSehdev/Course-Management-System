import Controllers.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Course_Manager manager = new Course_Manager();
        AuthenticationManager authenticate = new AuthenticationManager();
        User user=null;
        Scanner sc = new Scanner(System.in);

        // Authentication
        while(true) {
            String option;
            System.out.println("Do you want to register or login");
            option = sc.nextLine();
            switch (option) {
                case "register":
                    System.out.println("Enter your UserName");
                    String username = sc.nextLine();
                    System.out.println("Enter your password");
                    String password = sc.nextLine();
                    System.out.println("Are you a Student or Instructor?");
                    String role = sc.nextLine();
                    authenticate.register(username, password, role,manager);
                    System.out.println("You have registered Successfully now you have to login");
                    break;
                case "login":
                    System.out.println("Enter your UserName");
                    username = sc.nextLine();
                    System.out.println("Enter your password");
                    password = sc.nextLine();
                    user = authenticate.login(username, password);
                    break;
            }

            if(user != null){
                System.out.println("Login Successful, Welcome "+user.username);
                System.out.println("-----------------------------------------------");
                System.out.println();
                break;
            }
            else {
                System.out.println("wrong login credentials \n");
                continue;
            }
        }

        //

        switch (user.role){
            case "student":
                Student student = (Student) user;
                while(true){
                    int option;
                    System.out.println("press number mentioned before the function");
                    System.out.println("1. show profile");
                    System.out.println("2. enroll in course");
                    System.out.println("3. View assignments");
                    option = sc.nextInt();
                    switch(option){
                        case 1:
                            student.show();
                            break;
                        case 2:
                            student.enroll_in_course(manager);
                            break;
                        case 3:
                            int sub_option;
                            System.out.println("Do you want to see all assignments or Do you want to see assignments course wise");
                            System.out.println("1. all assignment");
                            System.out.println("2. Course wise");
                            sub_option = sc.nextInt();
//                            switch (sub_option){
//                                case 1:
//                            }
                    }
                }
            case "instructor":
                Instructor instructor = (Instructor) user;
                while (true) {
                    System.out.println("press number mentioned before the function");
                    System.out.println("1. show profile");
                    System.out.println("2. manage Course");
                    System.out.println("3. view Student ");
                    int option = sc.nextInt();
                    switch(option){
                        case 1:
                            instructor.show();
                            break;
                        case 2:
                            System.out.println("1. add course");
                            System.out.println("2. view course");
                            int sub_option = sc.nextInt();
                            switch (sub_option){
                                case 1:
                                    System.out.println("What is the name of the course?");
                                    String course_name = sc.nextLine();
                                    System.out.println(("What is the due date of course 'yyyy mm dd'"));
                                    int year = sc.nextInt();
                                    int month = sc.nextInt();
                                    int day = sc.nextInt();
                                    LocalDate due = LocalDate.of(year,month,day);
                                    instructor.create_course(course_name,due);
                                    break;

                                case 2:
                                    instructor.view_Course();
                                    break;
                            }
                    }
                }
        }

    }
}
