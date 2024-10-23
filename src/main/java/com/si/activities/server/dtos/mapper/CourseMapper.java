package com.si.activities.server.dtos.mapper;

import com.si.activities.server.domain.Course;
import com.si.activities.server.dtos.CourseRequest;
import com.si.activities.server.dtos.CourseResponse;
import com.si.activities.server.dtos.Period;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CourseMapper {

  private final PeriodMapper periodMapper;

  public CourseResponse toDTO(Course c) {
    if (c == null) {
      return null;
    }
    Set<Period> periods = new HashSet<>();

    for (com.si.activities.server.domain.Period p : c.getPeriods()) {
      periods.add(periodMapper.toDTO(p));
    }

    return new CourseResponse(c.getId(), c.getName(), periods);
  }

  public Course toEntity(CourseRequest cr) {
    if (cr == null) {
      return null;
    }

    Course c = new Course();
    c.setName(cr.name());

    Set<com.si.activities.server.domain.Period> periods = new HashSet<>();

    for (Period p : cr.periods()) {
      periods.add(periodMapper.toEntity(p));
    }
    c.setPeriods(periods);

    return c;
  }
}
