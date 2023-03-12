package com.example.demo.entities;

import static com.example.demo.constants.ConstantMessages.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
	@Column
	private String name;

	@OneToMany(mappedBy = "department", targetEntity = Employee.class, fetch = FetchType.EAGER)
	private List<Employee> employees;

	public Department() {

	}

	public Department(String name) {
		this.name = name;
		this.employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isBlank()) {
			throw new NullPointerException("Name can't be empty!");
		}
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return String.format(DEPARTMENT_STRING_FORMAT, this.id, this.name);
	}
}
