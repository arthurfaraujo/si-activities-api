package com.si.activities.server.subject.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SubjectDTO(@Positive Integer id, @NotBlank String name, @Positive Integer period, @NotBlank String courseName) {
  public SubjectDTO(@NotBlank String name, @Positive Integer period, @NotBlank String courseName) {
    this(null, name, period, courseName);
  }
}
