package Controllers;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.time.LocalDate;

public abstract class Course{
    String course_name;
    String course_instructor;
    String course_grade;
    List <Assignment> myAssignment;
    Course(String name, String instructor){
        this.course_name = name;
        this.course_instructor = instructor;
        this.myAssignment = new ArrayList<>();
    }
    abstract void set_name(String name);
    abstract void set_grade(String grade);

    void addAssignment(String assignmentName, LocalDate due){
        Assignment assign = new Assignment(assignmentName, due);
        myAssignment.add(assign);
    }

    List<Assignment> getAllAssignments(){
        return myAssignment;
    }

    Assignment getAssignmentByName(String name){
        for(Assignment assign : myAssignment){
            if(assign.assign_name.equalsIgnoreCase(name)) {
                return assign;
            }
        }
        return null;
    }

    void removeAssignment(String Name){
        myAssignment.remove(getAssignmentByName(Name));
    }
    class Assignment{
         String assign_name;
         String assign_grade;
         String assign_status="pending";
         LocalDate assign_date;
         LocalDate assign_due;
         LocalDate assign_submit;

         Assignment(String name,LocalDate due){
             LocalDate date = LocalDate.now();
             this.assign_name=name;
             this.assign_date  = date;
             this.assign_due  = due;
         }
         void set_name (String name){
             this.assign_name = name;
         }
         void set_grade (String grade){
             this.assign_grade = grade;
         };
         void set_Assign_date(LocalDate date){
             assign_date = date;
         };
         void set_due(LocalDate due){
             assign_due = due;
         };

         void set_Assign_submit(){
             assign_submit = LocalDate.now();
         }
         void assignment_submission(){
             assign_status="subitted";
         }
    }

}