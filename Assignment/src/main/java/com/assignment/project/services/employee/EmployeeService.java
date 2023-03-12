package com.assignment.project.services.employee;

import java.util.List;

import com.assignment.project.entities.Department;
import com.assignment.project.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	void createEmployee(Employee employee);

	void removeEmployeeById(Long id);

	Employee getEmployeeById(Long id);
	
	Employee getEmployeeByDepartmentId(Long id);

	void updateEmployee(Employee employee);

	List<Employee> findAllOrderByCompletedTasksDescLimit5();
	
	Long getAvgSalaryByDepartment(Department dep);
	
	Integer getCountEmployeesByDepartment(Department dep);

}
