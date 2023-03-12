package com.example.demo.services.department;

import java.util.List;

import com.example.demo.entities.Department;

public interface DepartmentService {
	void createDepartment(Department department);

	Department getDepartmentById(Long id);

	void removeDepartmentById(Long id);

	void updateDepartment(Department department);

	List<Department> getAllDepartments();
}
