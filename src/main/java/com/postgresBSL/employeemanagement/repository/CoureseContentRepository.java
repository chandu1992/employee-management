package com.postgresBSL.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresBSL.employeemanagement.entity.CourseContents;

@Repository
public interface CoureseContentRepository extends JpaRepository<CourseContents, Integer> {

	public CourseContents findById(int id);
}
