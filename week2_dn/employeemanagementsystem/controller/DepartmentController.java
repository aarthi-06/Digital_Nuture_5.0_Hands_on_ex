package com.employeemanagementsystem.controller;

import com.employeemanagementsystem.entity.Department;
import com.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department newDepartment) {
        Department department = departmentRepository.findById(id).orElse(null);

        if (department != null) {
            department.setName(newDepartment.getName());
            return departmentRepository.save(department);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
        return "Department deleted successfully";
    }
}