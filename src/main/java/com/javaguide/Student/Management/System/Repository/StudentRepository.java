package com.javaguide.Student.Management.System.Repository;

import com.javaguide.Student.Management.System.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student,Long> {


}
