package com.postgresBSL.employeemanagement.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postgresBSL.employeemanagement.entity.Course;
import com.postgresBSL.employeemanagement.impl.CourseService;
import com.postgresBSL.employeemanagement.pojos.CourseRequest;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody CourseRequest course) {
		return courseService.addCoursewithContents(course);
	}
}
