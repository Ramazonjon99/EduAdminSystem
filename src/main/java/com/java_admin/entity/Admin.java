package com.java_admin.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


@Entity
@Table(name = "admin") // Make sure the table name matches the actual table name in the database
public class Admin {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name = "admin_password")
    private String adminPassword;


    public String getAdmin_email() {
        return adminEmail;
    }

    public String getAdmin_password() {
        return adminPassword;
    }

    public void setAdminId(Long id) {
        this.adminId = id;
    }
}