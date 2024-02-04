package com.javaguide.Student.Management.System.Controller;

import com.javaguide.Student.Management.System.Service.StudentSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
