package com.example.demo.commands;

import static com.example.demo.constants.ConstantMessages.*;

import com.example.demo.entities.Department;
import com.example.demo.services.department.DepartmentService;
import com.example.demo.services.employee.EmployeeService;
import com.example.demo.services.task.TaskService;

public class StatsCommand extends Command {

	public StatsCommand() {

	}

	public StatsCommand(EmployeeService employeeService, TaskService taskService, DepartmentService departmentService) {
		super(employeeService, taskService, departmentService);

	}

	@Override
	public void execute() {
		System.out.println(CHOOSE_STATISTIC);
		System.out.println(STATS_COMMAND1);
		System.out.println(STATS_COMMAND2);
		System.out.println(STATS_COMMAND3);

		int commandNumber = Integer.parseInt(sc.nextLine());

		switch (commandNumber) {
		case 1:
			employeeService.findAllOrderByCompletedTasksDescLimit5().forEach(emp -> System.out.println(emp));
			break;

		case 2:
			System.out.println("Department ID: ");
			long depId = Long.parseLong(sc.nextLine());
			Department department = departmentService.getDepartmentById(depId);
			long avgSalary = this.employeeService.getAvgSalaryByDepartment(department);

			System.out.println(String.format(AVERAGE_SALARY_RESULT_FORMAT, department.getName(), avgSalary));
			break;

		case 3:
			System.out.println("Department ID: ");
			depId = Long.parseLong(sc.nextLine());
			department = departmentService.getDepartmentById(depId);

			int count = this.employeeService.getCountEmployeesByDepartment(department);

			System.out.println(String.format(COUNT_OF_EMPLOYEES_RESULT_FORMAT, count, department.getName()));
			break;

		default:
			break;
		}

	}

}
