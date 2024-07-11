package com.boa.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.app.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

	Course findByCourseName(String courseName);
}
