package com.postgresBSL.employeemanagement.service;

import com.postgresBSL.employeemanagement.entity.User;

public interface UserService {

	User finadByUsername(String username);
	
	User addUser(User user);
}
