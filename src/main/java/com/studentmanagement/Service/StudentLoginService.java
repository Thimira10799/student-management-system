package com.studentmanagement.Service;
import com.studentmanagement.Model.StudentUser;
import com.studentmanagement.Repository.StudentUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLoginService {

    @Autowired
    private StudentUserRepository repo;

    public Integer login(String email, String password) {
        StudentUser user = repo.findByEmail(email);
        if(user != null && user.getPassword().equals(password)) {
            return user.getStudentId();
        }
        return null;
    }
}

