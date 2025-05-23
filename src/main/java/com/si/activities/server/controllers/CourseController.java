package com.si.activities.server.controllers;

import com.si.activities.server.dtos.course.CourseCreateDTO;
import com.si.activities.server.dtos.course.CourseDTO;
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
  public List<CourseDTO> getAll() {
    return serv.getAll();
  }

  @GetMapping("/{id}")
  public CourseDTO getCourseById(@PathVariable Integer id) {
    return serv.getById(id);
  }

  @PostMapping
  public Integer create(@RequestBody @Valid CourseCreateDTO course) {
    return serv.create(course);
  }
}
