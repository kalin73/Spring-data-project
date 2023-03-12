package com.example.demo.commands;

import java.util.Scanner;

import com.example.demo.services.department.DepartmentService;
import com.example.demo.services.employee.EmployeeService;
import com.example.demo.services.task.TaskService;

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
