package com.boa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.app.constant.RoleConstant;
import com.boa.app.entity.Course;
import com.boa.app.entity.Student;
import com.boa.app.repo.CourseRepo;
import com.boa.app.repo.StudentRepo;

@Service
public class CRSStudentService {

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	public List<Course> fetchCatalog(){
		return courseRepo.findAll();
	}
	
	public String registerStudent(Student student) {
		if (student != null && !student.getRegistration().getCourses().isEmpty()) {
			student.getRegistration().setStatus(RoleConstant.REG_PENDING);
			studentRepo.save(student);
			return "registration completed ... waiting for approval... !";
		}
		else
			return "no data received .... !";
	}
}
