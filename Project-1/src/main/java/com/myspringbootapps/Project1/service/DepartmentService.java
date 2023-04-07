package com.myspringbootapps.Project1.service;

import com.myspringbootapps.Project1.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
