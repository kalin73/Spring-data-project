package com.example.demo.services.department;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.services.employee.EmployeeService;

@Service
public class DepaertmentServiceImpl implements DepartmentService {
	private DepartmentRepository departmentRepository;
	private EmployeeService employeeService;

	public DepaertmentServiceImpl(DepartmentRepository departmentRepository, EmployeeService employeeService) {
		this.departmentRepository = departmentRepository;
		this.employeeService = employeeService;
	}

	@Override
	public void createDepartment(Department department) {
		this.departmentRepository.save(department);

	}

	@Override
	public Department getDepartmentById(Long id) {
		return this.departmentRepository.findById(id).get();
	}

	@Override
	public void removeDepartmentById(Long id) {
		Employee employee = this.employeeService.getEmployeeByDepartmentId(id);
		employee.setDepartment(null);
		this.employeeService.updateEmployee(employee);
		
		this.departmentRepository.deleteById(id);

	}

	@Override
	public List<Department> getAllDepartments() {
		return this.departmentRepository.findAll();
	}

	@Override
	public void updateDepartment(Department department) {
		this.departmentRepository.save(department);

	}

}