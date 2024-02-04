package com.javaguide.Student.Management.System.Controller;

import com.javaguide.Student.Management.System.Entity.Student;
import com.javaguide.Student.Management.System.Service.StudentSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class StudentController {

    private StudentSerivce studentSerivce;

    public StudentController(StudentSerivce studentSerivce) {
        this.studentSerivce = studentSerivce;
    }

    //Handler method to handle list student and return mode and view
   @GetMapping("/students")
    public String listStudents(Model model){
     model.addAttribute("students",studentSerivce.getAllStudents());
             return "students";
    }

    @GetMapping("/students/new")
    public String createStudetnForm(Model model){

        //create students object to hold student form data
        Student student=new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentSerivce.saveStudent(student);
        return "redirect:/students";

    }
}
