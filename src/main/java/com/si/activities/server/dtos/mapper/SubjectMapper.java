package com.si.activities.server.dtos.mapper;

import com.si.activities.server.domain.Course;
import com.si.activities.server.domain.Subject;
import com.si.activities.server.dtos.SubjectDTO;
import com.si.activities.server.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMapper {
  private final CourseService courseService;

  public SubjectDTO toDTO(Subject s) {
    if (s == null) {
      return null;
    }

    return new SubjectDTO(s.getId(), s.getName(), s.getPeriod(), s.getCourse().getId());
  }

  public Subject toEntity(SubjectDTO sd) {
    if (sd == null) {
      return null;
    }

    Subject s= new Subject();
    s.setName(sd.name());
    s.setPeriod(sd.period());

    Course c = courseService.getEntityById(sd.courseId());
    s.setCourse(c);

    return s;
  }
}
