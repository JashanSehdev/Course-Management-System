package Controllers;

import java.time.LocalDate;

public class Instructor extends User{
    public Course_Manager my_manager;
    public Instructor(String username, String password){
        super(username, password, "instructor");
    }

    public Instructor(String username, String password, Course_Manager manager){
        super(username, password, "instructor");
        this.my_manager = manager;
    }

    public void create_course(String name, LocalDate due ){
        Course newCourse = new Concrete_Course(name, this.username);
        my_manager.create_course(newCourse);
    }

    // view course
    public void view_Course(){
        //null case
        if(my_manager.allCourse.isEmpty()){
            System.out.println("No course created");
            return;
        }
        for(Course course : my_manager.allCourse){
            if(course.course_instructor.equalsIgnoreCase(username)){
                System.out.println("\t"+course.course_name+" by "+course.course_instructor);
            }
        }
    }

    // show profile
    public void show(){
        System.out.println("name: "+ username);
        System.out.println("role: "+ role);
        System.out.println("Your courses: ");
        if (my_manager.allCourse.isEmpty()){
            System.out.println("\tNo course added!?");
            return;
        }
        for(Course course : my_manager.allCourse){
            System.out.println("\t"+course.course_name);
        }
    }

    void remove_course(String name){
        my_manager.removeCourse(my_manager.getCourseByName(name));
    }

    public void addAssignment(String courseName, String assignmentName, LocalDate due){
        Course course = my_manager.getCourseByName(courseName);
        if(course!=null){
            course.addAssignment(assignmentName,due);
        }
        else{
            System.out.println("Course doesn't exist");
        }
    }

}
