package com.postgresBSL.employeemanagement.controlller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.postgresBSL.employeemanagement.entity.EmployeeEntity;
import com.postgresBSL.employeemanagement.impl.EmployeeServiceImp;
import com.postgresBSL.employeemanagement.service.EmploeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmploeeService employeeService;
	
	@Autowired
	EmployeeServiceImp employeeServiceImp;
	
//	public EmployeeController(EmploeeService empService) {
//		
//		this.employeeService =empService;
//	}
	
	
	@GetMapping("/getEmp")
	public List<EmployeeEntity> findAllEmployee(){
		return employeeService.findAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Optional<EmployeeEntity> findById(@PathVariable("id") Long id) {
		return employeeService.findById(id);
	}
	
	@GetMapping("/findByName")
	public Optional<EmployeeEntity> findByName(@RequestParam String name) {
		return employeeService.findByName(name);
	}
	
	@GetMapping("/employeeByIds")
	public List<EmployeeEntity> findByIds(@RequestBody Iterable<Long> ids) {
		return employeeServiceImp.findAllByIds(ids);
	}
	
	@GetMapping("/save")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return  employeeService.saveEmployee(employeeEntity) ;
	}
	
	@PutMapping("/update")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return  employeeService.updateEmployee(employeeEntity) ;
	}
	
	@DeleteMapping("deleteById/{id}")
	public void delete(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
	}
	
	@PostMapping("/addAllEmployee")
	public List<EmployeeEntity> addAllEmployee(@RequestBody List<EmployeeEntity> employee){
		
		return employeeService.addAllEmployee(employee);
	}
	
	@GetMapping("/findByDeptAndAge")
	public List<EmployeeEntity> findByDeptAndAge(@RequestParam String department, @RequestParam int age ){
		return employeeService.findByDeptAndAge( department, age);
	}
	
	@GetMapping("/findByEmpNameStartWith")
	public List<EmployeeEntity> findByDeptAndAge(@RequestParam String empName ){
		return employeeService.findByEmployeeNameStartWith( empName);
	}

}
