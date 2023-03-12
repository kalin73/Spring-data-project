package com.assignment.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.project.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
