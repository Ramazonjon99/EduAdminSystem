package com.java_admin.service;

import com.java_admin.entity.Student;
import com.java_admin.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        // Check if the student with the given id exists in the database
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + id));

        // Update the existing student with the new information
        existingStudent.setStudentName(updatedStudent.getStudentName());
        existingStudent.setStudentEmail(updatedStudent.getStudentEmail());
        existingStudent.setMajor(updatedStudent.getMajor()); // Assuming you have a method to fetch majors from the database

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        // Check if the student with the given id exists in the database
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + id));

        studentRepository.delete(existingStudent);
    }

    // Other methods for additional functionality related to student management
}