package com.assignment.project.models;

import static com.assignment.project.constants.ConstantMessages.*;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@ManyToOne
	private Employee assignee;

	@Column(name = "due_date")
	private LocalDate dueDate;

	public Task() {

	}

	public Task(String title, String description, Employee assignee, LocalDate dueDate) {
		this.title = title;
		this.description = description;
		this.assignee = assignee;
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null || title.isBlank()) {
			throw new NullPointerException("Title can't be empty!");
		}
		this.title = title;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getAssignee() {
		return assignee;
	}

	public void setAssignee(Employee assignee) {
		this.assignee = assignee;
	}

	@Override
	public String toString() {
		return String.format(TASK_STRING_FORMAT, this.id, this.title, this.description, this.assignee.getId(),
				this.dueDate.toString());
	}
}
