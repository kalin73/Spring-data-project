package com.example.demo.constants;

public class ConstantMessages {
	public static final String EMPLOYEE_STRING_FORMAT = "ID: %d; Name: %s; Email: %s; Phone number: %s; Birth date: %s; Completed tasks: %d; Department ID: %d.";
	public static final String TASK_STRING_FORMAT = "ID: %d; Title: %s; Description: %s; Assignee ID: %d; Due date: %s.";
	public static final String DEPARTMENT_STRING_FORMAT = "ID: %d; Name: %s.";
	
	public static final String CHOOSE_COMMAND_MESSAGE = "Choose command: create, read, update, delete, stats";
	public static final String CHOOSE_ENTITY_TYPE_MESSAGE = "Choose type of entity: employee, task, department";
	public static final String CHOOSE_ENTITY_ID_DELETE = "Choose %s ID for deleteon";
	public static final String CHOOSE_ENTITY_ID_UPDATE = "Choose %s ID for updating";
	public static final String CHOOSE_FIELDS_UPDTAE = "Choose the fields for update in format: {field:new value, field:new value...}";
	public static final String CHOOSE_STATISTIC = "Choose the number for one of the statistics commands:";

	public static final String READ_COMMAND_INFO = "Read command will display information from all columns for given entity";
	public static final String STATS_COMMAND1 = "1. Show top 5 employees with most completed tasks past month.";
	public static final String STATS_COMMAND2 = "2. Show average salary of the employees for specific department.";
	public static final String STATS_COMMAND3 = "3. Show the number of employees from specific department.";

	public static final String SET_EMPLOYEE_PARAMETERS_MESSAGE = "Set employee parameters in the format: name, birth date(yyyy.m.d), email, phone number, department id";
	public static final String SET_TASK_PARAMETERS_MESSAGE = "Set task parameters in the format: title, description, assignee id, due date(yyyy.m.d)";
	public static final String SET_DEPARTMENT_NAME = "Set department name";

	public static final String EXIT_MESSAGE = "Do you want to execute another task? YES/NO";
	public static final String INVALID_COMMAND_MESSAGE = "Invalid command!";
	public static final String INVALID_ENTITY_MESSAGE = "Invalid entity type!";

	public static final String COMMAD_CLASS_PATH = "com.example.demo.commands.";

	public static final String SUCCESSFUL_DELETION_MESSAGE = "Successfully deleted %s with id: %d%n";
	public static final String SUCCESSFUL_UPDATE_MESSAGE = "Successfully updated %s with id: %d%n";
	
	public static final String AVERAGE_SALARY_RESULT_FORMAT = "Average salary for department %s is %dlv.";
	public static final String COUNT_OF_EMPLOYEES_RESULT_FORMAT = "There are %d employees in department %s";

}
