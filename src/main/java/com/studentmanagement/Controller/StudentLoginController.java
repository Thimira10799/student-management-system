package com.studentmanagement.Controller;
import com.studentmanagement.Service.StudentLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentLoginController {

    @Autowired
    private StudentLoginService loginService;

    @PostMapping("/login")
    public Integer login(@RequestParam String email, @RequestParam String password) {
        return loginService.login(email, password);
    }
}
