package com.si.activities.server.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CourseResponse(@NotNull Integer id, @NotBlank String name, @NotNull Set<Period> periods) {
}
