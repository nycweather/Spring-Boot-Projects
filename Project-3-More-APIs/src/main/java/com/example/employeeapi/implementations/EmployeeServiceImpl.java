package com.example.employeeapi.implementations;

import com.example.employeeapi.exceptions.ResourceNotFoundException;
import com.example.employeeapi.models.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import com.example.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employeeToUpdate = employeeOptional.get();
            employeeToUpdate.setFirstName(employee.getFirstName());
            employeeToUpdate.setLastName(employee.getLastName());
            employeeToUpdate.setEmail(employee.getEmail());
            return employeeRepository.save(employeeToUpdate);
        } else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
        } else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
    }
}
