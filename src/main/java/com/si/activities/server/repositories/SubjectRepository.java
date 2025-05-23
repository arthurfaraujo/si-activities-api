package com.si.activities.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
  List<Subject> findAllByCourseId(Integer courseId);
}
