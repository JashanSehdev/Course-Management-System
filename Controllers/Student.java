package Controllers;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.*;

public class Student extends User{
    private List <Course> enrolled;
    public Course_Manager my_manager; // try
    public Student(String username, String password,Course_Manager manager) {
        super(username, password, "student");
        enrolled = new ArrayList<>();
        my_manager = manager;
    }

    //show profile
    public void show(){
        System.out.println("name: "+ username);
        System.out.println("role: "+ role);
        System.out.println("Your courses: ");
        for(Course course : get_enrolled_course()){
            System.out.println("\t"+course.course_name+", Instructor "+ course.course_instructor);
        }
    }

    public void enroll_in_course(Course_Manager courses){
        // corner case if no course available
        if(courses.allCourse.isEmpty()){
            System.out.println("No course available");
            return;
        }

        for(Course course : courses.allCourse){
            System.out.println("\t"+course.course_name + " by "+course.course_instructor);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Select your Course");
        String find = sc.nextLine();

        for(Course course : courses.allCourse){
            if(course.course_name.equalsIgnoreCase(find)){
                enrolled.add(course);
                System.out.println("Course enrolled, name: "+course.course_name+" at "+ LocalDateTime.now());
                return;
            }
        }
        System.out.println("Failed to enroll kindly enroll again");
        sc.close();

    }

    List<Course> get_enrolled_course(){
        return enrolled;
    }

    public void view_assignment(){
        for(Course course : enrolled){
            view_assignment(course);
        }
    }
    public void view_assignment(Course course){
        System.out.println("your assignment for "+ course.course_name);
        for(Course.Assignment assign : course.myAssignment){
            System.out.println(assign.assign_name+" with due date "+assign.assign_due+" status: "+assign.assign_status);
        }
    }

    public void submission(Course course, String assignment){
        course.getAssignmentByName(assignment).assignment_submission();
    }

}
