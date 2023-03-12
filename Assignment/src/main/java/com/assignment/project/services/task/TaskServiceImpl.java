package com.assignment.project.services.task;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.project.entities.Task;
import com.assignment.project.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	private TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public void createTask(Task task) {
		this.taskRepository.save(task);

	}

	@Override
	public void removeTaskById(Long id) {
		this.taskRepository.deleteById(id);

	}

	@Override
	public List<Task> getAllTasks() {
		return this.taskRepository.findAll();

	}

	@Override
	public void removeAssignee(Long id) {
		List<Task> tasks = this.taskRepository.findByAssigneeId(id);

		tasks.forEach(task -> task.setAssignee(null));

		tasks.forEach(task -> this.taskRepository.save(task));
	}

	@Override
	public Task getTaskById(Long id) {
		return this.taskRepository.findById(id).get();
	}

	@Override
	public void updateTask(Task task) {
		this.taskRepository.save(task);

	}

}
