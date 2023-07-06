package com.postgresBSL.employeemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.postgresBSL.employeemanagement.entity.EmployeeEntity;
import com.postgresBSL.employeemanagement.impl.UserServiceImp;
import com.postgresBSL.employeemanagement.service.UserService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@SpringBootApplication
public class EmployeeManagementApplication extends WebSecurityConfigurerAdapter{

	@Autowired
	UserServiceImp userServiceImp;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	
	@Bean
	PasswordEncoder bcryptPassworldEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	this is for in-memory authentication
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		we comment this {noop} encoder by creating above customize encoder
//		auth.inMemoryAuthentication().withUser("user1").password("{noop}user1").roles("USER")
//		.and()
//		.withUser("admin1").password("{noop}admin1").roles("ADMIN");
		
		auth.inMemoryAuthentication().withUser("user1").password(encoder.encode("user1")).roles("USER")
		.and()
		.withUser("admin1").password(encoder.encode("admin1")).roles("ADMIN");
	}
	
	*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(bcryptPassworldEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userServiceImp);
		return daoAuthenticationProvider;
	}
	
	//database authentication
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
		.csrf().disable()      //for the post req that time we need to add this to accesss post req
		.authorizeRequests()
//		.antMatchers("/employee/getEmp").permitAll()
//		.antMatchers("/employee/getEmp").hasAnyRole("ADMIN")
//		.antMatchers("/employee/getEmp").hasAnyRole("USER")
		.antMatchers("/addRole").permitAll()
		.antMatchers("/addUser").permitAll()
		.antMatchers("/*").permitAll()
		.antMatchers("/employee/*").permitAll()
		.antMatchers("/admin").hasAnyRole("ADMIN")
		.anyRequest().authenticated().and().httpBasic();
	}

}
