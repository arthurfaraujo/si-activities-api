package com.si.activities.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.si.activities.server.domain.Activity;
import com.si.activities.server.domain.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
  List<Subject> findAllByCourseId(Integer courseId);
  
  @Query("select a from Activity a where a.subject.id = :subjectId")
  List<Activity> findActivitiesBySubjectId(@Param("subjectId") Integer subjectId);
}
