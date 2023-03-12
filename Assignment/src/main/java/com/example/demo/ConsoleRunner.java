package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.core.Controller;
import com.example.demo.services.department.DepartmentService;
import com.example.demo.services.employee.EmployeeService;
import com.example.demo.services.task.TaskService;

@Component
public class ConsoleRunner implements CommandLineRunner {
	private EmployeeService employeeService;
	private TaskService taskService;
	private DepartmentService departmentService;

	public ConsoleRunner(EmployeeService employeeService, TaskService taskService,
			DepartmentService departmentService) {
		this.employeeService = employeeService;
		this.taskService = taskService;
		this.departmentService = departmentService;
	}

	@Override
	public void run(String... args) throws Exception {
		Controller controller = new Controller(employeeService, taskService, departmentService);
		controller.run();

	}

}
