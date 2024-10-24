package com.si.activities.server.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SubjectDTO(@Positive Integer id, @NotBlank String name, @Positive Integer period, @Positive Integer courseId) {
  public SubjectDTO(@NotBlank String name, @Positive Integer period, @Positive Integer courseId) {
    this(null, name, period, courseId);
  }
}
