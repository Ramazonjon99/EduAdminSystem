package com.java_admin.controller;

import com.java_admin.entity.Admin;
import com.java_admin.entity.Department;
import com.java_admin.entity.Major;
import com.java_admin.entity.Student;
import com.java_admin.service.AdminService;
import com.java_admin.service.DepartmentService;
import com.java_admin.service.MajorService;
import com.java_admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;
    private final DepartmentService departmentService;
    private final MajorService majorService;
    private final StudentService studentService;

    @Autowired
    public AdminController(AdminService adminService, DepartmentService departmentService,
                           MajorService majorService,StudentService studentService) {
        this.adminService = adminService;
        this.departmentService = departmentService;
        this.majorService = majorService;
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Admin>> listAdmins() {
        // Method implementation
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin loginRequest) {
        String admin_email = loginRequest.getAdmin_email();
        String admin_password = loginRequest.getAdmin_password();

        // Call the login method in the AdminService
        boolean loginSuccessful = adminService.login(admin_email, admin_password);

        if (loginSuccessful) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed!");
        }
    }

    // Endpoint to add a new admin
    @PostMapping("/add")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(savedAdmin);
    }

    // Endpoint to update an existing admin
    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        if (!adminService.getAdminById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        admin.setAdminId(id);
        Admin updatedAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(updatedAdmin);
    }

    // Endpoint to delete an admin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        if (!adminService.getAdminById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }

    // Endpoint to list all departments
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> listDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    // Endpoint to add a new department
    @PostMapping("/departments/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    // Endpoint to update an existing department
    @PutMapping("/departments/update/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id,
                                                       @RequestBody Department department) {
        if (!departmentService.getDepartmentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        department.setId(id);
        Department updatedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    // Endpoint to delete a department
    @DeleteMapping("/departments/delete/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        if (!departmentService.getDepartmentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }


    // getting all majors
    @GetMapping("/majors")
    public ResponseEntity<List<Major>> getAllMajors() {
        List<Major> majors = majorService.getAllMajors();
        return ResponseEntity.ok(majors);
    }

    // Implement methods for adding, updating, and deleting majors

    // Example of adding a new major
    @PostMapping("/majors/add")
    public ResponseEntity<Major> addMajor(@RequestBody Major major) {
        Major newMajor = majorService.addMajor(major);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMajor);
    }

    // Example of updating an existing major
    @PutMapping("/majors/update/{id}")
    public ResponseEntity<Major> updateMajor(@PathVariable Long id, @RequestBody Major major) {
        Major updatedMajor = majorService.updateMajor(id, major);
        return ResponseEntity.ok(updatedMajor);
    }

    // Example of deleting a major
    @DeleteMapping("/majors/delete/{id}")
    public ResponseEntity<Void> deleteMajor(@PathVariable Long id) {
        majorService.deleteMajor(id);
        return ResponseEntity.noContent().build();
    }


    // getting all students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/students/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @PutMapping("/students/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
