package com.boa.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.app.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	//@EntityGraph(attributePaths = {"courses.registrations", "professors.students"})
//	List<Admin> findAll();
	
	Admin findFirstByAdminFullName(String name);
}
