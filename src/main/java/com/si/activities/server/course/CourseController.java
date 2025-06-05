package com.si.activities.server.course;

import com.si.activities.server.course.dtos.CourseCreateDTO;
import com.si.activities.server.course.dtos.CourseDTO;
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
