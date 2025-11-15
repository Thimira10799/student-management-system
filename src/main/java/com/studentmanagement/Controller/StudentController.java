package com.studentmanagement.Controller;

import com.studentmanagement.Model.Student;
import com.studentmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getstudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public  Student getStudent(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/addstudent")
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @PutMapping("/updatestudent/{id}")
    public Student updateStudent(@PathVariable Integer id,@RequestBody Student student){
        return (Student) studentService.updateStudent(id,student);
    }
    @DeleteMapping("/deletestudent/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
    // SEARCH STUDENT BY ID
    @GetMapping("/search")
    public ResponseEntity<Student> searchStudentById(@RequestParam Integer id) {
        return studentService.findStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
