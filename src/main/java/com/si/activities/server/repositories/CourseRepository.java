package com.si.activities.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
