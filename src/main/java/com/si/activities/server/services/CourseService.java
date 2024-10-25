package com.si.activities.server.services;

import com.si.activities.server.domain.Activity;
import com.si.activities.server.domain.Course;
import com.si.activities.server.dtos.CourseRequest;
import com.si.activities.server.dtos.CourseResponse;
import com.si.activities.server.dtos.mapper.CourseMapper;
import com.si.activities.server.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
  private final CourseRepository repo;
  private final CourseMapper courseMapper;

  public CourseResponse getById(Integer id) {
    return repo.findById(id).map(courseMapper::toDTO).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
  }

  public Course getEntityById(Integer id) {
    return repo.getReferenceById(id);
  }

  public List<CourseResponse> getAll() {
    return repo.findAll().stream().map(courseMapper::toDTO).toList();
  }

  public Integer create(CourseRequest newCourse) {
    return repo.save(courseMapper.toEntity(newCourse)).getId();
  }
}
