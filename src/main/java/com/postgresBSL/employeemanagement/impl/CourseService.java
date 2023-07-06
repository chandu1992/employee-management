package com.postgresBSL.employeemanagement.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresBSL.employeemanagement.entity.Course;
import com.postgresBSL.employeemanagement.entity.CourseContents;
import com.postgresBSL.employeemanagement.pojos.CourseRequest;
import com.postgresBSL.employeemanagement.repository.CoureseContentRepository;
import com.postgresBSL.employeemanagement.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CoureseContentRepository coureseContentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public CourseService() {
		
	}
	
	public Course addCoursewithContents(CourseRequest courseReq) {
		
		Course course =new Course();
		
		course.setId(courseReq.id);
		course.setCoursename(courseReq.coursename);
		course.setCoureseContents(courseReq.courseContents
				.stream()
				.map(courseContents -> {
					CourseContents ccontents =courseContents;
					if(ccontents.getId()>0) {
						ccontents = coureseContentRepository.findById(ccontents.getId());
					}
					ccontents.addCourese(course);
					return ccontents;
				})
				.collect(Collectors.toSet())
				);
		
		
		return courseRepository.save(course);
	}
}
