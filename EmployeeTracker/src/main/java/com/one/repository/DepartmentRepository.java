package com.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	

}
