package com.si.activities.server.dtos.subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SubjectRequest(@Positive Integer id, @NotBlank String name, @Positive Integer period, @Positive Integer courseId) {
  public SubjectRequest(@NotBlank String name, @Positive Integer period, @Positive Integer courseId) {
    this(null, name, period, courseId);
  }
}
