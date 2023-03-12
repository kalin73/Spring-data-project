package com.assignment.project.commands;

import java.util.Scanner;

import com.assignment.project.services.department.DepartmentService;
import com.assignment.project.services.employee.EmployeeService;
import com.assignment.project.services.task.TaskService;

public abstract class Command {
	protected Scanner sc;
	protected EmployeeService employeeService;
	protected TaskService taskService;
	protected DepartmentService departmentService;

	protected Command(EmployeeService employeeService, TaskService taskService, DepartmentService departmentService) {
		this.employeeService = employeeService;
		this.taskService = taskService;
		this.departmentService = departmentService;
		this.sc = new Scanner(System.in);
	}

	protected Command() {
	}

	public abstract void execute();
}
