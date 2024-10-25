package com.si.activities.server.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SubjectResponse(@Positive Integer id, @NotBlank String name, @Positive Integer period, @NotBlank String courseName) {
  public SubjectResponse(@NotBlank String name, @Positive Integer period, @NotBlank String courseName) {
    this(null, name, period, courseName);
  }
}
