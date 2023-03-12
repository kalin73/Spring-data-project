package com.example.demo.commands;

import static com.example.demo.constants.ConstantMessages.*;

import com.example.demo.services.department.DepartmentService;
import com.example.demo.services.employee.EmployeeService;
import com.example.demo.services.task.TaskService;

public class ReadCommand extends Command {

	public ReadCommand(EmployeeService employeeService, TaskService taskService, DepartmentService departmentService) {
		super(employeeService, taskService, departmentService);
	}

	public ReadCommand() {

	}

	@Override
	public void execute() {
		System.out.println(READ_COMMAND_INFO);
		System.out.println(CHOOSE_ENTITY_TYPE_MESSAGE);
		String entityType = sc.nextLine();

		switch (entityType) {
		case "employee":
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));
			break;

		case "task":
			taskService.getAllTasks().forEach(task -> System.out.println(task));
			break;
			
		case "department":
			departmentService.getAllDepartments().forEach(department -> System.out.println(department));
			break;

		default:
			System.out.println("Invalid entity!");
			break;
		}

	}

}
