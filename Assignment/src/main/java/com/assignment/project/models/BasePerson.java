package com.assignment.project.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePerson extends BaseEntity {

	@Column
	protected String name;

	@Column(name = "birth_date")
	protected LocalDate birthDate;

	protected BasePerson() {

	}

	protected BasePerson(String name, LocalDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isBlank()) {
			throw new NullPointerException("Name can't be empty!");
		}
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
