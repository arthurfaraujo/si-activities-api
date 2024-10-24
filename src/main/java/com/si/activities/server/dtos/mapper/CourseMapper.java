package com.si.activities.server.dtos.mapper;

import com.si.activities.server.domain.Course;
import com.si.activities.server.dtos.CourseRequest;
import com.si.activities.server.dtos.CourseResponse;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

  public CourseResponse toDTO(Course c) {
    if (c == null) {
      return null;
    }

    return new CourseResponse(c.getId(), c.getName(), c.getPeriodsNumber());
  }

  public Course toEntity(CourseRequest cr) {
    if (cr == null) {
      return null;
    }

    Course c = new Course();
    c.setName(cr.name());
    c.setPeriodsNumber(cr.periodsNumber());
    return c;
  }
}
