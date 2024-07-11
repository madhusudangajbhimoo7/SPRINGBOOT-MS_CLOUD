package com.boa.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int professorId;
	private String professorName;
	private String professorAdd;
	
	@ManyToMany
	private List<Student> students;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Admin profAdmin;
	
	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}
	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	/**
	 * @return the professorName
	 */
	public String getProfessorName() {
		return professorName;
	}
	/**
	 * @param professorName the professorName to set
	 */
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	/**
	 * @return the professorAdd
	 */
	public String getProfessorAdd() {
		return professorAdd;
	}
	/**
	 * @param professorAdd the professorAdd to set
	 */
	public void setProfessorAdd(String professorAdd) {
		this.professorAdd = professorAdd;
	}
	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	/**
	 * @return the profAdmin
	 */
	public Admin getProfAdmin() {
		return profAdmin;
	}
	/**
	 * @param profAdmin the profAdmin to set
	 */
	public void setProfAdmin(Admin profAdmin) {
		this.profAdmin = profAdmin;
	}
	
}
