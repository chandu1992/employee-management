package com.postgresBSL.employeemanagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.postgresBSL.employeemanagement.entity.User;
import com.postgresBSL.employeemanagement.repository.UserRepository;
import com.postgresBSL.employeemanagement.service.UserService;

@Service
public class UserServiceImp implements UserService , UserDetailsService{

	
	@Autowired
	UserRepository userrepo;
	
	@Override
	public User finadByUsername(String username) {
		// TODO Auto-generated method stub
		return userrepo.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userrepo.findByUsername(username);
		UserDetailsPrincipal userdetailsPrincipal = new UserDetailsPrincipal(user);
		return userdetailsPrincipal;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userrepo.save(user);
	}

}
