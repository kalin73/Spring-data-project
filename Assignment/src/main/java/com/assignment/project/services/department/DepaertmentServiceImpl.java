package com.assignment.project.services.department;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.project.models.Department;
import com.assignment.project.models.Employee;
import com.assignment.project.repositories.DepartmentRepository;
import com.assignment.project.services.employee.EmployeeService;

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
