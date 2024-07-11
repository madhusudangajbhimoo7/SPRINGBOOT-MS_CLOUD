package com.boa.app.repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.app.entity.Registration;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Integer>{
	
	@Query("SELECT r from Registration r where r.status = :status")
	List<Registration> findAllByStatus(String status);

}
