package com.java_admin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_gender")
    private String studentGender;
    @Column(name = "student_dob")
    private String studentDob;
    @Column(name = "student_phone")
    private String studentPhone;
    @ManyToOne
    @JoinColumn(name = "student_major_id")
    private Major major;
    @ManyToOne
    @JoinColumn(name = "student_class_id")
    private Class studentClassId;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "student_password")
    private String studentPassword;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public Major getMajor() {
        return major;
    }

    public String getName() {
        if (major != null) {
            return major.getName();
        }
        return null; // Or return a default value like "N/A" if major is not set
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Class getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Class studentClassId) {
        this.studentClassId = studentClassId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }


// Other fields, constructors, getters, and setters
}
