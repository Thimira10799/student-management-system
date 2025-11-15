package com.studentmanagement.Service;

import com.studentmanagement.Model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();
    Student getStudentById(Integer id);
    Student saveStudent(Student student);
    Object updateStudent(Integer id,Student student);
    void deleteStudent(Integer id);

    Optional<Student> findStudentById(Integer id);
}
