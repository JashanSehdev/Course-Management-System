package Controllers;

import java.util.*;
public class Course_Manager {
    List <Course> allCourse;
    public Course_Manager(){
        allCourse = new ArrayList<>();
    }
    public void create_course(Course course){
        allCourse.add(course);
    }

    public List<Course> get_course(){
        return allCourse;
    }

    public Course getCourseByName(String name){
        for(Course cor : allCourse){
            if(cor.course_name.equalsIgnoreCase(name)){
                return cor;
            }
        }
        return  null;
    }

    public void removeCourse(Course course){
        allCourse.remove(course);
    }


}
