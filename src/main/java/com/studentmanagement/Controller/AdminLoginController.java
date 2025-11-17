package com.studentmanagement.Controller;


import com.studentmanagement.Service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminLoginController {

    @Autowired
    private AdminLoginService service;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        boolean success = service.login(username, password);

        return success ? "Success" : "Failed";
    }
}

