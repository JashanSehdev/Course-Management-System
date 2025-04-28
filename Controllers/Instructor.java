package Controllers;

import java.time.LocalDate;

public class Instructor extends User{
    private Course_Manager my_manager;
    Instructor(String username, String password){
        super(username, password, "instructor");
    }

    Instructor(String username, String password, Course_Manager manager){
        super(username, password, "instructor");
        this.my_manager = manager;
    }

    void create_course(String name, LocalDate due ){
        Course newCourse = new Concrete_Course(name);
        my_manager.create_course(newCourse);
    }

    void remove_course(String name){
        my_manager.removeCourse(my_manager.getCourseByName(name));
    }

    void addAssignment(String courseName, String assignmentName, LocalDate due){
        Course course = my_manager.getCourseByName(courseName);
        if(course!=null){
            course.addAssignment(assignmentName,due);
        }
        else{
            System.out.println("Course doesn't exist");
        }
    }
}
