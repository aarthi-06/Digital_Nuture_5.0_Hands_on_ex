package design_pattern.ex_10;

public class Test {
   

    public static void main(String[] args) {

        Student student = new Student("abc", 101, "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("abc d");
        controller.setStudentGrade("A+");

        controller.updateView();
    }

}
