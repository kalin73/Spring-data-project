package com.assignment.project.commands;

import static com.assignment.project.constants.ConstantMessages.*;

import java.time.LocalDate;

import com.assignment.project.models.Department;
import com.assignment.project.models.Employee;
import com.assignment.project.models.Task;
import com.assignment.project.services.department.DepartmentService;
import com.assignment.project.services.employee.EmployeeService;
import com.assignment.project.services.task.TaskService;

public class CreateCommand extends Command {
	private Employee employee;
	private Task task;

	public CreateCommand() {

	}

	public CreateCommand(EmployeeService employeeService, TaskService taskService,
			DepartmentService departmentService) {
		super(employeeService, taskService, departmentService);
	}

	@Override
	public void execute() {
		System.out.println(CHOOSE_ENTITY_TYPE_MESSAGE);
		String entityType = sc.nextLine();

		switch (entityType) {
		case "employee":
			System.out.println(SET_EMPLOYEE_PARAMETERS_MESSAGE);
			String[] employeeInfo = sc.nextLine().split(",");
			String[] birthDate = employeeInfo[3].trim().split("\\.");
			int salary = Integer.parseInt(employeeInfo[4].trim());

			int year = Integer.parseInt(birthDate[0].trim());
			int month = Integer.parseInt(birthDate[1].trim());
			int day = Integer.parseInt(birthDate[2].trim());

			Long depID = Long.parseLong(employeeInfo[5].trim());
			Department department = departmentService.getDepartmentById(depID);

			employee = new Employee(employeeInfo[0].trim(), employeeInfo[1].trim(), employeeInfo[2].trim(),
					LocalDate.of(year, month, day), salary, department);
			department.addEmployee(employee);

			employeeService.createEmployee(employee);
			break;

		case "task":
			System.out.println(SET_TASK_PARAMETERS_MESSAGE);
			String[] taskInfo = sc.nextLine().split(",");
			Long assigneeId = Long.parseLong(taskInfo[2].trim());
			String[] dueDate = taskInfo[3].trim().split("\\.");

			year = Integer.parseInt(dueDate[0].trim());
			month = Integer.parseInt(dueDate[1].trim());
			day = Integer.parseInt(dueDate[2].trim());

			Employee assignee = employeeService.getEmployeeById(assigneeId);

			task = new Task(taskInfo[0].trim(), taskInfo[1].trim(), assignee, LocalDate.of(year, month, month));
			taskService.createTask(task);

			break;

		case "department":
			System.out.println(SET_DEPARTMENT_NAME);
			String depName = sc.nextLine().trim();

			department = new Department(depName);

			departmentService.createDepartment(department);

			break;

		default:
			System.out.println(INVALID_ENTITY_MESSAGE);
			break;
		}

	}

}
