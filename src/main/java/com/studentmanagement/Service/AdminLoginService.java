package com.studentmanagement.Service;



import com.studentmanagement.Model.Admin;
import com.studentmanagement.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {

    @Autowired
    private AdminRepository repo;

    public boolean login(String username, String password) {
        Admin admin = repo.findByUsername(username);
        if(admin == null) return false;
        return admin.getPassword().equals(password);
    }

}
