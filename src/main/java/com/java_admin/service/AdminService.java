package com.java_admin.service;

import com.java_admin.entity.Admin;
import com.java_admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public List<Admin> getAllAdmins() {
        return (List<Admin>) adminRepository.findAll();
    }

    public boolean login(String admin_email, String admin_password) {
        // Call the AdminRepository to find the Admin by adminEmail
        Admin admin = adminRepository.findByAdminEmail(admin_email);
        // If the Admin is found, check if the adminPassword matches
        if (admin != null) {
            return admin.getAdmin_password().equals(admin_password);
        } else {
            return false;
        }

    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Object> getAdminById(Long id) {
        return Optional.of(adminRepository.findById(id));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    // Your service methods here


}