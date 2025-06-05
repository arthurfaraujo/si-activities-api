package com.si.activities.server.subject.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SubjectCreateDTO(@Positive Integer id, @NotBlank String name, @Positive Integer period, @Positive Integer courseId) {
  public SubjectCreateDTO(@NotBlank String name, @Positive Integer period, @Positive Integer courseId) {
    this(null, name, period, courseId);
  }
}
