package com.postgresBSL.employeemanagement.pojos;

import java.util.Set;

import com.postgresBSL.employeemanagement.entity.CourseContents;

public class CourseRequest {

	public int id;
	
	public String coursename;
	
	public Set<CourseContents> courseContents;
}
