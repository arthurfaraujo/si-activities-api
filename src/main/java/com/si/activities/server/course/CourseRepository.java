package com.si.activities.server.course;

import com.si.activities.server.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Integer> {
  @Query("select s from Subject s where s.course.id = :courseId")
  Set<Subject> findSubjectsByCourseId(@Param("courseId") Integer id);

  @Query("select periodsNumber from Course where id = :id")
  Integer findPeriodsNumberById(@Param("id") Integer id);
}
