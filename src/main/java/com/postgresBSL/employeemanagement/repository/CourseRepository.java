package com.postgresBSL.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresBSL.employeemanagement.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	public Course findById(int id);
}
