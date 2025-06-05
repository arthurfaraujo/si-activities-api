package com.si.activities.server.course;

import com.si.activities.server.course.dtos.CourseMapper;
import com.si.activities.server.course.dtos.CourseCreateDTO;
import com.si.activities.server.course.dtos.CourseDTO;
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

  public CourseDTO getById(Integer id) {
    return repo.findById(id).map(courseMapper::toDTO).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
  }

  public Integer getPeriodsNumberById(Integer id) {
    return repo.findPeriodsNumberById(id);
  }

  public Course getEntityById(Integer id) {
    return repo.getReferenceById(id);
  }

  public List<CourseDTO> getAll() {
    return repo.findAll().stream().map(courseMapper::toDTO).toList();
  }

  public Integer create(CourseCreateDTO newCourse) {
    return repo.save(courseMapper.toEntity(newCourse)).getId();
  }
}
