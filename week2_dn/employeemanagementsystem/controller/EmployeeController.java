package com.employeemanagementsystem.controller;

import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            employee.setName(newEmployee.getName());
            employee.setEmail(newEmployee.getEmail());
            employee.setDepartment(newEmployee.getDepartment());
            return employeeRepository.save(employee);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully";
    }


    @GetMapping("/search/name/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return employeeRepository.searchByName(name);
    }

    @GetMapping("/search/email/{email}")
    public List<Employee> searchByEmailNamed(@PathVariable String email) {
        return employeeRepository.findByEmailNamed(email);
    }

    @GetMapping("/page")
    public Page<Employee> getEmployeesWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }

    @GetMapping("/page/search")
    public Page<Employee> searchEmployeesWithPagination(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findByNameContaining(name, pageable);
    }
}