import java.time.LocalDate;
import java.util.*;
import Controllers.*;

public class test {
    public static void main(String[] args) {
        AuthenticationManager authenticate = new AuthenticationManager();
        Course_Manager myCourse = new Course_Manager();

        authenticate.register("jashan","1234","instructor",myCourse);
        User user = authenticate.login("jashan","1234");

        Instructor instructor = (Instructor) user;

        instructor.show();
        LocalDate due = LocalDate.of(2005,05,27);
        instructor.create_course("DSA",due);
        instructor.create_course("Java",due);
        instructor.show();

        authenticate.register("jasmine","1234","student",myCourse);
        user = authenticate.login("jasmine","1234");

        Student student = (Student) user;

        student.show();
        student.enroll_in_course(myCourse);
        student.show();





    }
}
