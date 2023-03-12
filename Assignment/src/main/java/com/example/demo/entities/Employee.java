package com.example.demo.entities;

import static com.example.demo.constants.ConstantMessages.*;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends BasePerson {

	@Column
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column
	private int salary;

	@Column(name = "completed_tasks")
	private int completedTasks;

	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;

	public Employee() {

	}

	public Employee(String name, String email, String phoneNumber, LocalDate birthDate, int salary,
			Department department) {
		super(name, birthDate);
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.department = department;

	}

	public int getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return String.format(EMPLOYEE_STRING_FORMAT, this.id, this.name, this.birthDate.toString(), this.email,
				this.phoneNumber, this.completedTasks, this.department.getId());
	}
}
