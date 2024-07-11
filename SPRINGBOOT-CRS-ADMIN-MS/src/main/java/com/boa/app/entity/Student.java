package com.boa.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String studentAdd;

	@OneToOne(cascade = CascadeType.ALL)
	private Registration registration;

	@ManyToMany(mappedBy = "students")
	private List<Professor> professors = new ArrayList<>();

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentAdd
	 */
	public String getStudentAdd() {
		return studentAdd;
	}

	/**
	 * @param studentAdd the studentAdd to set
	 */
	public void setStudentAdd(String studentAdd) {
		this.studentAdd = studentAdd;
	}

	/**
	 * @return the registration
	 */

	public Registration getRegistration() {
		return registration;
	}

	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(Registration registration) {
		this.registration = registration;
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

}
