package com.java_admin.repository;


import com.java_admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.adminEmail = ?1")
    Admin findByAdminEmail(String adminEmail);


//
//    Admin findByAdminEmail(String adminEmail);


    // You can add custom query methods here if needed
}
