package com.si.activities.server.dtos.activity;

import com.si.activities.server.domain.Activity;
import com.si.activities.server.domain.Subject;
import com.si.activities.server.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityMapper {
  private final SubjectService subjectService;

  public ActivityResponse toDTO(Activity a) {
    if (a == null) {
      return null;
    }

    return new ActivityResponse(
        a.getId(),
        a.getName(),
        a.getDescription(),
        a.getSubject().getId(),
        a.getStartDate(),
        a.getEndDate(),
        a.getIsActive()
    );
  }

  public Activity toEntity(ActivityRequest ar) {
    if (ar == null) {
      return null;
    }

    Activity a = new Activity();
    a.setName(ar.name());
    a.setDescription(ar.description());
    a.setStartDate(ar.startDate());
    a.setEndDate(ar.endDate());

    Subject s = subjectService.getEntityById(ar.subjectId());

    a.setSubject(s);

    return a;
  }
}
