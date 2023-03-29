package MVC.basic.controller;

import MVC.basic.model.Student;
import MVC.basic.view.StudentView;

public class StudentController {
    private Student model;
    private StudentView view;
    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }
    public void updateView(){
        view.printStudent(model);
    }
    public void updateId(Long id){
        model.setId(id);
    }
    public Long getId(){
        return model.getId();
    }
    public void updateFirstName(String firstname){
        model.setFirstName(firstname);
    }
    public String getFirstName(){
        return model.getFirstName();
    }
    public void updateLastName(String lastname){
        model.setLastName(lastname);
    }
    public String getLastName(){
        return model.getLastName();
    }
    public void updateEmail(String email){
        model.setEmail(email);
    }
    public String getEmail(){
        return model.getEmail();
    }
}
