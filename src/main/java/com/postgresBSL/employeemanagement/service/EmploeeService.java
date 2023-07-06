package com.postgresBSL.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.postgresBSL.employeemanagement.entity.EmployeeEntity;

public interface EmploeeService {

	
	List<EmployeeEntity> findAllEmployee();
	
	Optional<EmployeeEntity> findById(Long id);
	
	EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
	
	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
	
	void deleteEmployee(Long id);

	List<EmployeeEntity> addAllEmployee(List<EmployeeEntity> employee);
	
	Optional<EmployeeEntity> findByName(String name);

	List<EmployeeEntity> findAllByIds(Iterable<Long> ids);

	List<EmployeeEntity> findByDeptAndAge(String department, int age);
	
	List<EmployeeEntity> findByEmployeeNameStartWith(String name);
}
