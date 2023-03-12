package com.assignment.project.commands;

import static com.assignment.project.constants.ConstantMessages.*;

import com.assignment.project.models.Employee;
import com.assignment.project.services.department.DepartmentService;
import com.assignment.project.services.employee.EmployeeService;
import com.assignment.project.services.task.TaskService;

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

			Employee employee = employeeService.getEmployeeById(id);
			employee.getDepartment().removeEmployee(employee);

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
