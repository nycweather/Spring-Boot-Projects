package com.example.employeeapi.repository;

import com.example.employeeapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public class EmployeeRepository extends JpaRepository<Employee, Long> {

}
