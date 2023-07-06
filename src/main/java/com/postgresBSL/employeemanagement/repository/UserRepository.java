package com.postgresBSL.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgresBSL.employeemanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
