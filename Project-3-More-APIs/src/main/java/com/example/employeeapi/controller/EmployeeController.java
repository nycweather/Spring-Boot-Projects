package com.example.employeeapi.controller;

import com.example.employeeapi.models.Employee;
import com.example.employeeapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @PostMapping("")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
