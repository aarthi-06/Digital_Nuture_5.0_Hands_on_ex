package com.employeemanagementsystem.repository;

import com.employeemanagementsystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query methods
    List<Employee> findByName(String name);

    List<Employee> findByEmail(String email);

    List<Employee> findByDepartmentName(String departmentName);

    // @Query method
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> searchByName(@Param("name") String name);

    // Named query
    @Query(name = "Employee.findByEmailNamed")
    List<Employee> findByEmailNamed(@Param("email") String email);

    // Pagination
    Page<Employee> findByNameContaining(String name, Pageable pageable);
}