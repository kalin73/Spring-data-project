package com.example.demo.services.employee;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;


	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}

	@Override
	public void createEmployee(Employee employee) {
		this.employeeRepository.save(employee);

	}

	@Override
	public void removeEmployeeById(Long id) {
		this.employeeRepository.deleteById(id);

	}

	@Override
	public Employee getEmployeeById(Long id) {
		return this.employeeRepository.getAllById(id);

	}

	@Override
	public void updateEmployee(Employee employee) {
		this.employeeRepository.save(employee);

	}

	@Override
	public List<Employee> findAllOrderByCompletedTasksDescLimit5() {
		return this.employeeRepository.findAllOrderByCompletedTasksDescLimit5();
	}

	@Override
	public Employee getEmployeeByDepartmentId(Long id) {
		return this.employeeRepository.getEmployeeByDepartmentId(id);
	}

	@Override
	public Long getAvgSalaryByDepartment(Department dep) {
		
		return this.employeeRepository.getAvgSalaryByDepartment(dep);
	}

	@Override
	public Integer getCountEmployeesByDepartment(Department dep) {
		return employeeRepository.getCountEmployeesByDepartment(dep);
	}

}
