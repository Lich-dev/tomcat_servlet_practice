package MVC.basic.view;

import MVC.basic.model.Student;

public class StudentView {
    public void printStudent(Student student){
        System.out.println(student.getFirstName());
    }
}
