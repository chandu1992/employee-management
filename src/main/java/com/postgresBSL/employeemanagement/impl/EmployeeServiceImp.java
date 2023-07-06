package com.postgresBSL.employeemanagement.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresBSL.employeemanagement.entity.EmployeeEntity;
import com.postgresBSL.employeemanagement.repository.EmployeeRepository;
import com.postgresBSL.employeemanagement.service.EmploeeService;

@Service
public class EmployeeServiceImp implements EmploeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
//	public EmployeeServiceImp(EmployeeRepository emplyeeRepo) {
//		this.empRepo =emplyeeRepo;
//	}
	
	@Override
	public List<EmployeeEntity> findAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Optional<EmployeeEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id);
	}

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return empRepo.save(employeeEntity);
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return empRepo.save(employeeEntity);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		
	}

	@Override
	public List<EmployeeEntity> addAllEmployee(List<EmployeeEntity> employee) {
		// TODO Auto-generated method stub
		return empRepo.saveAll(employee);
	}

	@Override
	public Optional<EmployeeEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return empRepo.findByName(name);
	}

	@Override
	public List<EmployeeEntity> findAllByIds(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return empRepo.findAllById(ids);
	}

	@Override
	public List<EmployeeEntity> findByDeptAndAge(String department, int age) {
		// TODO Auto-generated method stub
		return empRepo.findByDepartmentAndAgeGreaterThanEqual(department, age);
	}

	@Override
	public List<EmployeeEntity> findByEmployeeNameStartWith(String name) {
		// TODO Auto-generated method stub
		return empRepo.findByNameEndingWith(name);
	}
}
