package com.assignment.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByAssigneeId(Long id);
	
	Optional<Task> findById(Long id);
}
