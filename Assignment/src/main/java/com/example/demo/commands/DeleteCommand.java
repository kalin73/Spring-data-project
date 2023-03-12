package com.example.demo.commands;

import static com.example.demo.constants.ConstantMessages.*;

import com.example.demo.services.department.DepartmentService;
import com.example.demo.services.employee.EmployeeService;
import com.example.demo.services.task.TaskService;

public class DeleteCommand extends Command {

	public DeleteCommand(EmployeeService employeeService, TaskService taskService,
			DepartmentService departmentService) {
		super(employeeService, taskService, departmentService);
	}

	public DeleteCommand() {
	}

	@Override
	public void execute() {
		System.out.println(CHOOSE_ENTITY_TYPE_MESSAGE);
		String entityType = sc.nextLine().toLowerCase();

		System.out.println(String.format(CHOOSE_ENTITY_ID_DELETE, entityType));
		long id = Long.parseLong(sc.nextLine());

		switch (entityType) {
		case "employee":	
			this.taskService.removeAssignee(id);
			this.employeeService.removeEmployeeById(id);
			
			System.out.println(String.format(SUCCESSFUL_DELETION_MESSAGE, entityType, id));
			break;

		case "task":
			this.taskService.removeTaskById(id);
			System.out.println(String.format(SUCCESSFUL_DELETION_MESSAGE, entityType, id));
			break;

		case "department":
			this.departmentService.removeDepartmentById(id);
			System.out.println(String.format(SUCCESSFUL_DELETION_MESSAGE, entityType, id));
			break;

		default:
			System.out.println(INVALID_ENTITY_MESSAGE);
			break;
		}

	}

}
