package com.example.demo.services.task;

import java.util.List;

import com.example.demo.entities.Task;

public interface TaskService {
	void createTask(Task task);

	void removeTaskById(Long id);

	List<Task> getAllTasks();
	
	void removeAssignee(Long id);
	
	Task getTaskById(Long id);
	
	void updateTask(Task task);
}
