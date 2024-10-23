package com.si.activities.server.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CourseRequest(@NotBlank String name, @Positive Integer periodsTotal) {
}
