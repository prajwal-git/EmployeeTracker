package com.one.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.one.model.Employee;

public interface EmployeeRepositoryPage extends PagingAndSortingRepository<Employee, Integer> {
	
	
	//@Query("from Employee order by id")
	//Page<Employee> findByIdSorted(Pageable pageable);

}
