package com.studentmanagement.Model;



import jakarta.persistence.*;

@Entity
@Table(name = "student_users")
public class StudentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private Integer studentId;

    public StudentUser() {}

    public StudentUser(String email, String password, Integer studentId) {
        this.email = email;
        this.password = password;
        this.studentId = studentId;
    }

    // getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
}

