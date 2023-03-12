package com.example.demo.commands;

import static com.example.demo.constants.ConstantMessages.*;

import java.time.LocalDate;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Task;
import com.example.demo.services.department.DepartmentService;
import com.example.demo.services.employee.EmployeeService;
import com.example.demo.services.task.TaskService;

public class UpdateCommand extends Command {

	public UpdateCommand() {

	}

	public UpdateCommand(EmployeeService employeeService, TaskService taskService,
			DepartmentService departmentService) {
		super(employeeService, taskService, departmentService);
	}

	@Override
	public void execute() {
		System.out.println(CHOOSE_ENTITY_TYPE_MESSAGE);
		String entityType = sc.nextLine().toLowerCase();

		System.out.println(String.format(CHOOSE_ENTITY_ID_UPDATE, entityType));
		long id = Long.parseLong(sc.nextLine());

		switch (entityType) {
		case "employee":
			Employee employeeForUpdating = employeeService.getEmployeeById(id);
			updateEmployee(employeeForUpdating);

			this.employeeService.updateEmployee(employeeForUpdating);
			System.out.println(String.format(SUCCESSFUL_DELETION_MESSAGE, entityType, id));
			break;

		case "task":
			Task taskForUpdating = taskService.getTaskById(id);
			updateTask(taskForUpdating);

			this.taskService.updateTask(taskForUpdating);
			System.out.println(String.format(SUCCESSFUL_DELETION_MESSAGE, entityType, id));
			break;

		case "department":
			Department departmentForUpdating = departmentService.getDepartmentById(id);
			updateDepartment(departmentForUpdating);

			this.departmentService.updateDepartment(departmentForUpdating);
			System.out.println(String.format(SUCCESSFUL_DELETION_MESSAGE, entityType, id));
			break;

		default:
			System.out.println(INVALID_ENTITY_MESSAGE);
			break;
		}

	}

	private void updateEmployee(Employee employee) {
		System.out.println(CHOOSE_FIELDS_UPDTAE);
		String[] fields = sc.nextLine().trim().split(",");

		for (String field : fields) {
			String fieldName = field.split(":")[0].trim();
			String value = field.split(":")[1].trim();

			if ("name".equalsIgnoreCase(fieldName)) {
				employee.setName(value);

			} else if ("email".equalsIgnoreCase(fieldName)) {
				employee.setEmail(value);

			} else if (fieldName.contains("phone")) {
				employee.setPhoneNumber(value);

			} else if ("email".equalsIgnoreCase(fieldName)) {
				employee.setEmail(value);

			} else if ("salary".equalsIgnoreCase(fieldName)) {
				employee.setSalary(Integer.parseInt(value));

			} else if (fieldName.contains("completed")) {
				employee.setCompletedTasks(Integer.parseInt(value));

			} else if ("department".equalsIgnoreCase(fieldName)) {
				long id = Long.parseLong(value);
				Department department = departmentService.getDepartmentById(id);

				employee.setDepartment(department);

			}

		}
	}

	private void updateTask(Task task) {
		System.out.println(CHOOSE_FIELDS_UPDTAE);
		String[] fields = sc.nextLine().trim().split(",");

		for (String field : fields) {
			String fieldName = field.split(":")[0].trim();
			String value = field.split(":")[1].trim();

			if ("title".equalsIgnoreCase(fieldName)) {
				task.setTitle(value);

			} else if ("description".equalsIgnoreCase(fieldName)) {
				task.setDescription(value);

			} else if ("assignee".equalsIgnoreCase(fieldName)) {
				long id = Long.parseLong(value);
				Employee employee = employeeService.getEmployeeById(id);
				task.setAssignee(employee);

			} else if ("due date".equalsIgnoreCase(fieldName)) {
				String[] date = value.trim().split("\\.");

				int year = Integer.parseInt(date[0].trim());
				int month = Integer.parseInt(date[1].trim());
				int day = Integer.parseInt(date[2].trim());

				task.setDueDate(LocalDate.of(year, month, day));

			}

		}
	}

	private void updateDepartment(Department departmentForUpdating) {
		System.out.println("Set name:");
		String newName = sc.nextLine();

		departmentForUpdating.setName(newName);

	}
}
