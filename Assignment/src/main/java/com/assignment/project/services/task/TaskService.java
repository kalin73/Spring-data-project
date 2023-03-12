package com.assignment.project.services.task;

import java.util.List;

import com.assignment.project.models.Task;

public interface TaskService {
	void createTask(Task task);

	void removeTaskById(Long id);

	List<Task> getAllTasks();
	
	void removeAssignee(Long id);
	
	Task getTaskById(Long id);
	
	void updateTask(Task task);
}
