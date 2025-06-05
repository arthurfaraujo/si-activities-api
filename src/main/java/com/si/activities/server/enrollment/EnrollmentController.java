package com.si.activities.server.enrollment;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.si.activities.server.enrollment.dtos.EnrollmentCreateDTO;
import com.si.activities.server.enrollment.dtos.EnrollmentDTO;
import com.si.activities.server.user.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
@Validated
public class EnrollmentController {
  
  private final EnrollmentService serv;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EnrollmentDTO create(@AuthenticationPrincipal User user, @RequestBody EnrollmentCreateDTO enrollment) {
    enrollment = new EnrollmentCreateDTO(user.getId(), enrollment.classId());

    return serv.create(enrollment);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void unenroll(Integer courseId) {
    
  }
}
