package com.si.activities.server.enrollment;

import org.springframework.stereotype.Service;

import com.si.activities.server.enrollment.dtos.EnrollmentCreateDTO;
import com.si.activities.server.enrollment.dtos.EnrollmentDTO;
import com.si.activities.server.enrollment.dtos.EnrollmentMapper;
import com.si.activities.server.classes.ClassService;
import com.si.activities.server.user.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

  private final ClassService classService;
  private final UserService userService;
  private final EnrollmentRepository repo;
  private final EnrollmentMapper mapper;

  public EnrollmentDTO create(EnrollmentCreateDTO newEnrollment) {
    Enrollment enrollment = new Enrollment();

    userService.getById(newEnrollment.userId());
    classService.getById(newEnrollment.classId());

    enrollment.setUser(userService.getEntityById(newEnrollment.userId()));
    enrollment.setClass1(classService.getEntityById(newEnrollment.classId()));

    return mapper.toDTO(repo.save(enrollment));
  }
}
