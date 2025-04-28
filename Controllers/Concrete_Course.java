package Controllers;

public class Concrete_Course extends Course{
    Concrete_Course(String name){
        super(name);
    }

    @Override
    void set_name(String name) {
        this.course_name = name;
    }

    @Override
    void set_grade(String grade) {
        this.course_grade = grade;
    }

}
