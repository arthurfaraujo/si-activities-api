package com.si.activities.server.enrollment.dtos;

import com.si.activities.server.classes.Class;
import com.si.activities.server.enrollment.Enrollment;
import com.si.activities.server.classes.ClassService;
import com.si.activities.server.user.User;
import com.si.activities.server.user.UserService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnrollmentMapper {

  private final ClassService classService;
  private final UserService userService;

  public EnrollmentDTO toDTO(@NotNull Enrollment entity) {
    return new EnrollmentDTO(
        entity.getUser().getId(),
        entity.getClass1().getId(),
        entity.getEnrollmentDate());
  }

  public Enrollment toEntity(@NotNull EnrollmentCreateDTO dto) {
    User user = userService.getEntityById(dto.userId());
    Class class1 = classService.getEntityById(dto.classId());

    Enrollment enrollment = new Enrollment();
    enrollment.setUser(user);
    enrollment.setClass1(class1);

    return enrollment;
  }
}
