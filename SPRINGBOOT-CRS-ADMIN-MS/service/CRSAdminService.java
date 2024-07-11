package com.boa.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.app.constant.RoleConstant;
import com.boa.app.entity.Admin;
import com.boa.app.entity.Course;
import com.boa.app.entity.Professor;
import com.boa.app.entity.Registration;
import com.boa.app.repo.AdminRepo;
import com.boa.app.repo.CourseRepo;
import com.boa.app.repo.ProfessorRepo;
import com.boa.app.repo.RegistrationRepo;

import io.micrometer.common.util.StringUtils;

@Service
public class CRSAdminService {

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private ProfessorRepo professorRepo;
	
	@Autowired
	private RegistrationRepo registrationRepo;
	
	
	public String addAdminService(Admin admin) {
		if (admin != null) {
			adminRepo.save(admin);
			return "admin added succesfully .... !";
		}
		else 
			return "no data present .... !";
	}
	

	public String addCourseService(Course course) {

		if (course != null && StringUtils.isNotBlank(course.getCourseName())) {
			Course byCourseName = courseRepo.findByCourseName(course.getCourseName());
			if (byCourseName != null)
				return "course already present .... !";
			else {
				courseRepo.save(course);
				return "course added successfully .... !";
			}

		} else
			return "no data received ...... !";
	}
	
	public List<Admin> getAllAdmin(){
		return adminRepo.findAll();
	}
	
	public String addProfessor(Professor professor) {
		if (professor != null && professor.getProfAdmin() != null && 
				StringUtils.isNotBlank(professor.getProfAdmin().getAdminFullName())) {
			Admin firstByAdminName = adminRepo.findFirstByAdminFullName(professor.getProfAdmin().getAdminFullName());
			if (firstByAdminName != null) {
				firstByAdminName.getProfessors().add(professor);
				adminRepo.save(firstByAdminName);
				return "professor added successfully .... !";
			}
			else {
				professorRepo.save(professor);
				return "professor added successfully .... !";
			}
		}
		else
			return "not data present .... !";
	}
	
	public String approve(String status) {
		List<Registration> updatedlist = new ArrayList<>();
		List<Registration> allByStatus = registrationRepo.findAllByStatus(status);
		for (Registration registration : allByStatus) {
			registration.setStatus(RoleConstant.REG_APPROVED);
			updatedlist.add(registration);
		}
		
		registrationRepo.saveAll(updatedlist);
		
		return "approved all pending student.... !";
	}

}
