package com.si.activities.server.course.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CourseCreateDTO(@NotBlank String name, @Positive Integer periodsNumber) {
}
