package com.si.activities.server.controllers;

import com.si.activities.server.domain.Course;
import com.si.activities.server.dtos.CourseRequest;
import com.si.activities.server.dtos.CourseResponse;
import com.si.activities.server.dtos.mapper.CourseMapper;
import com.si.activities.server.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

  private final CourseService serv;

  @GetMapping
  public List<CourseResponse> getAll() {
    return serv.getAll();
  }

  @GetMapping("/{id}")
  public CourseResponse getCourseById(@PathVariable Integer id) {
    return serv.getById(id);
  }

  @PostMapping
  public Integer create(@RequestBody @Valid CourseRequest course) {
    return serv.create(course);
  }
}
