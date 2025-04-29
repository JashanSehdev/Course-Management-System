package Controllers;

public class Concrete_Course extends Course{
    public Concrete_Course(String name,String instructor){
        super(name,instructor);
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
