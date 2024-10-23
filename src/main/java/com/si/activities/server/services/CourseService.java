package com.si.activities.server.services;

import com.si.activities.server.domain.Course;
import com.si.activities.server.dtos.CourseRequest;
import com.si.activities.server.dtos.CourseResponse;
import com.si.activities.server.dtos.mapper.CourseMapper;
import com.si.activities.server.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
  private final CourseRepository repo;
  private final CourseMapper courseMapper;

  public CourseResponse getById(Integer id) {
    Course course = repo.getReferenceById(id);
    return courseMapper.toDTO(course);
  }

  public List<CourseResponse> getAll() {
    return repo.findAll().stream().map(courseMapper::toDTO).toList();
  }

  public Integer create(CourseRequest newCourse) {
    return repo.save(courseMapper.toEntity(newCourse)).getId();
  }
}
