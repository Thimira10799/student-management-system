package com.studentmanagement.Repository;
import com.studentmanagement.Model.StudentUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentUserRepository extends JpaRepository<StudentUser, Integer> {
    StudentUser findByEmail(String email);
}

