package com.java_admin.service;

import com.java_admin.entity.Major;
import com.java_admin.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {

    private final MajorRepository majorRepository;

    @Autowired
    public MajorService(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    public List<Major> getAllMajors() {
        return majorRepository.findAll();
    }

    public Major addMajor(Major major) {
        return majorRepository.save(major);
    }

    public Major updateMajor(Long id, Major major) {
        Major majorToUpdate = majorRepository.findById(id).orElse(null);
        if (majorToUpdate == null) {
            return null;
        }
        majorToUpdate.setName(major.getName());
        return majorRepository.save(majorToUpdate);
    }

    public void deleteMajor(Long id) {
        majorRepository.deleteById(id);
    }

    // Implement methods for CRUD operations and other business logic related to majors
}