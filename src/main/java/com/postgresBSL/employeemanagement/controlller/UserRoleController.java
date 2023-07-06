package com.postgresBSL.employeemanagement.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgresBSL.employeemanagement.entity.Role;
import com.postgresBSL.employeemanagement.entity.User;
import com.postgresBSL.employeemanagement.repository.RoleRepository;
import com.postgresBSL.employeemanagement.service.UserService;

@RestController
@RequestMapping("/")
public class UserRoleController {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserService userService;
	
	@GetMapping("admin")
	public String adminHome() {
		return "welcome admin";
	}
	
	@PostMapping("addRole")
	public Role addRole(@RequestBody Role role) {
		return roleRepo.save(role);
	}
	
	@PostMapping("addUser")
	public User addRole(@RequestBody User user) {
		//encode password
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userService.addUser(user);
	}
	
}
