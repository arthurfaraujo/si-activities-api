package com.si.activities.server.course.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CourseDTO(@NotNull Integer id, @NotBlank String name, @Positive Integer periodsNumber) {
}
