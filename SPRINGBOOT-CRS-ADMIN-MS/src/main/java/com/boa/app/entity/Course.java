package com.boa.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	private double courseFee;
	private String duration;
	private String courseStartDate;
	
	@ManyToMany(mappedBy = "courses")
	private List<Registration> registrations = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "admin_id", referencedColumnName = "adminId")
	private Admin courseAdmin;
	
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the courseFee
	 */
	public double getCourseFee() {
		return courseFee;
	}
	/**
	 * @param courseFee the courseFee to set
	 */
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * @return the registrations
	 */
	public List<Registration> getRegistrations() {
		return registrations;
	}
	/**
	 * @param registrations the registrations to set
	 */
	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	/**
	 * @return the courseStartDate
	 */
	public String getCourseStartDate() {
		return courseStartDate;
	}
	/**
	 * @param courseStartDate the courseStartDate to set
	 */
	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	/**
	 * @return the courseAdmin
	 */
	public Admin getCourseAdmin() {
		return courseAdmin;
	}
	/**
	 * @param courseAdmin the courseAdmin to set
	 */
	public void setCourseAdmin(Admin courseAdmin) {
		this.courseAdmin = courseAdmin;
	}
	
}
