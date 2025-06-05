package com.si.activities.server.subject.dtos;

import com.si.activities.server.course.Course;
import com.si.activities.server.subject.Subject;
import com.si.activities.server.course.CourseService;
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

    return new SubjectDTO(s.getId(), s.getName(), s.getPeriod(), s.getCourse().getName());
  }

  public Subject toEntity(SubjectCreateDTO sd) {
    if (sd == null) {
      return null;
    }

    Subject s = new Subject();
    s.setName(sd.name());
    s.setPeriod(sd.period());

    Course c = courseService.getEntityById(sd.courseId());
    s.setCourse(c);

    return s;
  }
}
