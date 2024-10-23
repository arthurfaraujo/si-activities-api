package com.si.activities.server.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CourseResponse(@NotNull Integer id, @NotBlank String name, @Positive Integer periodsTotal) {
}
