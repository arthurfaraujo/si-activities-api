package com.si.activities.server.dtos.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Period(@NotNull Integer id, @NotBlank String description) {
}
