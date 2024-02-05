package com.javaguide.Student.Management.System.Controller;

import com.javaguide.Student.Management.System.Entity.Student;
import com.javaguide.Student.Management.System.Service.StudentSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model){
        model.addAttribute("student",studentSerivce.getStudentById(id));
        return "edit_student";
    }
   @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
      @ModelAttribute("student") Student student,Model model){

        //get Student from database by Id
       Student existingStudent=studentSerivce.getStudentById(id);
       existingStudent.setId(id);
       existingStudent.setFirstName(student.getFirstName());
       existingStudent.setLastName(student.getLastName());
       existingStudent.setEmail(student.getEmail());

       //Save updated student object
       studentSerivce.updateStudent(existingStudent);
       return "redirect:/students";
   }

   //handler method to handle delete student request
   @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentSerivce.deleteStudentById(id);
        return "redirect:/students";
   }
}
