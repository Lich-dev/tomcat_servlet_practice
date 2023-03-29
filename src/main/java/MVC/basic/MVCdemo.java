package MVC.basic;

import MVC.basic.controller.StudentController;
import MVC.basic.model.Student;
import MVC.basic.view.StudentView;

import java.util.Random;

public class MVCdemo {
    public static void main(String[] args) {
        Student student = loadStudentFromDatabase(new Random().nextLong());
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student,view);
        controller.updateView();
    }
    private static Student loadStudentFromDatabase(Long id){
        return new Student("Tom","Hanks","email",id);
    }
}
