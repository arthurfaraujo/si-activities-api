package com.si.activities.server.dtos.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CourseRequest(@NotBlank String name, @Positive Integer periodsNumber) {
}
