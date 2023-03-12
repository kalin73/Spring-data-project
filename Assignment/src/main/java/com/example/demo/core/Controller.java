package com.example.demo.core;

import com.example.demo.commands.Command;
import com.example.demo.services.department.DepartmentService;
import com.example.demo.services.employee.EmployeeService;
import com.example.demo.services.task.TaskService;
import static com.example.demo.constants.ConstantMessages.*;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Controller {
	private EmployeeService employeeService;
	private TaskService taskService;
	private DepartmentService departmentService;
	private Scanner sc;

	public Controller(EmployeeService employeeService, TaskService taskService, DepartmentService departmentService) {
		this.employeeService = employeeService;
		this.taskService = taskService;
		this.departmentService = departmentService;
		this.sc = new Scanner(System.in);
	}

	public void run() {
		while (true) {
			try {
				System.out.println(CHOOSE_COMMAND_MESSAGE);
				String command = sc.nextLine().toLowerCase().trim();

				Class<? extends Command> clazz = getCommandClass(command);
				Constructor<? extends Command> constructor = clazz.getDeclaredConstructor(EmployeeService.class,
						TaskService.class, DepartmentService.class);

				constructor.newInstance(employeeService, taskService, departmentService).execute();

			} catch (ClassNotFoundException e) {
				System.out.println(INVALID_COMMAND_MESSAGE);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println(EXIT_MESSAGE);
			String answer = sc.nextLine();

			if ("no".equalsIgnoreCase(answer)) {
				break;
			}

		}
	}

	private Class<? extends Command> getCommandClass(String entityType) throws ClassNotFoundException {
		String className = entityType.substring(0, 1).toUpperCase() + entityType.substring(1, entityType.length())
				+ "Command";

		Class<? extends Command> clazz = Class.forName(COMMAD_CLASS_PATH + className).asSubclass(Command.class);
		return clazz;
	}
}
