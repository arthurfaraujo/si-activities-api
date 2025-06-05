package com.si.activities.server.activity.dtos;

import com.si.activities.server.activity.Activity;
import com.si.activities.server.classes.Class;
import com.si.activities.server.classes.ClassService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityMapper {

  private final ClassService classService;

  public ActivityDTO toDTO(Activity a) {
    if (a == null) {
      return null;
    }

    return new ActivityDTO(
        a.getId(),
        a.getName(),
        a.getDescription(),
        a.getSchoolClass().getId(),
        a.getStartDate(),
        a.getEndDate(),
        a.getIsActive()
    );
  }

  public Activity toEntity(ActivityCreateDTO ac) {
    if (ac == null) {
      return null;
    }

    Activity a = new Activity();
    a.setName(ac.name());
    a.setDescription(ac.description());
    a.setStartDate(ac.startDate());
    a.setEndDate(ac.endDate());

    Class c = classService.getEntityById(ac.classId());

    a.setSchoolClass(c);

    return a;
  }
}
