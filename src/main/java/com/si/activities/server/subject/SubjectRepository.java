package com.si.activities.server.subject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
  List<Subject> findAllByCourseId(Integer courseId);
}
