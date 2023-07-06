package com.postgresBSL.employeemanagement.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.postgresBSL.employeemanagement.entity.User;

public class UserDetailsPrincipal implements UserDetails{

	private User user;
	
	public UserDetailsPrincipal(User user) {
		this.user =user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().getRolename()));
		return roles;
	}
	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		List<GrantedAuthority> roles = new ArrayList<>();
//		
//		user.getRoles().forEach(role->{
//			roles.add(new SimpleGrantedAuthority("ROLE_"+role.getRolename()));
//		});
//		
//		return roles;
//	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
