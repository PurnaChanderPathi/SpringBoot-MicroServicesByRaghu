package com.app.purna.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.purna.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
