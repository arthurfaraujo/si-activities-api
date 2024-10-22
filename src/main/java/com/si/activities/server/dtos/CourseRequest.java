package com.si.activities.server.dtos;

import com.si.activities.server.domain.Period;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record CourseRequest(@NotBlank String name, Set<Period> periods) {
}
