package com.boa.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminFullName;
	
	
	@OneToMany(mappedBy = "profAdmin", cascade = CascadeType.ALL)
	private List<Professor> professors = new ArrayList<>();
	
	@OneToMany(mappedBy = "courseAdmin", cascade = CascadeType.ALL)
//	@JoinTable(name = "admin_course", joinColumns = @JoinColumn(referencedColumnName = "adminId"), inverseJoinColumns = @JoinColumn(referencedColumnName = "courseId"))
	private List<Course> courses = new ArrayList<>();
	
	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}
	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	/**
	 * @return the adminFullName
	 */
	public String getAdminFullName() {
		return adminFullName;
	}
	/**
	 * @param adminFullName the adminFullName to set
	 */
	public void setAdminFullName(String adminFullName) {
		this.adminFullName = adminFullName;
	}
	/**
	 * @return the professors
	 */
	public List<Professor> getProfessors() {
		return professors;
	}
	/**
	 * @param professors the professors to set
	 */
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
