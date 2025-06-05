package com.si.activities.server.enrollment.dtos;

public record EnrollmentCreateDTO(Integer userId, Integer classId) {
  EnrollmentCreateDTO(Integer classId) {
    this(null, classId);
  }
}
