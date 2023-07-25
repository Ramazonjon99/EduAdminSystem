package com.java_admin.repository;

import com.java_admin.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
        // You can add custom query methods here if needed
}

