package com.javaguide.Student.Management.System.Service;

import com.javaguide.Student.Management.System.Entity.Student;

import java.util.List;

public interface StudentSerivce {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

   Student getStudentById(Long id);
    Student updateStudent(Student student);

    void deleteStudentById(Long id);

}
