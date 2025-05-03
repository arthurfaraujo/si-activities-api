package com.si.activities.server.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record UserResponseDTO(Integer id, @NotBlank String name, @NotBlank String nickname, @NotBlank String email) {
}
