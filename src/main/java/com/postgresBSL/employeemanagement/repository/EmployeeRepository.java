package com.postgresBSL.employeemanagement.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresBSL.employeemanagement.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

	Optional<EmployeeEntity> findByName(String name);
	
	List<EmployeeEntity> findByDepartmentAndAgeGreaterThanEqual(String department, int age);
	List<EmployeeEntity> findByDepartmentAndAgeGreaterThan(String department, int age);
	List<EmployeeEntity> findByDepartmentAndAgeLessThan(String department, int age);
	
	
	List<EmployeeEntity> findByNameStartingWith(String name);
	List<EmployeeEntity> findByNameContaining(String name);
	List<EmployeeEntity> findByNameEndingWith(String name);
	
	List<EmployeeEntity> findTop5ByAge(int age);
	List<EmployeeEntity> findByAgeBetween(int age);
	List<EmployeeEntity> findByAgeIn(List<Integer> agegroup);
	
	List<EmployeeEntity> findByJoiningDateAfter(Date date);
	List<EmployeeEntity> findByJoiningDateBefor(Date date);
	List<EmployeeEntity> findByJoiningDateBetween(Date startDate, Date endDate);
	List<EmployeeEntity> findByJoiningDateBetweeenAndDepartment(Date startDate, Date endDate, String department);
	
	List<EmployeeEntity> findByLeftoIsNull();
	
	List<EmployeeEntity> findByNameEquals(String empName);
	List<EmployeeEntity> findByNameIsNot(String empName);
	List<EmployeeEntity> findByNameIsNull(String empName);
	List<EmployeeEntity> findByNameIsNotNull(String empName);
	
	List<EmployeeEntity> findByNameOrderByJoiningDateAsc(String empName);
	List<EmployeeEntity> findByNameOrderByJoiningDateDesc(String empName);
	
	List<EmployeeEntity> findByLeftjobTrue();
	List<EmployeeEntity> findByLeftjobFalse();
	List<EmployeeEntity> findByLeftjob(boolean leftjob);
}
