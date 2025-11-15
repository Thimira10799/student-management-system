package com.studentmanagement.Service;


import com.studentmanagement.Model.Student;
import com.studentmanagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
    @Override
    public Optional<Student> findStudentById(Integer id) {
        return studentRepository.findById(id);
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Object updateStudent(Integer id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge());
            student.setCourse(updatedStudent.getCourse());
            return studentRepository.save(student);
        }).orElseThrow(()-> new RuntimeException("student not found"));
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

}
