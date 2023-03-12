package com.assignment.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.project.entities.Department;
import com.assignment.project.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee getAllById(Long id);

	@Query("SELECT e FROM Employee e ORDER BY e.completedTasks DESC LIMIT 5")
	List<Employee> findAllOrderByCompletedTasksDescLimit5();

	Employee getEmployeeByDepartmentId(Long id);

	@Query("SELECT AVG (e.salary) FROM Employee AS e WHERE e.department = :department")
	Long getAvgSalaryByDepartment(Department department);
	
	@Query("SELECT COUNT(:dep) FROM Employee e")
	Integer getCountEmployeesByDepartment(Department dep);

}
